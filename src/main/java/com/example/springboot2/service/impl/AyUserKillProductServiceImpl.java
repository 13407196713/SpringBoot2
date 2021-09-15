package com.example.springboot2.service.impl;

import com.example.springboot2.model.AyUserKillProduct;
import com.example.springboot2.repository.AyUserKillProductRepository;
import com.example.springboot2.service.AyUserKillProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AyUserKillProductServiceImpl implements AyUserKillProductService {

    @Resource
    private AyUserKillProductRepository ayUserKillProductRepository;

    //保存用户秒杀商品记录
    //@param killProduct
    @Override
    public AyUserKillProduct save(AyUserKillProduct killProduct) {
        return ayUserKillProductRepository.save(killProduct);
    }
}
