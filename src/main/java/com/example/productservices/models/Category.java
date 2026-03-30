package com.example.productservices.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "categories") //defaultName = category
public class Category extends BaseModel {
    private String name;
}
