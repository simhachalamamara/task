package com.example.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductList {
    private List<Product> product;
    public ProductList()
    {
        product=new ArrayList<>();
    }
}
