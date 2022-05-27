package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;


import org.junit.Test;

public class ShopServiceTest {
    //Sample products
    Product plumbus = new Product("Plumbus");
    Product lappenLauch  = new Product("LappenLauch");
    Product lappen = new Product("Apfel");
    Product lauch = new Product("");

    @Test
    public void shouldListProducts() {
        //given
        HashMap<String, Product> orderList = new HashMap<>();
        orderList.put(plumbus.getId(),plumbus);
        orderList.put(lappenLauch.getId(),lappenLauch);
        Order order = new Order(orderList);

        HashMap<String, Order> orders = new HashMap<>();
        orders.put(order.getId(), order);

        HashMap<String, Product> products = new HashMap<>();
        products.put(plumbus.getId(), plumbus);
        products.put(lappenLauch.getId(), lappenLauch);
        products.put(lappen.getId(), lappen);
        products.put(lauch.getId(), lauch);

        ProductRepo productRepo = new ProductRepo(products);
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //then1
        HashMap<String, Product> res = shopService.listProducts();
        //when
        assertEquals(products, res);
        

    }

    @Test
    public void shouldGetProduct() {
        //given
        HashMap<String, Product> orderList = new HashMap<>();
        orderList.put(plumbus.getId(),plumbus);
        orderList.put(lappenLauch.getId(),lappenLauch);
        Order order = new Order(orderList);

        HashMap<String, Order> orders = new HashMap<>();
        orders.put(order.getId(), order);

        HashMap<String, Product> products = new HashMap<>();
        products.put(plumbus.getId(), plumbus);
        products.put(lappenLauch.getId(), lappenLauch);
        products.put(lappen.getId(), lappen);
        products.put(lauch.getId(), lauch);

        ProductRepo productRepo = new ProductRepo(products);
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //then
        Product res = shopService.getProduct(plumbus.getId());

        assertEquals(plumbus.getId(), res.getId());
    }

    @Test
    public void shouldListOrders() {
        //given
        HashMap<String, Product> orderList = new HashMap<>();
        orderList.put(plumbus.getId(),plumbus);
        orderList.put(lappenLauch.getId(),lappenLauch);
        Order order = new Order(orderList);

        HashMap<String, Order> orders = new HashMap<>();
        orders.put(order.getId(), order);
        HashMap<String, Product> products = new HashMap<>();
        products.put(plumbus.getId(), plumbus);
        products.put(lappenLauch.getId(), lappenLauch);
        products.put(lappen.getId(), lappen);
        products.put(lauch.getId(), lauch);

        ProductRepo productRepo = new ProductRepo(products);
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //then
        HashMap<String, Order> res = shopService.listOrders();

        assertEquals(res, orders);
    }

    @Test
    public void shouldAddOrder() {
        //given
        HashMap<String, Product> orderList = new HashMap<>();
        HashMap<String, Product> orderList2 = new HashMap<>();
        orderList.put(plumbus.getId(),plumbus);
        orderList.put(lappenLauch.getId(),lappenLauch);
        Order order = new Order(orderList);
        orderList2.put(lauch.getId(),lauch);
        orderList2.put(lappen.getId(),lappen);
        Order orderToAdd = new Order(orderList2);

        HashMap<String, Order> orders = new HashMap<>();
        orders.put(order.getId(), order);

        HashMap<String, Product> products = new HashMap<>();
        products.put(plumbus.getId(), plumbus);
        products.put(lappenLauch.getId(), lappenLauch);
        products.put(lappen.getId(), lappen);
        products.put(lauch.getId(), lauch);

        ProductRepo productRepo = new ProductRepo(products);
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //then
        shopService.addOrder(orderToAdd);
        HashMap<String,Order> expected = new HashMap<>();
        expected.put(order.getId(),order);
        expected.put(orderToAdd.getId(),orderToAdd);

        assertEquals(expected, shopService.listOrders());

    }

    @Test
    public void shouldGetOrder() {
        //given
        HashMap<String, Product> orderList = new HashMap<>();
        orderList.put(plumbus.getId(),plumbus);
        orderList.put(lappenLauch.getId(),lappenLauch);
        Order order = new Order(orderList);

        HashMap<String, Order> orders = new HashMap<>();
        orders.put(order.getId(), order);

        HashMap<String, Product> products = new HashMap<>();
        products.put(plumbus.getId(), plumbus);
        products.put(lappenLauch.getId(), lappenLauch);
        products.put(lappen.getId(), lappen);
        products.put(lauch.getId(), lauch);

        ProductRepo productRepo = new ProductRepo(products);
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //then

        Order res = shopService.getOrder(order.getId());

        assertEquals(order, res);
    }

    @Test
    public void shouldThrowExceptionCauseOrderedProductIsNotInRepo() {
        //given
        HashMap<String, Product> orderList2 = new HashMap<>();
        orderList2.put(plumbus.getId(),plumbus);
        orderList2.put(lappenLauch.getId(),lappenLauch);
        orderList2.put(lauch.getId(),lauch);
        orderList2.put(lappen.getId(),lappen);

        Order orderToAdd = new Order(orderList2);
        HashMap<String, Product> orderList = new HashMap<>();
        orderList.put(plumbus.getId(),plumbus);
        orderList.put(lappenLauch.getId(),lappenLauch);
        Order order = new Order(orderList);

        HashMap<String, Order> orders = new HashMap<>();
        orders.put(order.getId(), order);
        
        HashMap<String, Product> products = new HashMap<>();
        products.put(plumbus.getId(), plumbus);
        products.put(lappenLauch.getId(), lappenLauch);
        products.put(lauch.getId(), lauch);
        
        ProductRepo productRepo = new ProductRepo(products);
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService shopService = new ShopService(productRepo, orderRepo);
        
        boolean thrown = false;
        //then
        try {
            shopService.addOrder(orderToAdd);
        } catch (Exception e) {
            thrown = true;
        }

        assertTrue(thrown);

    }
}
