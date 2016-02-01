package com.truizlop.gildedrose.quality;

import com.truizlop.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;

import static com.truizlop.gildedrose.ItemBuilder.anItem;
import static com.truizlop.gildedrose.ItemType.AGED_BRIE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AgedBrieQualityUpdaterTest {
    private static final int ANY_SELL_IN = 10;
    private static final int EXPIRED = -1;

    private AgedBrieQualityUpdater qualityUpdater;

    @Before
    public void initialize(){
        qualityUpdater = new AgedBrieQualityUpdater();
    }

    @Test
    public void shouldIncreaseQuality(){
        Item item = anItem().withName(AGED_BRIE).withQuality(10).withSellIn(ANY_SELL_IN).build();

        qualityUpdater.update(item);

        assertThat(item.getQuality(), is(11));
    }

    @Test
    public void shouldIncreaseQualityTwiceAsFastWhenExpired(){
        Item item = anItem().withName(AGED_BRIE).withQuality(10).withSellIn(EXPIRED).build();

        qualityUpdater.update(item);

        assertThat(item.getQuality(), is(12));
    }

    @Test
    public void shouldNotIncreaseQualityOver50() {
        Item item = anItem().withName(AGED_BRIE).withQuality(50).withSellIn(ANY_SELL_IN).build();

        qualityUpdater.update(item);

        assertThat(item.getQuality(), is(50));
    }
}
