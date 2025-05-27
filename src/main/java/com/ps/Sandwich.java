package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Product {
    private int size;
    private String  bread;
    private boolean toasted;
    private List<Topping> toppings = new ArrayList<>();

    public Sandwich(int size, String bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
    }

    @Override
    public String getName() {
        return size + "\"" + bread + "Sandwich";
    }
//TODO come back to this.
    @Override
    public double getPrice() {
        double sizePrice = switch (size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0.0;
        };

        for (Topping topping : toppings) {
            sizePrice += topping.getPrice(size);
        }
        return sizePrice;
    }
}
