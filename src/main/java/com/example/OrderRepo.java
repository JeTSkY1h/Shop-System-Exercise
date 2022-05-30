package com.example;

import java.util.*;

public class OrderRepo {
    private Map<String, Order> orders = new HashMap<>();

    OrderRepo(List<Order> orders) {
        for (Order order : orders) {
            this.orders.put(order.getId(),order);            
        }
    }

    public List<Order> list() {
        return orders.values().stream().toList();
    }

    public Order get(String id) {
        return orders.get(id);
    }

    public void add(Order order) {
        orders.put(order.getId(),order);
    }

}