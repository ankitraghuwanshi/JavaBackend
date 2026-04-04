package com.example.productservices.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products") //defaultName = product
public class Product extends BaseModel {
    private String title;
    private double price;
    private String description;
    private String imageUrl;

    @ManyToOne
    private Category category;
}
