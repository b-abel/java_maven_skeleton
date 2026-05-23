package com.codemanship;

public class Product {
    private int hold;

    public Product(int stock, int hold) {
        this.hold = hold;
    }

    public int getHold() {
        return hold;
    }

    public void holdStock(int quantity) {
        hold += quantity;
    }
}
