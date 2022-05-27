package com.example;

import java.util.*;

public class Product {
    
    private String name;
    private final String id = UUID.randomUUID().toString();

    Product(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }
}