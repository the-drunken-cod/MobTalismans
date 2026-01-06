package com.drunkencod.mob_mementos.item.fixture;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class SupremeFixtureItem extends Item {
    public static final String REGISTRY_NAME = "supreme_fixture";

    public SupremeFixtureItem() {
        super(new Item.Properties().rarity(Rarity.RARE));
    }
}
