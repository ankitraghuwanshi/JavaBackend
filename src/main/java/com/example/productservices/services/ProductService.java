package com.example.productservices.services;

import com.example.productservices.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long productId);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product replaceProduct(Long id, Product product);

    void deleteProduct(Long id);
}
