package com.example.productservices.controllers;

import com.example.productservices.exceptions.ProductNotFoundException;
import com.example.productservices.models.Product;
import com.example.productservices.services.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id) throws ProductNotFoundException{

//        ResponseEntity<Product> responseEntity=null;
//
//        try{
//            Product product= productService.getProductById(id);
//            responseEntity=new ResponseEntity<>(
//                    product,
//                    HttpStatus.OK
//            );
//        }catch(ProductNotFoundException e){
//            System.out.println(e.getMessage());
//            responseEntity=new ResponseEntity<>(
//                    (HttpHeaders) null,
//                    HttpStatus.BAD_REQUEST
//            );
//        }
//
//        return responseEntity;

        return productService.getProductById(id);
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product){
        return null;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") long id ,@RequestBody Product product){
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") long id ,@RequestBody Product product){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        return ;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException e){
        return new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.SERVICE_UNAVAILABLE
        );
    }
}
