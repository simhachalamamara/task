package com.js.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="product")
public class Product {
    @Id
    private int id;
    @Column(name="productname")
    private String productname;
    private double price;
    public Product()
    {

    }
}
