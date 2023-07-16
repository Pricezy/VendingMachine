package com.main;

import java.util.*;

import com.vendingmachine.*;
import com.itemslot.*;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isCreated = false;

        do {
            System.out.println("Welcome to Vending Machine Factory");
            System.out.println("Choose an action you want to do:");
            System.out.println("1. Create a Vending Machine");
            System.out.println("2. Test the Vending Machine Feature");
            System.out.println("3. Test the Maintenance Feature");
            System.out.println("0. Exit the program");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    // Add item slots
                    vendingMachine.addItemSlot(new Item("Soda", 20.0, 200, 5));
                    vendingMachine.addItemSlot(new Item("Chips", 15.0, 100, 8));
                    vendingMachine.addItemSlot(new Item("Candy", 10.0, 150, 12));
                    vendingMachine.addItemSlot(new Item("Gum", 23.0, 170, 23));
                    vendingMachine.addItemSlot(new Item("Skittle ", 50.0, 150, 12));
                    vendingMachine.addItemSlot(new Item("bottled water", 20.0, 0, 7));
                    vendingMachine.addItemSlot(new Item("iced tea", 30.0, 150, 5));
                    vendingMachine.addItemSlot(new Item("Fitbar", 35.0, 150, 14));
                    vendingMachine.addItemSlot(new Item("chocolate", 40.0, 200, 9));

                    // Add denominations
                    vendingMachine.addDenomination(1);
                    vendingMachine.addDenomination(5);
                    vendingMachine.addDenomination(10);
                    vendingMachine.addDenomination(20);
                    vendingMachine.addDenomination(50);
                    vendingMachine.addDenomination(100);
                    isCreated = true;
                    System.out.println("\nSuccessfully created a Vending Machine!");
                    break;
                case 2:
                    if (isCreated == true) {
                        do {
                            System.out.println("==== Vending Machine Menu ====");
                            System.out.println("1. Purchase Item");
                            System.out.println("2. View Item Slots");
                            System.out.println("3. View Cash Summary");
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
                                    vendingMachine.printItemSlots();
                                    break;
                                case 3:
                                    vendingMachine.printCashSummary();
                                    break;
                                case 0:
                                    System.out.println("Exiting...");
                                    main(args);
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                            System.out.println();

                        } while (choice != 0);

                    } else {
                        System.out.println("\nNo vending machine created yet.");
                    }
                    break;
                case 3:
                    if (isCreated == true) {
                        System.out.println("==== Vending Machine Menu ====");
                        System.out.println("1. Restock Item");
                        System.out.println("2. Set Price");
                        System.out.println("3. Collect money");
                        System.out.println("4. Replenish money");
                        System.out.println("0. Exit");
                        System.out.print("Enter your choice: ");
                        choice = scanner.nextInt();

                        switch (choice) {
                            case 1:
                                System.out.println("Enter item index: ");
                                int restockIndex = scanner.nextInt();
                                System.out.println("Enter quantity: ");
                                int restockQuantity = scanner.nextInt();

                                vendingMachine.replenishItem(restockIndex, restockQuantity);
                            case 2:
                                System.out.println(" Enter item index: ");
                                int priceIndex = scanner.nextInt();
                                System.out.println("Enter price: ");
                                int price = scanner.nextInt();
                                vendingMachine.setPrice(priceIndex, price);
                                break;
                            case 3:
                                vendingMachine.collectMoney();
                                break;
                            case 4:
                                System.out.println(" Enter denomination: ");
                                int denom = scanner.nextInt();
                                System.out.println("Enter quantity: ");
                                int quantity = scanner.nextInt();
                                vendingMachine.replenishMoney(denom, quantity);
                                break;
                            case 0:
                                System.out.println("Exiting...");
                                main(args);
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");

                        }
                    } else
                        System.out.println("\nNo vending machine created yet.");
            }

        } while (choice != 0);
        scanner.close();
    }
}