package com.truizlop.gildedrose.quality;

import com.truizlop.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;

import static com.truizlop.gildedrose.ItemBuilder.anItem;
import static com.truizlop.gildedrose.ItemType.CONJURED;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConjuredQualityUpdaterTest {

    private static final int ANY_SELL_IN = 5;
    private static final int EXPIRED = -1;

    private ConjuredQualityUpdater qualityUpdater;

    @Before
    public void initialize(){
        qualityUpdater = new ConjuredQualityUpdater();
    }

    @Test
    public void shouldDecreaseQualityByTwo(){
        Item item = anItem().withName(CONJURED).withQuality(10).withSellIn(ANY_SELL_IN).build();

        qualityUpdater.update(item);

        assertThat(item.getQuality(), is(8));
    }

    @Test
    public void shouldDecreaseQualityTwiceAsFastWhenExpired(){
        Item item = anItem().withName(CONJURED).withQuality(10).withSellIn(EXPIRED).build();

        qualityUpdater.update(item);

        assertThat(item.getQuality(), is(6));
    }
}
