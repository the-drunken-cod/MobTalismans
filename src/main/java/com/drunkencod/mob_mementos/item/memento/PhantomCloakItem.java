package com.drunkencod.mob_mementos.item.memento;

import com.drunkencod.mob_mementos.config.ModStartupConfig;

public class PhantomCloakItem extends AbstractMementoItem {
    public static final String REGISTRY_NAME = "phantom_cloak";

    public PhantomCloakItem() {
        super(REGISTRY_NAME, getDefaultProps(ModStartupConfig.PHANTOM_CLOAK.DURABILITY.get()));
    }

    public boolean isEnabled() {
        return ModStartupConfig.PHANTOM_CLOAK.ENABLED.get();
    }
}
