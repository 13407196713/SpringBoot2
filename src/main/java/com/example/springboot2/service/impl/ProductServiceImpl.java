package com.example.springboot2.service.impl;

import com.example.springboot2.model.AyProduct;
import com.example.springboot2.model.AyUserKillProduct;
import com.example.springboot2.model.KillStatus;
import com.example.springboot2.repository.ProductRepository;
import com.example.springboot2.service.AyUserKillProductService;
import com.example.springboot2.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;


// 商品服务
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductRepository productRepository;

    @Resource
    private AyUserKillProductService ayUserKillProductService;

    //日志
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    // 查询所有商品
    @Override
    public List<AyProduct> findAll() {
        try{
            List<AyProduct> ayProducts = productRepository.findAll();
            return ayProducts;
        }catch (Exception e){
            logger.error("ProductServiceImpl.findAll error", e);
            return Collections.EMPTY_LIST;
        }
    }

    // 秒杀商品
    // @param productId 商品id
    // @param userId 用户id
    @Override
    public AyProduct killProduct(Integer productId, Integer userId) {
        //查询商品
        AyProduct ayProduct = productRepository.findById(productId).get();
        //判断商品是否还有库存
        if(ayProduct.getNumber() < 0){
            return null;
        }
        //设置商品的库存：原库存数量 - 1
        ayProduct.setNumber(ayProduct.getNumber() - 1);
        //更新商品库存
        ayProduct = productRepository.save(ayProduct);

        //保存商品的秒杀记录
        AyUserKillProduct killProduct = new AyUserKillProduct();
        killProduct.setCreateTime(new Date());
        killProduct.setProductId(productId);
        killProduct.setUserId(userId);
        //设置秒杀状态
        killProduct.setState(KillStatus.SUCCESS.getCode());
        //保存秒杀记录详细信息
        ayUserKillProductService.save(killProduct);

        //商品秒杀成功后，更新缓存中商品库存数量
//        redisTemplate.opsForHash().put(KILL_PRODUCT_LIST, killProduct.getProductId(),ayProduct);
        return ayProduct;
    }

}


