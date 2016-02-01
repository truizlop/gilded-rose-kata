package com.truizlop.gildedrose.quality;

import com.truizlop.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;

import static com.truizlop.gildedrose.ItemBuilder.anItem;
import static com.truizlop.gildedrose.ItemType.BACKSTAGE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BackstageQualityUpdaterTest {
    private static final int MORE_THAN_TEN_DAYS = 15;
    private static final int TEN_DAYS = 10;
    private static final int FIVE_DAYS = 5;
    private static final int EXPIRED = -1;

    private BackstageQualityUpdater qualityUpdater;

    @Before
    public void initialize(){
        qualityUpdater = new BackstageQualityUpdater();
    }

    @Test
    public void shouldIncreaseQualityByOneWhenMoreThanTenDaysToSell() {
        Item item = anItem().withName(BACKSTAGE).withQuality(10).withSellIn(MORE_THAN_TEN_DAYS).build();

        qualityUpdater.update(item);

        assertThat(item.getQuality(), is(11));
    }

    @Test
    public void shouldIncreaseQualityByTwoWhenLessThanTenDaysToSell() {
        Item item = anItem().withName(BACKSTAGE).withQuality(10).withSellIn(TEN_DAYS).build();

        qualityUpdater.update(item);

        assertThat(item.getQuality(), is(12));
    }

    @Test
    public void shouldIncreaseQualityByThreeWhenLessThanSixDaysToSell() {
        Item item = anItem().withName(BACKSTAGE).withQuality(10).withSellIn(FIVE_DAYS).build();

        qualityUpdater.update(item);

        assertThat(item.getQuality(), is(13));
    }

    @Test
    public void shouldNotIncreaseQualityOver50() {
        Item item = anItem().withName(BACKSTAGE).withQuality(50).withSellIn(MORE_THAN_TEN_DAYS).build();

        qualityUpdater.update(item);

        assertThat(item.getQuality(), is(50));
    }

    @Test
    public void shouldDropQualityToZeroWhenExpired(){
        Item item = anItem().withName(BACKSTAGE).withQuality(10).withSellIn(EXPIRED).build();

        qualityUpdater.update(item);

        assertThat(item.getQuality(), is(0));
    }
}
