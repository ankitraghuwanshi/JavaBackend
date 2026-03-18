package com.example.productservices.services;

import com.example.productservices.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long productId);
    List<Product> getAllProducts();
}
