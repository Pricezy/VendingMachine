package com.vendingmachine;

import java.util.*;

import com.itemslot.*;
import com.cash.Cash;

public class VendingMachine {
    private ArrayList<Item> itemSlots;
    private Cash cash;

    public VendingMachine() {
        this.itemSlots = new ArrayList<>(25);
        cash = new Cash();
    }

    /**
     * adds a slot in the vending machine for an item
     * 
     * @param item
     */
    public void addItemSlot(Item item) {
        itemSlots.add(item);
    }

    /**
     * adds a denomination to the list of denominations
     * 
     * @param denomination
     */
    public void addDenomination(int denomination) {
        cash.addDenomination(denomination);
    }

    /**
     * sets the price of an item
     * 
     * @param itemIndex
     * @param price
     */
    public void setPrice(int itemIndex, int price) {
        if (itemIndex >= 0 && itemIndex < itemSlots.size()) {
            Item item = itemSlots.get(itemIndex);
            item.setPrice(price);
        } else {
            System.out.println("Invalid item index.");
        }
    }

    /**
     * prints the item details in every slot
     *
     */
    public void printItemSlots() {
        for (int i = 0; i < itemSlots.size(); i++) {
            Item item = itemSlots.get(i);
            System.out.println("Slot" + (i + 1) + ": " + item.getName() + "- PHP " + item.getPrice() + " Quantity: "
                    + item.getQuantity() + " Calories: " + item.getCalories());
        }
    }

    /**
     * prints the quantity of every denomination
     * 
     */
    public void printCashSummary() {
        cash.printCashSummary();
    }

    /**
     * replenishes an item for maintenance
     * 
     * @param itemIndex
     * @param quantity
     */
    public void replenishItem(int itemIndex, int quantity) {
        if (itemIndex >= 0 && itemIndex < itemSlots.size()) {
            Item item = itemSlots.get(itemIndex);
            item.setQuantity(item.getQuantity() + quantity);
            System.out.println("Item replenished successfully.");
        } else {
            System.out.println("Invalid item index.");
        }
    }

    /**
     * replenishes the money inside the machine for maintenance
     * 
     * @param denomination
     * @param quantity
     */
    public void replenishMoney(int denomination, int quantity) {
        cash.replenishMoney(denomination, quantity);
    }

    /**
     * collects the money in the machine but leaves 10 pieces per denomination
     * 
     * @returns totalCollected
     */
    public double collectMoney() {
        double totalCollected = 0.0;
        for (int i = 0; i < cash.getDenominations().size(); i++) {
            int denomination = cash.getDenominations().get(i);
            int quantity = cash.getQuantities().get(i);
            if (quantity > 10) {
                int collectedQuantity = quantity - 10;
                double collectedAmount = collectedQuantity * denomination;
                totalCollected += collectedAmount;
                cash.setQuantity(i, 10);
                System.out.println("Collected " + collectedQuantity + " " + denomination + " PHP denomination(s).");
            }
        }
        System.out.println("Total collected amount: " + totalCollected + " PHP");
        return totalCollected;
    }

    /**
     * allows the user to purchase an item
     * 
     * @param itemIndex
     */
    public void purchaseItem(int itemIndex) {
        if (itemIndex >= 0 && itemIndex < itemSlots.size()) {
            Item item = itemSlots.get(itemIndex);
            System.out.println("Selected Item: " + item.getName());
            System.out.println("Price: PHP " + item.getPrice());

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the quantities of the following denominations:");

            ArrayList<Integer> collectedDenominations = new ArrayList<>();

            for (int i = 0; i < cash.getDenominations().size(); i++) {
                int denomination = cash.getDenominations().get(i);
                System.out.print("Quantity of PHP " + denomination + ": ");
                int quantity = scanner.nextInt();
                if (quantity >= 0) {
                    int currentQuantity = cash.getQuantities().get(i);
                    int collectedQuantity = Math.min(quantity, currentQuantity);
                    cash.getQuantities().set(i, currentQuantity + collectedQuantity);
                    collectedDenominations.add(collectedQuantity);
                }
            }

            // Print collected denominations and total money collected
            System.out.println("Collected Denominations:");
            double totalCollected = 0.0;
            for (int i = 0; i < cash.getDenominations().size(); i++) {
                int denomination = cash.getDenominations().get(i);
                int collectedQuantity = collectedDenominations.get(i);
                double collectedAmount = denomination * collectedQuantity;
                System.out.println("Denomination: PHP " + denomination + " Quantity: " + collectedQuantity);
                totalCollected += collectedAmount;
            }

            System.out.println("Total Money Collected: PHP " + totalCollected);

            if (totalCollected >= item.getPrice()) {
                double change = totalCollected - item.getPrice();
                if (cash.getTotalCash() >= change) {
                    cash.removeCash(change);
                    item.setQuantity(item.getQuantity() - 1);
                    System.out.println("Dispensing" + item.getName());
                    System.out.println("Thank you for your purchase!");

                    // Collect denominations

                    System.out.println("Dispensing Change: PHP " + change);
                } else {
                    System.out.println("Insufficient change. Please try again later.");
                }
            } else {
                System.out.println("Invalid item index.");
            }
            scanner.close();
        }
    }
}
