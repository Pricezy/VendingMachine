package com.itemslot;

import java.util.*;

public class ItemSlots {
    // limit itemslots to 25 to create a 5 x 5 vending machine

    private ArrayList<Item> itemSlot;

    public ItemSlots(ArrayList<Item> item) {
        this.itemSlot = new ArrayList<Item>(20);
    };

    /**
     * gets the list of items in the slot
     * 
     * @return this.itemSlot
     */
    public ArrayList<Item> getItemSlot() {
        return this.itemSlot;
    }
}
