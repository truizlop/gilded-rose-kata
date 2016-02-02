package com.truizlop.gildedrose.sellin;

import com.truizlop.gildedrose.Item;

public class DefaultSellInUpdater implements SellInUpdater {

    @Override
    public void update(Item item){
        item.setSellIn(item.getSellIn() - 1);
    }

}
