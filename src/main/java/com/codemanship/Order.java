package com.codemanship;

public class Order {
    public void addItem(Product product, int quantity) {
        product.holdStock(quantity);
    }

    public boolean containsItemForProduct(Product product) {
        return true;
    }
}
