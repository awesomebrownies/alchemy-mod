package com.example;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AlchemyItemGroups {


        public static final ItemGroup ALCHEMY_GROUP = FabricItemGroup.builder()
                .icon(() -> new ItemStack(Items.EXPERIENCE_BOTTLE))
                .displayName(Text.translatable("itemGroup.tutorial.test_group"))
                .entries((context, entries) -> {
                    entries.add(ModItems.LADLE);
                })
                .build();


        public static void initialize()
        {
            Registry.register(Registries.ITEM_GROUP, Identifier.of("alchemy", "alchemy_mod"), ALCHEMY_GROUP);
        }
}
