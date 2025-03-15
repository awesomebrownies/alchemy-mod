package com.example;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.registry.Registry;


import java.util.function.Function;


public final class ModItems {
    private ModItems() {
    }

    public static final Ladle LADLE = (Ladle) register("ladle", Ladle::new, new Item.Settings());

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("ladle", path));
        return Items.register(registryKey, factory, settings);
    }

    public static void initialize() {
    }
}