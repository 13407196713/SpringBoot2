package com.example.springboot2.repository;

import com.example.springboot2.model.AyUserKillProduct;
import org.springframework.data.jpa.repository.JpaRepository;

// 描述：用户秒杀商品记录Repository 增删查改 CRUD
public interface AyUserKillProductRepository extends JpaRepository<AyUserKillProduct,Integer> {

}
