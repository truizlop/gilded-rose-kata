package com.truizlop.gildedrose;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        Inventory inventory = new Inventory();
        List<Item> items = inventory.getItems();
        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(items);
    }
}
