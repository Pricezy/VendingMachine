package com.cash;

import java.util.*;

public class Cash {
    private ArrayList<Integer> denominations;
    private ArrayList<Integer> quantities;

    public Cash() {
        this.denominations = new ArrayList<>();
        this.quantities = new ArrayList<>();
    }

    public void addDenomination(int denomination) {
        this.denominations.add(denomination);
        this.quantities.add(0);
    }

    public void addCash(int denomination, int quantity) {
        int index = denominations.indexOf(denomination);
        if (index != -1) {
            int currentQuantity = quantities.get(index);
            quantities.set(index, currentQuantity + quantity);
        }
    }

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

    public double getTotalCash() {
        double totalCash = 0.0;
        for (int i = 0; i < denominations.size(); i++) {
            totalCash += denominations.get(i) * quantities.get(i);
        }
        return totalCash;
    }

    public void printCashSummary() {
        for (int i = 0; i < denominations.size(); i++) {
            System.out.println("Denomination: PHP " + denominations.get(i) + " Quantity: " + quantities.get(i));
        }
    }
}
