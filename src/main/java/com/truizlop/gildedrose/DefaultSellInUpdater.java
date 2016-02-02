package com.truizlop.gildedrose;

public class DefaultSellInUpdater {

    public void update(Item item){
        item.setSellIn(item.getSellIn() - 1);
    }

}
