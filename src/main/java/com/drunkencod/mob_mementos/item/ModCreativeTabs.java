package com.drunkencod.mob_mementos.item;

import com.drunkencod.mob_mementos.item.memento.AbstractMementoItem;
import com.drunkencod.mob_mementos.MobMementos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, MobMementos.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOB_MEMENTOS_TAB = CREATIVE_MODE_TABS
            .register("mob_mementos_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mob_mementos"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.CONDUIT_NECKLACE.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        addMementoItem(output, ModItems.CONDUIT_NECKLACE.get());
                        addMementoItem(output, ModItems.CREEPER_BELT.get());
                        addMementoItem(output, ModItems.ENDERMAN_ANKLET.get());
                        addMementoItem(output, ModItems.PHANTOM_CLOAK.get());
                        addMementoItem(output, ModItems.SILVERFISH_BANGLE.get());

                        output.accept(ModItems.CRUDE_FIXTURE.get());
                        output.accept(ModItems.REFINED_FIXTURE.get());
                        // output.accept(ModItems.SUPREME_FIXTURE.get());

                        output.accept(ModItems.ENDERMITE_SCALE.get());
                        output.accept(ModItems.SILVERFISH_SCALE.get());
                    }).build());

    private static void addMementoItem(CreativeModeTab.Output output, AbstractMementoItem item) {
        if (item.isEnabled())
            output.accept(item);
    }
}
