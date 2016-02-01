package com.truizlop.gildedrose.quality;

import com.truizlop.gildedrose.Item;

public class BackstageQualityUpdater implements QualityUpdater{

    private static final int TEN_DAYS = 10;
    private static final int FIVE_DAYS = 5;

    @Override
    public void update(Item item) {
        if(item.isExpired()){
            item.dropQualityToZero();
        } else {
            increaseQualityBasedOnSellInDate(item);
        }
    }

    private void increaseQualityBasedOnSellInDate(Item item) {
        if (item.getSellIn() <= FIVE_DAYS) {
            item.increaseQualityBy(3);
        } else if (item.getSellIn() <= TEN_DAYS) {
            item.increaseQualityBy(2);
        } else {
            item.increaseQualityBy(1);
        }
    }
}
