package com.truizlop.gildedrose.sellin;

import com.truizlop.gildedrose.ItemType;

public class SellInUpdaterFactory {

    public SellInUpdater makeUpdaterFor(ItemType type){
        switch (type){
            case SULFURAS:
                return new SulfurasSellInUpdater();
            default:
                return new DefaultSellInUpdater();
        }
    }

}
