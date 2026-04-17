package com.example.productservices.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long categoryId){

    }
}
