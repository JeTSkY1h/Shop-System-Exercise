package com.example;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;



public class ShopServiceTest {
    //Sample products
    Product plumbus = new Product("Plumbus");
    Product lappenLauch  = new Product("LappenLauch");
    Product apfel = new Product("Apfel");
    Product wasser = new Product("Wasser");
    Product bier = new  Product("Bier");
    Order order = new Order(List.of(apfel,wasser));


    private ShopService buildShop() {
        
        ProductRepo productRepo = new ProductRepo(List.of(plumbus, lappenLauch, apfel, wasser, bier));
        
        OrderRepo orderRepo = new OrderRepo(List.of(order));
        ShopService shopService = new ShopService(productRepo,orderRepo);

        return shopService;

    }

    @Test
    public void shouldListProducts() {
        ShopService shopService = buildShop();
        List<Product> res  = shopService.listProducts();
        assertThat(res).containsAll(List.of(plumbus,lappenLauch,apfel,wasser,bier));
    }

    @Test
    public void shouldGetProduct() {
        ShopService shopService = buildShop();
        Product res = shopService.getProduct(plumbus.getId());

        assertThat(res).isEqualTo(plumbus);
    }

    @Test
    public void shouldListOrders() {
        ShopService shopService = buildShop();

        List<Order> res = shopService.listOrders();

        assertThat(res).containsAll(List.of(order));
    }

    @Test
    public void shouldAddOrder() {
        ShopService shopService = buildShop();

        Order orderToAdd = new Order(List.of(wasser, apfel, bier));
        shopService.addOrder(orderToAdd);
        List<Order> res = shopService.listOrders();
        assertThat(res).containsAll(List.of(order, orderToAdd));
    }

    @Test
    public void shouldGetOrder() {
        ShopService shopService = buildShop();

        Order res = shopService.getOrder(order.getId());

        assertEquals(res, order);

    }

    @Test
    public void shouldThrowExceptionCauseOrderedProductIsNotInRepo() {
        ShopService shopService = buildShop();
        Product test = new Product("test");

        Order orderToAdd = new Order(List.of(wasser,test));
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(()-> {
                shopService.addOrder(orderToAdd);
            }
        );
    }

}
