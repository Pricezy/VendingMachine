import java.util.*;

package com.main;

import com.vendingmachine;
public class main {


    public static void main(String[] args) {
        System.out.println("Welcome to Vending Machine Factory");
        System.out.println("Choose an action you want to do:");
        System.out.println("1. Create a Vending Machine");
        System.out.println("2. Test a Vending Machine");
        System.out.println("3. Exit the program");

        Scanner sc = new Scanner(System.in);
        VendingMachine v = new VendingMachine();
        int nChoice = sc.nextInt();
        switch (nChoice) {
            case 1:
                
                break;

            case 2:

                break;
            
            
        }

    }
}