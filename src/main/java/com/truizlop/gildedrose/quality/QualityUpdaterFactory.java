package com.truizlop.gildedrose.quality;

import com.truizlop.gildedrose.ItemType;

public class QualityUpdaterFactory {

    public QualityUpdater makeUpdaterFor(ItemType type){

        switch (type){
            case AGED_BRIE:
                return new AgedBrieQualityUpdater();
            case BACKSTAGE:
                return new BackstageQualityUpdater();
            case SULFURAS:
                return new SulfurasQualityUpdater();
            case CONJURED:
                return new ConjuredQualityUpdater();
            default:
                return new DefaultQualityUpdater();
        }

    }

}
