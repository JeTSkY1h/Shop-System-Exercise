package com.example;

import java.util.*;

public class fruit implements products {
    private String name;
    private final String id = UUID.randomUUID().toString();


    fruit(String name) {
        this.name = name;
    }
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}