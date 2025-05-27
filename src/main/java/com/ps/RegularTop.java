package com.ps;

public class RegularTop extends Topping {
    public RegularTop(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(int sandwichSize) {
        return 0.0;
    }
}
