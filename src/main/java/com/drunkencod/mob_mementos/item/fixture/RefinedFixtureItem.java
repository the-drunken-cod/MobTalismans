package com.drunkencod.mob_mementos.item.fixture;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class RefinedFixtureItem extends Item {
    public static final String REGISTRY_NAME = "refined_fixture";

    public RefinedFixtureItem() {
        super(new Item.Properties().rarity(Rarity.UNCOMMON));
    }
}
