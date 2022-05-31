package com.example;

import java.util.*;

public class Order {
    private final String id = UUID.randomUUID().toString();
    private List<Product> products;

    Order(List<Product> products) {
        this.products = products;
    }

    public List<Product> listProducts() {
        return this.products;
    }

    public String getId() {
        return id;
    }

    
}