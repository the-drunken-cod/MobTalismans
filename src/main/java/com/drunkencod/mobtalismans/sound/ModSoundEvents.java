package com.drunkencod.mobtalismans.sound;

import com.drunkencod.mobtalismans.MobTalismans;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(
            BuiltInRegistries.SOUND_EVENT, MobTalismans.MOD_ID);

    // #region talismans

    public static final DeferredHolder<SoundEvent, SoundEvent> CONDUIT_TALISMAN_TRIGGERED = createSoundEvent(
            "conduit_talisman_triggered");

    public static final DeferredHolder<SoundEvent, SoundEvent> CREEPER_TALISMAN_TRIGGERED = createSoundEvent(
            "creeper_talisman_triggered");

    public static final DeferredHolder<SoundEvent, SoundEvent> ENDERMAN_TALISMAN_TRIGGERED = createSoundEvent(
            "enderman_talisman_triggered");

    public static final DeferredHolder<SoundEvent, SoundEvent> SILVERFISH_TALISMAN_TRIGGERED = createSoundEvent(
            "silverfish_talisman_triggered");

    // #region register

    public static void register(IEventBus bus) {
        SOUND_EVENTS.register(bus);
    }

    static DeferredHolder<SoundEvent, SoundEvent> createSoundEvent(String registryName) {
        return SOUND_EVENTS.register(registryName, () -> SoundEvent.createVariableRangeEvent(
                ResourceLocation.fromNamespaceAndPath(MobTalismans.MOD_ID, registryName)));
    }
}
