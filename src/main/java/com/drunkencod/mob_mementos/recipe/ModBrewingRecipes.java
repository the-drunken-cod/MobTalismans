package com.drunkencod.mob_mementos.recipe;

import com.drunkencod.mob_mementos.item.ModItems;
import com.drunkencod.mob_mementos.MobMementos;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = MobMementos.MOD_ID)
public class ModBrewingRecipes {
    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(
                Potions.WATER,
                ModItems.ENDERMITE_SCALE.get(),
                Potions.SLOW_FALLING);

        builder.addMix(
                Potions.WATER,
                ModItems.SILVERFISH_SCALE.get(),
                Potions.INFESTED);
    }
}
