package com.truizlop.gildedrose;

import java.util.ArrayList;
import java.util.List;

import static com.truizlop.gildedrose.ItemType.*;

public class Inventory {

    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(DEXTERITY_VEST, 10, 20));
        items.add(new Item(AGED_BRIE, 2, 0));
        items.add(new Item(ELIXIR_MONGOOSE, 5, 7));
        items.add(new Item(SULFURAS, 0, 80));
        items.add(new Item(BACKSTAGE, 15, 20));
        items.add(new Item(CONJURED, 3, 6));
        return items;
    }
}
