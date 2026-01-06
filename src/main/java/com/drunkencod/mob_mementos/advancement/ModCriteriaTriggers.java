package com.drunkencod.mob_mementos.advancement;

import com.drunkencod.mob_mementos.MobMementos;

import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCriteriaTriggers {
    public static final DeferredRegister<CriterionTrigger<?>> CRITERION_TRIGGERS = DeferredRegister
            .create(Registries.TRIGGER_TYPE, MobMementos.MOD_ID);

    // on memento trigger
    public static final CustomItemTrigger MEMENTO_TRIGGERED = register("memento_triggered",
            new CustomItemTrigger());

    private static <T extends CriterionTrigger<?>> T register(String name, T trigger) {
        CRITERION_TRIGGERS.register(name, () -> trigger);
        return trigger;
    }

    public static void register(IEventBus eventBus) {
        CRITERION_TRIGGERS.register(eventBus);
    }
}
