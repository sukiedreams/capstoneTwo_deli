package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Product {

    private String size;
    private String  bread;
    private boolean toasted;
    private List<PremiumTop> meats = new ArrayList<>();
    private List<PremiumTop> extraMeats = new ArrayList<>();
    private List<PremiumTop> cheeses = new ArrayList<>();
    private List<PremiumTop> extraCheeses = new ArrayList<>();
    private List<RegularTop> regularTops = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();

    public Sandwich(String size, String bread) {
        this.size = size;
        this.bread = bread;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public void addMeat(PremiumTop meat) { meats.add(meat); }
    public void addExtraMeat(PremiumTop meat) { extraMeats.add(meat); }
    public void addCheese(PremiumTop cheese) { cheeses.add(cheese); }
    public void addExtraCheese(PremiumTop cheese) { extraCheeses.add(cheese); }
    public void addRegularTopping(RegularTop top) { regularTops.add(top); }
    public void addSauce(String sauce) { sauces.add(sauce); }

    @Override
    public double calPrice() {
        double base = switch (size) {
            case "4" -> 5.50;
            case "8" -> 7.00;
            case "12" -> 8.50;
            default -> 0;
        };
        double total = base;
        for (PremiumTop meat : meats) total += meat.getPrice();
        for (PremiumTop extra : extraMeats) total += extra.getPrice();
        for (PremiumTop cheese : cheeses) total += cheese.getPrice();
        for (PremiumTop extra : extraCheeses) total += extra.getPrice();
        return total;
    }

    @Override
    public String getDetails() {
        return size + "\"" + bread + " sandwich\n" +
                " Toasted: " + (toasted ? "Yes" : "No") + "\n" +
                " Meats: " + listNames(meats) + "(Extras: " + listNames(extraMeats) + ")\n" +
                " Cheeses: " + listNames(cheeses) + "(Extras: " + listNames(extraCheeses) + ")\n" + 
                " Toppings: " + listNames(regularTops) + "\n" + 
                " Sauces: " + sauces;
    }
    
    private String listNames(List<? extends Topping> toppings) {
        List<String> name = new ArrayList<>();
        for (Topping topping : toppings) name.add(topping.getName());
        return String.join(", ", name);
    }
}
