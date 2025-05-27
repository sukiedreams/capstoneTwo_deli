package com.ps;

public class Chips implements Product {
    private String type;

    public Chips(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return type + "Chips";
    }

    @Override
    public double getPrice() {
        return 1.50;
    }
}
