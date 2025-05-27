package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> items = new ArrayList<>();

    public void addItems(Product item) {
        items.add(item);
    }

    public double getTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    public List<Product> getItems() {
        return items;
    }

}
