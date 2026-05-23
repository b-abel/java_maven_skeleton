package com.codemanship;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<Product, Integer> items = new HashMap<>();

    public void addItem(Product product, int quantity) {
        product.holdStock(quantity);
        items.put(product, quantity);
    }

    public boolean containsItemForProduct(Product product) {
        return items.containsKey(product);
    }

    public int getQuantityForItem(Product product) {
        return items.get(product);
    }

}
