package com.truizlop.gildedrose;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static com.truizlop.gildedrose.GildedRoseTest.ItemBuilder.anItem;
import static com.truizlop.gildedrose.ItemType.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GildedRoseTest {
    private static final ItemType ANY_NAME = DEXTERITY_VEST;
    private static final int ANY_SELL_IN = 3;
    private static final int ANY_QUALITY = 15;
    private static final int EXPIRED_SELL_IN = -1;

    private GildedRose gildedRose;

    @Before
    public void initialize(){
        gildedRose = new GildedRose();
    }

    @Test
    public void shouldNotDegradeQualityLowerThanZero() {
        Item anyItem = anItem().withName(ANY_NAME).withQuality(0).withSellIn(ANY_SELL_IN).build();

        gildedRose.updateItem(anyItem);

        assertThat(anyItem.getQuality(), is(0));
    }

    @Test
    public void shouldDegradeQualityForAnyItem() {
        Item anyItem = anItem().withName(ANY_NAME).withQuality(5).withSellIn(ANY_SELL_IN).build();

        gildedRose.updateItem(anyItem);

        assertThat(anyItem.getQuality(), is(4));
    }

    @Test
    public void shouldDegradeTwiceAsFastAfterExpires(){
        Item anyItem = anItem().withName(ANY_NAME).withQuality(5).withSellIn(EXPIRED_SELL_IN).build();

        gildedRose.updateItem(anyItem);

        assertThat(anyItem.getQuality(), is(3));
    }

    @Test
    public void shouldDecreaseSellIn(){
        Item anyItem = anItem().withName(ANY_NAME).withQuality(ANY_QUALITY).withSellIn(5).build();

        gildedRose.updateItem(anyItem);

        assertThat(anyItem.getSellIn(), is(4));
    }

    @Test
    public void shouldIncreaseAgedBrieQuality() {
        Item agedBrie = anItem().withName(AGED_BRIE).withQuality(20).withSellIn(10).build();

        gildedRose.updateItem(agedBrie);

        assertThat(agedBrie.getQuality(), is(21));
    }

    @Test
    public void shouldIncreaseExpiredAgedBrieQualityTwiceAsFast() {
        Item agedBrie = anItem().withName(AGED_BRIE).withQuality(20).withSellIn(EXPIRED_SELL_IN).build();

        gildedRose.updateItem(agedBrie);

        assertThat(agedBrie.getQuality(), is(22));
    }

    @Test
    public void shouldNotIncreaseQualityAbove50() {
        Item agedBrie = anItem().withName(AGED_BRIE).withQuality(50).withSellIn(ANY_SELL_IN).build();

        gildedRose.updateItem(agedBrie);

        assertThat(agedBrie.getQuality(), is(50));
    }

    @Test
    public void shouldNotUpdateSellInForSulfuras() {
        Item sulfuras = anItem().withName(SULFURAS).withQuality(ANY_QUALITY).withSellIn(10).build();

        gildedRose.updateItem(sulfuras);

        assertThat(sulfuras.getSellIn(), is(10));
    }

    @Test
    public void shouldNotUpdateQualityForSulfuras() {
        Item sulfuras = anItem().withName(SULFURAS).withQuality(5).withSellIn(ANY_SELL_IN).build();

        gildedRose.updateItem(sulfuras);

        assertThat(sulfuras.getQuality(), is(5));
    }

    @Test
    public void shouldIncreaseBackstageQualityByOne(){
        Item backstage = anItem().withName(BACKSTAGE).withQuality(10).withSellIn(15).build();

        gildedRose.updateItem(backstage);

        assertThat(backstage.getQuality(), is(11));
    }

    @Test
    public void shouldIncreaseBackstageQualityByTwoWhenLessThan10DaysToSell(){
        Item backstage = anItem().withName(BACKSTAGE).withQuality(10).withSellIn(9).build();

        gildedRose.updateItem(backstage);

        assertThat(backstage.getQuality(), is(12));
    }

    @Test
    public void shouldIncreaseBackstageQualityByThreeWhenLessThan6DaysToSell(){
        Item backstage = anItem().withName(BACKSTAGE).withQuality(10).withSellIn(3).build();

        gildedRose.updateItem(backstage);

        assertThat(backstage.getQuality(), is(13));
    }

    @Test
    public void shouldDropBackstageQualityToZeroWhenExpires(){
        Item backstage = anItem().withName(BACKSTAGE).withQuality(10).withSellIn(EXPIRED_SELL_IN).build();

        gildedRose.updateItem(backstage);

        assertThat(backstage.getQuality(), is(0));
    }

    @Ignore("Feature requested")
    @Test
    public void shouldDecreaseConjuredQualityByTwo(){
        Item conjured = anItem().withName(CONJURED).withQuality(10).withSellIn(ANY_SELL_IN).build();

        gildedRose.updateItem(conjured);

        assertThat(conjured.getQuality(), is(8));
    }

    static class ItemBuilder{
        private ItemType name;
        private int sellIn;
        private int quality;

        public ItemBuilder(){}

        public static ItemBuilder anItem(){
            return new ItemBuilder();
        }

        public ItemBuilder withName(ItemType name){
            this.name = name;
            return this;
        }

        public ItemBuilder withQuality(int quality){
            this.quality = quality;
            return this;
        }

        public ItemBuilder withSellIn(int sellIn){
            this.sellIn = sellIn;
            return this;
        }

        public Item build(){
            return new Item(name, sellIn, quality);
        }
    }
}
