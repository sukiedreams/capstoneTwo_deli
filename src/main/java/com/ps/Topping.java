package com.ps;

public abstract class Topping {
    protected String name;
    protected boolean isExtra;

    public Topping(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public abstract double getPrice(int sandwichSize);

    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return isExtra;
    }
}
