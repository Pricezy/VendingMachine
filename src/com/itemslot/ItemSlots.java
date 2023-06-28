package com.itemslot;

import java.util.*;

public class ItemSlots {
    //limit itemslots to 26 to create a 5 x 5 vending machine

    private ArrayList<Item> itemSlot;

    public ItemSlots(ArrayList<Item> item){
        this.itemSlot = new ArrayList<Item>();
        // add items later
        this.itemSlot.add(new Item("Piattos",69, 300, 25));
    };

    public ArrayList <Item> getItemSlot() {
        return this.itemSlot;
    }
}
