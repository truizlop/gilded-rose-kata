package com.truizlop.gildedrose.quality;

import com.truizlop.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;

import static com.truizlop.gildedrose.ItemBuilder.anItem;
import static com.truizlop.gildedrose.ItemType.SULFURAS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SulfurasQualityUpdaterTest {
    private static final int ANY_SELL_IN = 5;

    private SulfurasQualityUpdater qualityUpdater;

    @Before
    public void initialize(){
        qualityUpdater = new SulfurasQualityUpdater();
    }

    @Test
    public void shouldNotUpdateQualityEver(){
        Item item = anItem().withName(SULFURAS).withQuality(10).withSellIn(ANY_SELL_IN).build();

        qualityUpdater.update(item);

        assertThat(item.getQuality(), is(10));
    }
}
