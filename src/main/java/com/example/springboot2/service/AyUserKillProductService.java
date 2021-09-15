package com.example.springboot2.service;

import com.example.springboot2.model.AyUserKillProduct;

//描述：用户秒杀商品记录接口
public interface AyUserKillProductService {

    /**
     * 保存用户秒杀商品记录
     * @param killProduct
     * @return
     */
    AyUserKillProduct save(AyUserKillProduct killProduct);
}
