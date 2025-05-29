package com.ps;

public class PremiumTop extends Topping{
    private double price;

    public PremiumTop(String name, double price) {
        super(name);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
