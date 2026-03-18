package com.example.productservices.services;

import com.example.productservices.models.Product;

public interface ProductService {
    Product getProductById(long productId);
}
