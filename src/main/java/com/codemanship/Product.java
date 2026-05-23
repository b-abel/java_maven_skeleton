package com.codemanship;

public class Product {
    private final int stock;
    private int hold;

    public Product(int stock, int hold) {
        this.stock = stock;
        this.hold = hold;
    }

    public int getHold() {
        return hold;
    }

    public void holdStock(int quantity) {
        hold += quantity;
    }

    public int getStock() {
        return stock;
    }
}
