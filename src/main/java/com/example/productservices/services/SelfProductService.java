package com.example.productservices.services;

import com.example.productservices.exceptions.ProductNotFoundException;
import com.example.productservices.models.Category;
import com.example.productservices.models.Product;
import com.example.productservices.repositories.CategoryRepository;
import com.example.productservices.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        //make a DB call to get a product with given id
        //select * from products where id = ? ;
        Optional<Product> optionalProduct= productRepository.findById(productId);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("product with " + productId + " doesn't exist");
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        //before saving the product in DB,
        //we should first check if category present in DB or not ,
        //if yes then good,
        //if no then first save category in DB, then save product

        Optional<Category> optionalCategory = categoryRepository.findByName(category.getName());
        if(optionalCategory.isEmpty()){
            //save category first
            category=categoryRepository.save(category);
        }
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        Optional<Product> optionalProduct=productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("product with " + id + " doesn't exist");
        }

        Product productFromDB = optionalProduct.get();

        productFromDB.setDescription(product.getDescription());
        productFromDB.setTitle(product.getTitle());
        productFromDB.setImageUrl(product.getImageUrl());
        productFromDB.setPrice(product.getPrice());

        Category category = product.getCategory();
        if(category.getId() == null){
            //first save category in DB
            category = categoryRepository.save(category);
        }
        productFromDB.setCategory(category);

        return productRepository.save(productFromDB);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
