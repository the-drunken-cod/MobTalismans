package com.drunkencod.mob_mementos.data.condition;

import com.drunkencod.mob_mementos.config.ModStartupConfig;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.conditions.ICondition;

public record ConfigEnabledCondition(String configKey) implements ICondition {
    public static final String REGISTRY_NAME = "config_enabled";

    public static final MapCodec<ConfigEnabledCondition> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.STRING.fieldOf("config_key").forGetter(ConfigEnabledCondition::configKey))
            .apply(instance, ConfigEnabledCondition::new));

    @Override
    public boolean test(IContext context) {
        return switch (configKey) {
            case "conduit_necklace" -> ModStartupConfig.CONDUIT_NECKLACE.ENABLED.get();
            case "creeper_belt" -> ModStartupConfig.CREEPER_BELT.ENABLED.get();
            case "enderman_anklet" -> ModStartupConfig.ENDERMAN_ANKLET.ENABLED.get();
            case "phantom_cloak" -> ModStartupConfig.PHANTOM_CLOAK.ENABLED.get();
            case "silverfish_bangle" -> ModStartupConfig.SILVERFISH_BANGLE.ENABLED.get();
            default -> true;
        };
    }

    @Override
    public MapCodec<? extends ICondition> codec() {
        return CODEC;
    }
}
