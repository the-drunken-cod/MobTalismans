package com.drunkencod.mob_mementos.item.memento;

import com.drunkencod.mob_mementos.config.ModStartupConfig;
import com.drunkencod.mob_mementos.MobMementos;
import com.drunkencod.mob_mementos.sound.ModSoundEvents;
import com.drunkencod.mob_mementos.tag.ModBlockTags;
import io.wispforest.accessories.api.slot.SlotReference;
import java.util.HashMap;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.InfestedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;

public class SilverfishBangleItem extends AbstractMementoItem {
    public static final String REGISTRY_NAME = "silverfish_bangle";

    private HashMap<Block, Block> uninfestedCache = new HashMap<>();

    public SilverfishBangleItem() {
        super(REGISTRY_NAME, getDefaultProps(ModStartupConfig.SILVERFISH_BANGLE.DURABILITY.get()));

        InfestedBlock.BLOCK_BY_HOST_BLOCK.forEach((hostBlock, infestedBlock) -> {
            uninfestedCache.put(infestedBlock, hostBlock);
        });
    }

    public boolean isEnabled() {
        return ModStartupConfig.SILVERFISH_BANGLE.ENABLED.get();
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        if (!isEnabled())
            return;

        Entity playerEntity = reference.entity();
        Level level = playerEntity.level();

        double radius = ModStartupConfig.SILVERFISH_BANGLE.RADIUS.get();
        int tickInterval = ModStartupConfig.SILVERFISH_BANGLE.CHECK_INTERVAL_TICKS.get();

        // if memento is broken, do nothing
        if (stack.getMaxDamage() > 0 && stack.getDamageValue() >= stack.getMaxDamage())
            return;

        // check for infested blocks nearby at specified tick interval
        if (playerEntity.tickCount > 0 && playerEntity.tickCount % tickInterval == 0) {
            List<BlockPos> nearbyInfestedBlocks = getNearbyInfestedBlocks(level, playerEntity, radius);
            if (!nearbyInfestedBlocks.isEmpty()) {
                int i = 0;
                for (BlockPos blockPos : nearbyInfestedBlocks) {
                    if (!level.isClientSide()) {
                        MobMementos.LOGGER.debug("[Silverfish Bangle]: Uninfesting block at {}", blockPos);

                        // uninfest block
                        level.setBlockAndUpdate(blockPos, getUninfestedState(level, blockPos));

                        // trigger advancement
                        triggerMementoAdvancement(reference, stack);

                        // damage memento
                        if (playerEntity instanceof Player player)
                            damageMemento(stack, (ServerLevel) level, (Player) player);
                    }

                    // play sound
                    if (i < 3)
                        level.playSound(null, blockPos, ModSoundEvents.SILVERFISH_BANGLE_TRIGGERED.get(),
                                SoundSource.BLOCKS, 0.4f, 0.8f + level.getRandom().nextFloat() * 0.4f);
                    i++;
                }
            }
        }
    }

    private List<BlockPos> getNearbyInfestedBlocks(Level level, Entity entity, double radius) {
        BlockPos center = entity.blockPosition();
        int r = (int) Math.ceil(radius);

        return BlockPos.betweenClosedStream(center.offset(-r, -r, -r), center.offset(r, r, r))
                .filter(pos -> pos.closerToCenterThan(entity.position(), radius)) // spherical check
                .filter(pos -> level.getBlockState(pos).is(ModBlockTags.INFESTED))
                .map(BlockPos::immutable) // important! stream positions are mutable
                .toList();
    }

    private BlockState getUninfestedState(Level level, BlockPos pos) {
        BlockState infestedState = level.getBlockState(pos);
        Block infestedBlock = infestedState.getBlock();
        Block uninfestedBlock = uninfestedCache.get(infestedBlock);
        if (uninfestedBlock != null)
            return uninfestedBlock.defaultBlockState();
        return infestedState;
    }
}
