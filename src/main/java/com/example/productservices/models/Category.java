package com.example.productservices.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categories") //defaultName = category
public class Category extends BaseModel {
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
