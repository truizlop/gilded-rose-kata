package com.truizlop.gildedrose.sellin;

import com.truizlop.gildedrose.ItemType;
import org.junit.Before;
import org.junit.Test;

import static com.truizlop.gildedrose.ItemType.DEXTERITY_VEST;
import static com.truizlop.gildedrose.ItemType.SULFURAS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class SellInUpdaterFactoryTest {
    private static final ItemType ANY_ITEM = DEXTERITY_VEST;

    private SellInUpdaterFactory sellInFactory;

    @Before
    public void initialize(){
        sellInFactory = new SellInUpdaterFactory();
    }

    @Test
    public void shouldProvideDefaultUpdaterForDefaultItem(){
        SellInUpdater sellInUpdater = sellInFactory.makeUpdaterFor(ANY_ITEM);

        assertThat(sellInUpdater, is(instanceOf(DefaultSellInUpdater.class)));
    }

    @Test
    public void shouldProvideSulfurasUpdaterForSulfurasItem(){
        SellInUpdater sellInUpdater = sellInFactory.makeUpdaterFor(SULFURAS);

        assertThat(sellInUpdater, is(instanceOf(SulfurasSellInUpdater.class)));
    }
}
