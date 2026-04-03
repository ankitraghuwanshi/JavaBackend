package com.example.productservices.repositories;

import com.example.productservices.models.Category;
import com.example.productservices.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long productId);
    //select * from products where id = productId;

    @Override
    List<Product> findAll();
    //select * from products;

    //List<Product> findByTitleContains(String str);
    //select * from products where title like '%str%';

    //List<Product> findByCategory(Category category);

    //List<Product> findByCategory_Id(Long productId);
    //joins query

    @Override
    void deleteById(Long id);
}
