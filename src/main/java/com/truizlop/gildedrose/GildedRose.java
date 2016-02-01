package com.truizlop.gildedrose;

import java.util.ArrayList;
import java.util.List;

/*
 Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a prominent city ran by
 a friendly innkeeper named Allison. We also buy and sell only the finest goods. Unfortunately, our goods are
 constantly degrading in quality as they approach their sell by date. We have a system in place that updates our
 inventory for us. It was developed by a no-nonsense type named Leeroy, who has moved on to new adventures.
 Your task is to add the new feature to our system so that we can begin selling a new category of items.
 First an introduction to our system:

 - All items have a SellIn value which denotes the number of days we have to sell the item
 - All items have a Quality value which denotes how valuable the item is
 - At the end of each day our system lowers both values for every item

 Pretty simple, right? Well this is where it gets interesting:

 - Once the sell by date has passed, Quality degrades twice as fast
 - The Quality of an item is never negative
 - "Aged Brie" actually increases in Quality the older it gets
 - The Quality of an item is never more than 50
 - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
 - "Backstage passes", like aged brie, increases in Quality as it's SellIn value approaches;
 Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0
 after the concert

 We have recently signed a supplier of conjured items. This requires an update to our system:

 - "Conjured" items degrade in Quality twice as fast as normal items

 Feel free to make any changes to the UpdateQuality method and add any new code as long as everything still
 works correctly. However, do not alter the Item class or Items property as those belong to the goblin in the
 corner who will insta-rage and one-shot you as he doesn't believe in shared code ownership (you can make the
 UpdateQuality method and Items property static if you like, we'll cover for you). Your work needs to be completed
 by Friday, February 18, 2011 08:00:00 AM PST.

 Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a legendary
 item and as such its Quality is 80 and it never alters.
 */
public class GildedRose {

    private static List<Item> items = null;

    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(items);
    }

    public void updateQuality(List<Item> items) {
        for (Item item : items) {
            updateQualityForItem(item);
        }
    }

    public void updateQualityForItem(Item item) {
        if (!"Aged Brie".equals(item.getName()) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
            if (item.getQuality() > 0) {
                if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                    item.setQuality(item.getQuality() - 1);
                }
            }
        } else {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);

                if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                    if (item.getSellIn() < 11) {
                        if (item.getQuality() < 50) {
                            item.setQuality(item.getQuality() + 1);
                        }
                    }

                    if (item.getSellIn() < 6) {
                        if (item.getQuality() < 50) {
                            item.setQuality(item.getQuality() + 1);
                        }
                    }
                }
            }
        }

        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            item.setSellIn(item.getSellIn() - 1);
        }

        if (item.getSellIn() < 0) {
            if (!"Aged Brie".equals(item.getName())) {
                if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                    if (item.getQuality() > 0) {
                        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                            item.setQuality(item.getQuality() - 1);
                        }
                    }
                } else {
                    item.setQuality(0);
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }
    }

}
