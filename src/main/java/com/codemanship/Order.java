package com.codemanship;

public class Order {
    public void addItem(Product product, int quantity) {
        product.holdStock(quantity);
    }

    public boolean containItemForProduct(Product product) {
        return true;
    }
}
