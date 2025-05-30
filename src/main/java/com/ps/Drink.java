package com.ps;

public class Drink implements Product {
    private  String size;

    public Drink(String size) {
        this.size = size.toLowerCase();
    }

    @Override
    public double calPrice() {
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.0;
        };
    }

    @Override
    public String getDetails() {
        return size.substring(0,1).toUpperCase() + size.substring(1) + " Drink";
    }
}
