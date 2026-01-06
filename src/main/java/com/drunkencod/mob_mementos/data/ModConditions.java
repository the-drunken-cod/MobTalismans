package com.drunkencod.mob_mementos.data;

import com.drunkencod.mob_mementos.data.condition.ConfigEnabledCondition;
import com.drunkencod.mob_mementos.MobMementos;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModConditions {
    public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITIONS = DeferredRegister
            .create(NeoForgeRegistries.CONDITION_SERIALIZERS, MobMementos.MOD_ID);

    static {
        CONDITIONS.register(ConfigEnabledCondition.REGISTRY_NAME, () -> ConfigEnabledCondition.CODEC);
    }

    public static void register(IEventBus eventBus) {
        CONDITIONS.register(eventBus);
    }
}