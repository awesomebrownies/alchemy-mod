package net.infiltration;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;


import java.util.function.Function;


public final class ModItems {

    private ModItems() {
    }

    public static final Ladle LADLE = (Ladle) registerItem("ladle", Ladle::new, new Item.Settings());

    public static Item registerItem(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("alchemy_mod", path));
        return Items.register(registryKey, factory, settings);
    }

    private static void customPotions(FabricItemGroupEntries entries){
        entries.add(LADLE);
    }


    public static void registerModItems() {
        // Just log that initialization happened
        AlchemyMod.LOGGER.info("Initializing ModItems");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customPotions);
    }
}