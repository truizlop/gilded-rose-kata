package com.truizlop.gildedrose.quality;

import com.truizlop.gildedrose.Item;

public class ConjuredQualityUpdater implements QualityUpdater{

    @Override
    public void update(Item item) {
        if(item.isExpired()){
            item.decreaseQualityBy(4);
        } else {
            item.decreaseQualityBy(2);
        }
    }
}
