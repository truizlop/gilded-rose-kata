package com.truizlop.gildedrose;

public class DefaultSellInUpdater implements SellInUpdater {

    @Override
    public void update(Item item){
        item.setSellIn(item.getSellIn() - 1);
    }

}
