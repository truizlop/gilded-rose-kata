package com.truizlop.gildedrose.quality;

import com.truizlop.gildedrose.Item;
import com.truizlop.gildedrose.ItemType;
import org.junit.Before;
import org.junit.Test;

import static com.truizlop.gildedrose.ItemBuilder.anItem;
import static com.truizlop.gildedrose.ItemType.DEXTERITY_VEST;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DefaultQualityUpdaterTest {

    private static final ItemType ANY_NAME = DEXTERITY_VEST;
    private static final int ANY_SELL_IN = 5;
    private static final int EXPIRED = -1;

    private DefaultQualityUpdater qualityUpdater;

    @Before
    public void initialize(){
        qualityUpdater = new DefaultQualityUpdater();
    }

    @Test
    public void shouldDecreaseQualityForNonExpiredItem(){
        Item item = anItem().withName(ANY_NAME).withQuality(10).withSellIn(ANY_SELL_IN).build();

        qualityUpdater.update(item);

        assertThat(item.getQuality(), is(9));
    }

    @Test
    public void shouldDecreaseTwiceAsFastWhenIsExpired(){
        Item item = anItem().withName(ANY_NAME).withQuality(10).withSellIn(EXPIRED).build();

        qualityUpdater.update(item);

        assertThat(item.getQuality(), is(8));
    }
}
