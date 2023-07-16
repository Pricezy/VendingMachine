package com.cash;

import java.util.*;

public class Cash {
    private ArrayList<Integer> denominations;
    private ArrayList<Integer> quantities;

    public Cash(ArrayList<Integer> denominations) {
        this.denominations = denominations;
        this.quantities = new ArrayList<>();

        for (int i = 0; i < denominations.size(); i++) {
            quantities.add(50);
        }
    }

    public Cash() {
        this.denominations = new ArrayList<>();
        this.quantities = new ArrayList<>();
    }

    /**
     * adds a denomination into the list of denominations
     * 
     * @param denomination
     */
    public void addDenomination(int denomination) {
        this.denominations.add(denomination);
        this.quantities.add(50);
    }

    /**
     * adds cash to the list of quantities of denominations in the vending machine
     * 
     * @param denomination
     * @param quantity
     */
    public void addCash(int denomination, int quantity) {
        int index = denominations.indexOf(denomination);
        if (index != -1) {
            int currentQuantity = quantities.get(index);
            quantities.set(index, currentQuantity + quantity);
        }
    }

    /**
     * returns change to the user
     * 
     * @param amount
     */
    public void removeCash(double amount) {
        for (int i = denominations.size() - 1; i >= 0; i--) {
            int denomination = denominations.get(i);
            int quantity = (int) (amount / denomination);
            if (quantity > 0) {
                int currentQuantity = quantities.get(i);
                int remainingQuantity = Math.max(currentQuantity - quantity, 0);
                quantities.set(i, remainingQuantity);
                amount -= denomination * Math.min(currentQuantity, quantity);
            }
        }
    }

    /**
     * gets the total amount of cash the user input.
     * 
     * @return totalCash
     */
    public double getTotalCash() {
        double totalCash = 0.0;
        for (int i = 0; i < denominations.size(); i++) {
            totalCash += denominations.get(i) * quantities.get(i);
        }
        return totalCash;
    }

    /**
     * allows the user to refill the amount of money inside the vending machine for
     * maintenance
     * 
     * @param denomination
     * @param quantity
     */
    public void replenishMoney(int denomination, int quantity) {
        int index = denominations.indexOf(denomination);
        if (index != -1) {
            int currentQuantity = quantities.get(index);
            int remainingQuantity = Math.min(currentQuantity + quantity, 10);
            quantities.set(index, remainingQuantity);
            System.out.println("Money replenished successfully.");
        } else {
            System.out.println("Invalid denomination.");
        }
    }

    /**
     * prints quantity of each denomination
     * 
     */
    public void printCashSummary() {
        for (int i = 0; i < denominations.size(); i++) {
            System.out.println("Denomination: PHP " + denominations.get(i) + " Quantity: " + quantities.get(i));
        }
    }

    /**
     * to change the list of denominations
     * 
     * @param denominations
     */
    public void setDenominations(ArrayList<Integer> denominations) {
        this.denominations = denominations;
    }

    /**
     * to change the quantity of a denomination
     * 
     * @param denomination
     * @param quantity
     */
    public void setQuantity(int denomination, int quantity) {
        int index = denominations.indexOf(denomination);
        if (index != -1) {
            quantities.set(index, quantity);
        }
    }

    /**
     * gets the list of quantities
     * 
     * @returns quantities
     */
    public ArrayList<Integer> getQuantities() {
        return this.quantities;
    }

    /**
     * gets the list of denominations
     * 
     * @returns denominations
     */
    public ArrayList<Integer> getDenominations() {
        return this.denominations;
    }

}
