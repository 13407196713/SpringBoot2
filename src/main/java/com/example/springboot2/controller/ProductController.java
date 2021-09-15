package com.example.springboot2.controller;

import com.example.springboot2.model.AyProduct;
import com.example.springboot2.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Resource
    private ProductService productService;

    //查询所有的商品
    @RequestMapping("/all")
    public String findAll(Model model){
        List<AyProduct> products = productService.findAll();
        model.addAttribute("products", products);
        return "product_list";
    }

//    // 查询所有的商品（缓存）
//    @RequestMapping("/all/cache")
//    public String findAllCache(Model model){
//        Collection<AyProduct> products = productService.findAllCache();
//        model.addAttribute("products", products);
//        return "product_list";
//    }

    // 秒杀商品
    @RequestMapping("/{id}/kill")
    public String killProduct(Model model,
                              @PathVariable("id") Integer productId,
                              @RequestParam("userId") Integer userId){
        AyProduct ayProduct = productService.killProduct(productId, userId);
        if(null != ayProduct){
            return "success";
        }
        return "fail";
    }
}

