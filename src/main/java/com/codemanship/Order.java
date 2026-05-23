package com.codemanship;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Product> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        product.holdStock(quantity);
        items.add(product);
    }

    public boolean containsItemForProduct(Product product) {
        return items.contains(product);
    }
}
