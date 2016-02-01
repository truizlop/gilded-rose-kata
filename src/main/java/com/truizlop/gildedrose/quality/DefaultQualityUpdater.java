package com.truizlop.gildedrose.quality;

import com.truizlop.gildedrose.Item;

public class DefaultQualityUpdater {

    public void update(Item item) {
        if(item.isExpired()){
            item.decreaseQualityBy(2);
        }else{
            item.decreaseQualityBy(1);
        }
    }

}
