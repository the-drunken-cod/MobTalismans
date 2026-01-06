package com.drunkencod.mob_mementos.tag;

import com.drunkencod.mob_mementos.MobMementos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> INFESTED = TagKey.create(Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(MobMementos.MOD_ID, "infested"));
}
