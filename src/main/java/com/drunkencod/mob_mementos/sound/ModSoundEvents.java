package com.drunkencod.mob_mementos.sound;

import com.drunkencod.mob_mementos.MobMementos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(
            BuiltInRegistries.SOUND_EVENT, MobMementos.MOD_ID);

    // #region mementos

    public static final DeferredHolder<SoundEvent, SoundEvent> CONDUIT_NECKLACE_TRIGGERED = createSoundEvent(
            "item.conduit_necklace.triggered");

    public static final DeferredHolder<SoundEvent, SoundEvent> CREEPER_BELT_TRIGGERED = createSoundEvent(
            "item.creeper_belt.triggered");

    public static final DeferredHolder<SoundEvent, SoundEvent> ENDERMAN_ANKLET_TRIGGERED = createSoundEvent(
            "item.enderman_anklet.triggered");

    public static final DeferredHolder<SoundEvent, SoundEvent> SILVERFISH_BANGLE_TRIGGERED = createSoundEvent(
            "item.silverfish_bangle.triggered");

    // #region register

    public static void register(IEventBus bus) {
        SOUND_EVENTS.register(bus);
    }

    static DeferredHolder<SoundEvent, SoundEvent> createSoundEvent(String registryName) {
        return SOUND_EVENTS.register(registryName, () -> SoundEvent.createVariableRangeEvent(
                ResourceLocation.fromNamespaceAndPath(MobMementos.MOD_ID, registryName)));
    }
}
