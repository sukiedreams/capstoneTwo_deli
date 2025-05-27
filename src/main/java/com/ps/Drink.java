package com.ps;

public class Drink implements Product {
    private String flavor;
    private  String size;

    public Drink(String flavor, String size) {
        this.flavor = flavor;
        this.size = size;
    }

    @Override
    public String getName() {
        return size + "" + flavor + " Drink";
    }

    @Override
    public double getPrice() {
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.0;
        };
    }
}
