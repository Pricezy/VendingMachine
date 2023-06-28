package com.itemslot;

public class Item {

    private String name;
    private double price;
    private int calories;
    private int quantity;
    // limit items to 20
    public Item(String name, double price, int calories, int quantity) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getCalories() {
        return this.calories;
    }

    public int getQuantiy() {
        return this.quantity;
    }


    
    
        
    
}
