package com.example;

import java.util.*;

public class Order {
    private final String id = UUID.randomUUID().toString();
    private HashMap<String, Product> products;

    Order(HashMap<String, Product> products) {
        this.products = products;
    }

    public HashMap<String, Product> listProducts() {
        return this.products;
    }

    public String getId() {
        return id;
    }

    
}