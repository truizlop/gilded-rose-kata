package com.truizlop.gildedrose;

public class ItemBuilder {
    private ItemType name;
    private int sellIn;
    private int quality;

    public ItemBuilder(){}

    public static ItemBuilder anItem(){
        return new ItemBuilder();
    }

    public ItemBuilder withName(ItemType name){
        this.name = name;
        return this;
    }

    public ItemBuilder withQuality(int quality){
        this.quality = quality;
        return this;
    }

    public ItemBuilder withSellIn(int sellIn){
        this.sellIn = sellIn;
        return this;
    }

    public Item build(){
        return new Item(name, sellIn, quality);
    }
}
