package com.codemanship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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

    @Test
    void orderContainsQuantityOfOneForProduct() {
        Order order = new Order();
        Product product = new Product(7, 0);
        order.addItem(product, 1);
        assertEquals(1, order.getQuantityForItem(product));
    }

    @Test
    void cannotAddItemsIfUnsufficientStock() {
        Order order = new Order();
        Product product = new Product(1, 0);
        assertThrows(InsufficientStockException.class, () -> order.addItem(product, 2));
    }

    // Regression test, explicitly required in customer scenario
    @Test
    void orderContainsNoItemsIfUnsufficientStock() {
        Order order = new Order();
        Product product = new Product(1, 0);
        try {
            order.addItem(product, 2);
            fail("Exception expected");
        } catch (RuntimeException e) {
            // expected
        }
        assertFalse(order.containsItemForProduct(product));
    }

}
