package com.drunkencod.mob_mementos.item;

import com.drunkencod.mob_mementos.item.fixture.*;
import com.drunkencod.mob_mementos.item.material.*;
import com.drunkencod.mob_mementos.item.memento.*;
import com.drunkencod.mob_mementos.MobMementos;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MobMementos.MOD_ID);

    // #region Materials:

    public static final DeferredItem<EndermiteScaleItem> ENDERMITE_SCALE = ITEMS.register(
            EndermiteScaleItem.REGISTRY_NAME, EndermiteScaleItem::new);

    public static final DeferredItem<SilverfishScaleItem> SILVERFISH_SCALE = ITEMS.register(
            SilverfishScaleItem.REGISTRY_NAME, SilverfishScaleItem::new);

    // #region Fixtures:

    public static final DeferredItem<CrudeFixtureItem> CRUDE_FIXTURE = ITEMS.register(
            CrudeFixtureItem.REGISTRY_NAME, CrudeFixtureItem::new);

    public static final DeferredItem<RefinedFixtureItem> REFINED_FIXTURE = ITEMS.register(
            RefinedFixtureItem.REGISTRY_NAME, RefinedFixtureItem::new);

    // public static final DeferredItem<SupremeFixtureItem> SUPREME_FIXTURE =
    // ITEMS.register(SupremeFixtureItem.REGISTRY_NAME, SupremeFixtureItem::new);

    // #region Mementos:

    public static final DeferredItem<CreeperBeltItem> CREEPER_BELT = ITEMS.register(
            CreeperBeltItem.REGISTRY_NAME, CreeperBeltItem::new);

    public static final DeferredItem<ConduitNecklaceItem> CONDUIT_NECKLACE = ITEMS.register(
            ConduitNecklaceItem.REGISTRY_NAME, ConduitNecklaceItem::new);

    public static final DeferredItem<EndermanAnkletItem> ENDERMAN_ANKLET = ITEMS.register(
            EndermanAnkletItem.REGISTRY_NAME, EndermanAnkletItem::new);

    public static final DeferredItem<PhantomCloakItem> PHANTOM_CLOAK = ITEMS.register(
            PhantomCloakItem.REGISTRY_NAME, PhantomCloakItem::new);

    public static final DeferredItem<SilverfishBangleItem> SILVERFISH_BANGLE = ITEMS.register(
            SilverfishBangleItem.REGISTRY_NAME, SilverfishBangleItem::new);
}
