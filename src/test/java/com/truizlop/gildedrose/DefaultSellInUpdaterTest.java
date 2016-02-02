package com.truizlop.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static com.truizlop.gildedrose.ItemBuilder.anItem;
import static com.truizlop.gildedrose.ItemType.DEXTERITY_VEST;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DefaultSellInUpdaterTest {

    private static final ItemType ANY_ITEM = DEXTERITY_VEST;
    private static final int ANY_QUALITY = 10;

    private DefaultSellInUpdater sellInUpdater;

    @Before
    public void initialize(){
        sellInUpdater = new DefaultSellInUpdater();
    }

    @Test
    public void shouldDecreaseSellInByOne(){
        Item item = anItem().withName(ANY_ITEM).withQuality(ANY_QUALITY).withSellIn(5).build();

        sellInUpdater.update(item);

        assertThat(item.getSellIn(), is(4));
    }
}
