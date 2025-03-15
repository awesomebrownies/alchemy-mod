package com.example;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.registry.Registry;


import java.util.function.Function;


public final class ModItems {

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(AlchemyMod.MOD_ID, "alchemy"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.EXPERIENCE_BOTTLE))
            .displayName(Text.translatable("itemGroup.fabric_docs_reference"))
            .build();

    private ModItems() {
    }

    public static final Ladle LADLE = (Ladle) register("ladle", Ladle::new, new Item.Settings());

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("alchemy_mod", path));
        return Items.register(registryKey, factory, settings);
    }



    public static void initialize() {
    }
}