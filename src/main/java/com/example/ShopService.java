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
        for (Product product: order.listProducts())   {
            this.getProduct(product.getId());
        }
        orderRepo.add(order);
    }

    Order getOrder(String id) {
        return orderRepo.get(id);
    }

}
