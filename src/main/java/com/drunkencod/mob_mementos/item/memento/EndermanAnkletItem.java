package com.drunkencod.mob_mementos.item.memento;

import com.drunkencod.mob_mementos.config.ModStartupConfig;
import com.drunkencod.mob_mementos.MobMementos;
import com.drunkencod.mob_mementos.sound.ModSoundEvents;
import io.wispforest.accessories.api.slot.SlotReference;
import java.util.List;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class EndermanAnkletItem extends AbstractMementoItem {
    public static final String REGISTRY_NAME = "enderman_anklet";

    public static final String PREVENT_ENDERMAN_GRIEFING_NBT_KEY = "mob_mementos:prevent_enderman_griefing";

    public EndermanAnkletItem() {
        super(REGISTRY_NAME, getDefaultProps(ModStartupConfig.ENDERMAN_ANKLET.DURABILITY.get())
                .rarity(Rarity.UNCOMMON));
    }

    public boolean isEnabled() {
        return ModStartupConfig.ENDERMAN_ANKLET.ENABLED.get();
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (!isEnabled())
            return;

        Entity playerEntity = reference.entity();
        Level level = reference.entity().level();

        double radius = ModStartupConfig.ENDERMAN_ANKLET.RADIUS.get();
        int tickInterval = ModStartupConfig.ENDERMAN_ANKLET.CHECK_INTERVAL_TICKS.get();

        // if memento is broken, do nothing
        if (stack.getMaxDamage() > 0 && stack.getDamageValue() >= stack.getMaxDamage())
            return;

        // find nearby endermen
        List<Entity> nearbyEndermen = getNearbyEndermen(level, reference.entity(), radius);
        for (Entity enderman : nearbyEndermen) {
            if (enderman.tickCount > 0 && enderman.tickCount % tickInterval == 0) {
                if (enderman.getPersistentData().getBoolean(PREVENT_ENDERMAN_GRIEFING_NBT_KEY))
                    continue;

                if (!level.isClientSide()) {
                    MobMementos.LOGGER.debug("[Enderman Anklet]: Preventing mob griefing for {}", enderman);

                    // set NBT key
                    enderman.getPersistentData().putBoolean(PREVENT_ENDERMAN_GRIEFING_NBT_KEY, true);

                    // trigger advancement
                    triggerMementoAdvancement(reference, stack);

                    // play sound
                    level.playSound(null, enderman.blockPosition(),
                            ModSoundEvents.ENDERMAN_ANKLET_TRIGGERED.get(), SoundSource.HOSTILE,
                            0.9f, 1.75f + level.getRandom().nextFloat() * 0.25f);

                    // damage memento
                    if (playerEntity instanceof Player player)
                        damageMemento(stack, (ServerLevel) level, (Player) player);

                    // spawn particles
                    if (level instanceof ServerLevel serverLevel) {
                        for (int i = 0; i < 20; i++) {
                            double offsetX = (level.random.nextDouble() - 0.5) * enderman.getBbWidth();
                            double offsetY = level.random.nextDouble() * enderman.getBbHeight();
                            double offsetZ = (level.random.nextDouble() - 0.5) * enderman.getBbWidth();
                            serverLevel.sendParticles(ParticleTypes.WHITE_SMOKE,
                                    enderman.getX() + offsetX,
                                    enderman.getY() + offsetY,
                                    enderman.getZ() + offsetZ,
                                    1, 0, 0, 0, 0);
                        }
                    }
                }
            }
        }
    }

    private List<Entity> getNearbyEndermen(Level level, Entity entity, double radius) {
        return level.getEntities(entity, entity.getBoundingBox().inflate(radius), e -> {
            return e instanceof Mob
                    && e.getType() == EntityType.ENDERMAN
                    && !(e.getPersistentData().getBoolean(PREVENT_ENDERMAN_GRIEFING_NBT_KEY));
        });
    }
}
