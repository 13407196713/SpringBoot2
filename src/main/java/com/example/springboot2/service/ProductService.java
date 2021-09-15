package com.example.springboot2.service;

import com.example.springboot2.model.AyProduct;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    //查询所有商品
    List<AyProduct> findAll();

    //查询所有商品
//    Collection<AyProduct> findAllCache();

    // 秒杀商品
    // @param productId 商品id
    // @param userId 用户id
    AyProduct killProduct(Integer productId, Integer userId);
}
