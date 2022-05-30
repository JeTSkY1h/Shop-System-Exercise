package com.example;

import java.util.*;

public class ProductRepo {
    private Map<String, Product> products = new HashMap<>();

    ProductRepo(List<Product> productsList) {
        for (Product product : productsList) {
            this.products.put(product.getId(),product);
        }
    }

    public List<Product> list(){
        return this.products.values().stream().toList();
    }

    public Optional<Product> get(String id){
        return Optional.ofNullable(products.get(id));

    }

}