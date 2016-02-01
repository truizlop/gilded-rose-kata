package com.truizlop.gildedrose;

public class Item {
    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    /* Generated getter and setter code */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSellIn() {
        return sellIn;
    }
    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }
    public int getQuality() {
        return quality;
    }
    private void setQuality(int quality) {
        this.quality = Math.max(0, Math.min(quality, 50));
    }

    public void increaseQualityBy(int factor) {
        setQuality(getQuality() + factor);
    }

    public void decreaseQualityBy(int factor) {
        setQuality(getQuality() - factor);
    }

    public boolean isExpired() {
        return getSellIn() < 0;
    }

    public void dropQualityToZero() {
        setQuality(0);
    }
}