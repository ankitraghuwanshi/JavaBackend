package com.example.productservices.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categories") //defaultName = category
public class Category extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
