package com.example.productservices.services;

import com.example.productservices.exceptions.ProductNotFoundException;
import com.example.productservices.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductService{

    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        //make a DB call to get a product with given id
        //select * from products where id = ? ;
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
