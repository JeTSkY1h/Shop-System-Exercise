package com.example;

import java.util.UUID;

public class thing {
    private String name;
    private final String id = UUID.randomUUID().toString();


    thing(String name) {
        this.name = name;
    }
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}

