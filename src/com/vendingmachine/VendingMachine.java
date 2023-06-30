package com.vendingmachine;

import java.util.*;

import com.itemslot.*;
import com.cash.Cash;

public class VendingMachine {
    private ArrayList<Item> itemSlots;
    private Cash cash;

    public VendingMachine() {
        this.itemSlots = new ArrayList<>();
        cash = new Cash();
    }

    public void addItemSlot(Item item) {
        itemSlots.add(item);
    }

    public void addDenomination(int denomination) {
        cash.addDenomination(denomination);
    }

    public void restockItem(int itemIndex, int quantity) {
        if (itemIndex >= 0 && itemIndex < itemSlots.size()) {
            Item item = itemSlots.get(itemIndex);
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            System.out.println("Invalid item index.");
        }
    }

    public void printItemSlots() {
        for (int i = 0; i < itemSlots.size(); i++) {
            Item item = itemSlots.get(i);
            System.out.println("Slot" + (i + 1) + ": " + item.getName() + "- PHP " + item.getPrice() + " Quantity: "
                    + item.getQuantity());
        }
    }

    public void printCashSummary() {
        cash.printCashSummary();
    }

    public void purchaseItem(int itemIndex) {
        if (itemIndex >= 0 && itemIndex < itemSlots.size()) {
            Item item = itemSlots.get(itemIndex);
            System.out.println("Selected Item: " + item.getName());
            System.out.println("Price: PHP " + item.getPrice());
            System.out.print("Enter amount: PHP ");
            Scanner scanner = new Scanner(System.in);
            double amount = scanner.nextDouble();

            if (amount >= item.getPrice()) {
                double change = amount - item.getPrice();
                if (cash.getTotalCash() >= change) {
                    cash.removeCash(change);
                    item.setQuantity(item.getQuantity() - 1);
                    System.out.println("Thank you for your purchase! Your change is PHP" + change);
                } else {
                    System.out.println("Insufficient change. Please try again later.");
                }
            } else {
                System.out.println("Invalid item index.");
            }
        }
    }

}
