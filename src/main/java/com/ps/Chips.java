package com.ps;

public class Chips implements Product {
    private String flavor;

    public Chips(String flavor) {
        this.flavor = flavor;
    }
    @Override
    public double calPrice() {
        return 1.50;
    }

    @Override
    public String getDetails() {
        return flavor + "Chips";
    }
}
