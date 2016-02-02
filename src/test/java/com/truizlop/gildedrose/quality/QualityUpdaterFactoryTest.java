package com.truizlop.gildedrose.quality;

import com.truizlop.gildedrose.ItemType;
import org.junit.Before;
import org.junit.Test;

import static com.truizlop.gildedrose.ItemType.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class QualityUpdaterFactoryTest {
    private static final ItemType ANY_ITEM = DEXTERITY_VEST;

    private QualityUpdaterFactory qualityUpdaterFactory;

    @Before
    public void initialize(){
        qualityUpdaterFactory = new QualityUpdaterFactory();
    }

    @Test
    public void shouldProvideQualityUpdaterForDefaultItem(){
        QualityUpdater qualityUpdater = qualityUpdaterFactory.makeUpdaterFor(ANY_ITEM);

        assertThat(qualityUpdater, is(instanceOf(DefaultQualityUpdater.class)));
    }

    @Test
    public void shouldProvideAgedBrieUpdaterForAgedBrieItem(){
        QualityUpdater qualityUpdater = qualityUpdaterFactory.makeUpdaterFor(AGED_BRIE);

        assertThat(qualityUpdater, is(instanceOf(AgedBrieQualityUpdater.class)));
    }

    @Test
    public void shouldProvideBackstageUpdaterForBackstageItem(){
        QualityUpdater qualityUpdater = qualityUpdaterFactory.makeUpdaterFor(BACKSTAGE);

        assertThat(qualityUpdater, is(instanceOf(BackstageQualityUpdater.class)));
    }

    @Test
    public void shouldProvideSulfurasUpdaterForSulfurasItem(){
        QualityUpdater qualityUpdater = qualityUpdaterFactory.makeUpdaterFor(SULFURAS);

        assertThat(qualityUpdater, is(instanceOf(SulfurasQualityUpdater.class)));
    }

    @Test
    public void shouldProvideConjuredUpdaterForConjuredItem(){
        QualityUpdater qualityUpdater = qualityUpdaterFactory.makeUpdaterFor(CONJURED);

        assertThat(qualityUpdater, is(instanceOf(ConjuredQualityUpdater.class)));
    }

}
