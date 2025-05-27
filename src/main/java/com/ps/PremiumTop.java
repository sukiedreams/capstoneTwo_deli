package com.ps;

public class PremiumTop extends Topping{
    public PremiumTop(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(int sandwichSize) {
        // TODO come back to this.
        double premiumPrice = switch (sandwichSize) {
            case 4 -> 1.00;
            case 8 -> 2.00;
            case 12 -> 3.00;
            default -> 0.0;
        };
        return isExtra ? premiumPrice * 1.5 : premiumPrice;
    }
}
