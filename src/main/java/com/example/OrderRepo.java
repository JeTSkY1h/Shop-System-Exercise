package com.example;

import java.util.*;

public class OrderRepo {
    private HashMap<String, Order> orders = new HashMap<>();

    OrderRepo(HashMap<String, Order> orders) {
        this.orders = orders;
    }

    public HashMap<String, Order> list() {
        return orders;
    }

    public Order get(String id) {
        return orders.get(id);
    }

    public void add(Order order) {
        orders.put(order.getId(),order);
    }

}