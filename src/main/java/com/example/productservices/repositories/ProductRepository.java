package com.example.productservices.repositories;

import com.example.productservices.models.Category;
import com.example.productservices.models.Product;
import com.example.productservices.projections.ProductWithTitleAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    List<Product> findByTitleContains(String str);
    //select * from products where title like '%str%';

    List<Product> findByCategory(Category category);

    List<Product> findByCategory_Id(Long productId);
    //joins query

    @Override
    void deleteById(Long id);

    //HQL query
    @Query("select p.title as title, p.price as price from Product p where p.title = :title and p.price = :price")
    List<ProductWithTitleAndPrice> getProductTitleAndPrice(@Param("title") String title, @Param("price") Double price);

    //SQL query
    @Query(value="select p.title, p.price from products p where p.title = :title and p.price = :price", nativeQuery = true)
    List<ProductWithTitleAndPrice> getProductTitleAndPriceSQL(@Param("title") String title, @Param("price") Double price);
}
