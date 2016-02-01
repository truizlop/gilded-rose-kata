package com.truizlop.gildedrose.quality;

import com.truizlop.gildedrose.Item;

public class AgedBrieQualityUpdater implements QualityUpdater{

    @Override
    public void update(Item item) {
        if(item.isExpired()){
            item.increaseQualityBy(2);
        }else{
            item.increaseQualityBy(1);
        }
    }
}
