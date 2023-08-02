package com.cash;

import java.util.*;

public class Cash {
    
    private ArrayList<Integer> denominations;
    private ArrayList<Integer> quantities;
    int[] change; 

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
     * @param denomination this is the denomination you want to add
     */
    public void addDenomination(int denomination) {
        this.denominations.add(denomination);
        this.quantities.add(0);
    }


    /**
     * returns change to the user
     * 
     * @param amount amount that will give to the user
     * 
     * 
     */
    public void removeCash(double amount) {
        int remainingAmount = (int) amount;
        change = new int[this.denominations.size()];
        for (int i = denominations.size() - 1; i >= 0; i--) {
            int denomination = denominations.get(i);
            int numDenom = remainingAmount / denomination;

            if (numDenom > 0) {
                change[i] = numDenom;
                remainingAmount -= numDenom * denomination;
            }
        }

        if (remainingAmount != 0) {
            // If we can't provide exact change with the given denominations, return null
        }
        for (int i = 0; i < this.quantities.size(); i++) {
            this.quantities.set(i, change[i]);
        }
    }
    /**
     * gets the total amount of cash the user input.
     * 
     * @return totalCash gets the total cash
     */
    public double getTotalCash() {
        double totalCash = 0.0;
        for (int i = 0; i < denominations.size(); i++) {
            totalCash += denominations.get(i) * quantities.get(i);
        }
        return totalCash;
    }



    /**
     * to change the quantity of a denomination
     * 
     * @param denomination denomination of money
     * @param quantity quantity that you want to ser
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
     * @return this.quantities
     */
    public ArrayList<Integer> getQuantities() {
        return this.quantities;
    }
    
    /**
     * gets the list of denominations
     * 
     * @return denominations
     */
    public ArrayList<Integer> getDenominations() {
        return this.denominations;
    }
}
