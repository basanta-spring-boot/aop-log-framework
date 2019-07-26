package com.example.demo.service;

import com.example.demo.bean.Product;
import com.example.demo.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao dao;

    public Product addProduct(Product p) {
        return dao.addProduct(p);
    }

    public List<Product> findAllProducts() {
        return dao.getProducts();
    }

    public Product findProductById(int id) {
        return dao.findById(id);
    }
}
