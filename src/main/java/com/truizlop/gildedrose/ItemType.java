package com.truizlop.gildedrose;

public enum ItemType {
    DEXTERITY_VEST("+5 Dexterity Vest"),
    AGED_BRIE("Aged Brie"),
    ELIXIR_MONGOOSE("Elixir of the Mongoose"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured Mana Cake");

    private String name;

    ItemType(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
