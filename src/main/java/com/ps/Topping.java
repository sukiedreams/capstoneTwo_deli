package com.ps;

public abstract class Topping {
    protected String name;

    public Topping(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
