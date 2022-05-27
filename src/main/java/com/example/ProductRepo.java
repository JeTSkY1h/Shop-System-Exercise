package com.example;

import java.util.*;

public class ProductRepo {
    private HashMap<String, Product> products = new HashMap<>();

    ProductRepo(HashMap<String, Product> products) {
        this.products = products;
    }

    public HashMap<String, Product> list(){
        return this.products;
    }

    public Product get(String id){
        return products.get(id);
    }

}