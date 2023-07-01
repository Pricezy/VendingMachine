package com.main;

import java.util.*;

import com.vendingmachine.VendingMachine;
import com.itemslot.*;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        // Add item slots
        vendingMachine.addItemSlot(new Item("Soda", 20.0, 200, 5));
        vendingMachine.addItemSlot(new Item("Chips", 15.0, 100, 8));
        vendingMachine.addItemSlot(new Item("Candy", 10.0, 150, 12));

        // Add denominations
        vendingMachine.addDenomination(1);
        vendingMachine.addDenomination(5);
        vendingMachine.addDenomination(10);
        vendingMachine.addDenomination(20);
        vendingMachine.addDenomination(50);
        vendingMachine.addDenomination(100);
        vendingMachine.addDenomination(500);
        vendingMachine.addDenomination(1000);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("==== Vending Machine Menu ====");
            System.out.println("1. Purchase Item");
            System.out.println("2. Restock Item");
            System.out.println("3. View Item Slots");
            System.out.println("4. View Cash Summary");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter item index: ");
                    int itemIndex = scanner.nextInt();
                    vendingMachine.purchaseItem(itemIndex - 1);
                    break;
                case 2:
                    System.out.println("Enter item index: ");
                    int restockIndex = scanner.nextInt();
                    System.out.println("Enter quantity: ");
                    int restockQuantity = scanner.nextInt();
                    vendingMachine.restockItem(restockIndex - 1, restockQuantity);
                    break;
                case 3:
                    vendingMachine.printItemSlots();
                    break;
                case 4:
                    vendingMachine.printCashSummary();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 0);
    }
}