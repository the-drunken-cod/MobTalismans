package com.drunkencod.mob_mementos;

import com.drunkencod.mob_mementos.advancement.ModCriteriaTriggers;
import com.drunkencod.mob_mementos.config.ModStartupConfig;
import com.drunkencod.mob_mementos.data.ModConditions;
import com.drunkencod.mob_mementos.item.*;
import com.drunkencod.mob_mementos.sound.ModSoundEvents;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.ModContainer;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MobMementos.MOD_ID)
public class MobMementos {
    public static final String MOD_ID = "mob_mementos";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MobMementos(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModConditions.register(modEventBus);

        ModItems.ITEMS.register(modEventBus);

        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        ModSoundEvents.register(modEventBus);

        ModCriteriaTriggers.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.STARTUP, ModStartupConfig.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
    }
}
