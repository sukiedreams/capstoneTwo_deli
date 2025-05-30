package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> items = new ArrayList<>();

    public void addItems(Product item) {
        items.add(item);
    }
    public List<Product> getItems() {
        return items;
    }
    public double getTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.calPrice();
        }
        return total;
    }

    public void printOrder() {
        System.out.println("---Your Order---");
        int count = 1;
        for (Product item : items) {
            System.out.println("Item #" + count++);
            System.out.println(item.getDetails());
            System.out.printf(" Item Price: $%.2f\n", item.calPrice());
            System.out.println("----------------------");
        }
        System.out.printf("TOTAL: $%.2f\n", getTotal());
        System.out.println("=============================");
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

}
