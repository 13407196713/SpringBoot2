package com.example.springboot2.repository;

import com.example.springboot2.model.AyProduct;
import org.springframework.data.jpa.repository.JpaRepository;

// 商品的增删改查 CRUD
public interface ProductRepository extends JpaRepository<AyProduct,Integer> {

}
