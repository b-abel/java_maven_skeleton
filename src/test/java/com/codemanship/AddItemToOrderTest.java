package com.codemanship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddItemToOrderTest {
    @Test
    void addingItemWIthSufficientStockPutsSaleQuantityOnHold(){
        Product product = new Product(7, 0);
        Order order = new Order();
        order.addItem(product, 1);
        assertEquals(1, product.getHold());
    }

    @Test
    void addingItemWithQuantityOfTwoPutsTwoStockOnHold(){
        Product product = new Product(7, 0);
        Order order = new Order();
        order.addItem(product, 2);
        assertEquals(2, product.getHold());
    }

    @Test
    void orderContainsItemForSelectedProduct(){
        Order order = new Order();
        Product product = new Product(7, 0);
        order.addItem(product, 1);
        assertTrue(order.containsItemForProduct(product) );
    }

    @Test
    void orderDoesNotContainItemForUnselectedProduct() {
        Order order = new Order();
        Product product = new Product(7, 0);
        assertFalse(order.containsItemForProduct(product));
    }


}
