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

    /**
     * sets the price of an item
     * 
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * sets the quantity of an item
     * 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * gets the name of an item
     * 
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * gets the price of an item
     * 
     * @return price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * gets the calories of an item
     * 
     * @return calories
     */
    public int getCalories() {
        return this.calories;
    }

    /**
     * gets the quantity of an item
     * 
     * @return quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * sets the calories of an item
     * 
     * @param calories
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * sets the name of an item
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
