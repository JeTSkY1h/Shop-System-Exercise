package com.example;

import java.util.*;

public class ShopService {
    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    Product getProductByName(String name){
        Optional<Product> res = productRepo.list().stream()
            .filter(p->p.getName().equals(name))
            .findFirst();
        if(res.isEmpty()) throw new RuntimeException("Ein Produkt mit dem Namem " + name + " Existiert nicht.");
        return res.get();
    }

    Product getProduct(String id) {
        if(!productRepo.get(id).isPresent()) throw new RuntimeException("Ein Produkt mit der ID " + id + " Existiert nicht im Repo." );
        return productRepo.get(id).get();
    }

    List<Product> listProducts(){
        return this.productRepo.list();
    }

    List<Order> listOrders(){
        return orderRepo.list();
    }    

    void addOrder(Order order) {
        order.listProducts().stream()
            .map(p -> this.getProduct(p.getId()))
            .toList();
        orderRepo.add(order);
    }

    Order getOrder(String id) {
        return orderRepo.get(id);
    }

}
