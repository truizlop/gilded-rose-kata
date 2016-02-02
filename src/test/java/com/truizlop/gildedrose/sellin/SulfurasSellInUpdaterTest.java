package com.truizlop.gildedrose.sellin;

import com.truizlop.gildedrose.Item;
import com.truizlop.gildedrose.sellin.SulfurasSellInUpdater;
import org.junit.Before;
import org.junit.Test;

import static com.truizlop.gildedrose.ItemBuilder.anItem;
import static com.truizlop.gildedrose.ItemType.SULFURAS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SulfurasSellInUpdaterTest {

    private static final int ANY_QUALITY = 1;

    private SulfurasSellInUpdater sellInUpdater;

    @Before
    public void initialize(){
        sellInUpdater = new SulfurasSellInUpdater();
    }

    @Test
    public void shouldNeverUpdateSellIn(){
        Item item = anItem().withName(SULFURAS).withQuality(ANY_QUALITY).withSellIn(5).build();

        sellInUpdater.update(item);

        assertThat(item.getSellIn(), is(5));
    }
}
