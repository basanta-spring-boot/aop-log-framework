package com.example.demo.controller;

import com.example.demo.bean.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct2Cart(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping("/findAllProducts")
    public List<Product> findAllProducts() {
        return service.findAllProducts();
    }

    @GetMapping("/findProduct/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.findProductById(id);
    }
}
