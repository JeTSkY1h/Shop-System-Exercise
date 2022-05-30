package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class ProductRepo {
    private Map<String, Product> products = new HashMap<>();

    ProductRepo(List<Product> productsList) {
        this.products = productsList.stream()
        .collect(Collectors.toMap(p -> p.getId(), p -> p));
    }

    public List<Product> list(){
        return this.products.values().stream().toList();
    }

    public Optional<Product> get(String id){
        return Optional.ofNullable(products.get(id));

    }

}