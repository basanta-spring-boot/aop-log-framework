package com.example.demo.dao;

import com.example.demo.bean.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao {

    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void initProductDB() {
        products.add(new Product(11, "Mobile", 20000));
        products.add(new Product(12, "Laptop", 120000));
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findAny().get();
    }
}
