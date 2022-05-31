package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class OrderRepo {
    private Map<String, Order> orders = new HashMap<>();

    OrderRepo(List<Order> orders) {
        this.orders = orders.stream()
            .collect(Collectors.toMap(order->order.getId(), order -> order));
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