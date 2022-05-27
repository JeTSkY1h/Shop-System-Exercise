package com.example;

import java.util.*;

/**
 * Hello world!
 *
 */
public class ShopService {
    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    Product getProduct(String id) {
        return productRepo.get(id);
    }

    HashMap<String, Product> listProducts(){
        return this.productRepo.list();
    }

    HashMap<String, Order> listOrders(){
        return orderRepo.list();
    }

    void addOrder(Order order) {
        HashSet<String> productKeys = new HashSet<>(this.listProducts().keySet());
        productKeys.addAll(order.listProducts().keySet());
        productKeys.removeAll(this.listProducts().keySet());
        System.out.println(productKeys);
        if (productKeys.size() > 0) {
            throw new RuntimeException("Mindestens ein bestelltes Product gibt es nicht.");
        }
        orderRepo.add(order);
    }

    Order getOrder(String id) {
        return orderRepo.get(id);
    }

}
