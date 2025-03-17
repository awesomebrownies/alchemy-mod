package net.infiltration.potion;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.infiltration.AlchemyMod;
import net.infiltration.ModStatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> UNCLEAR_INTENT_POTION = registerPotion("unclear_intent_potion",
            new Potion("unclear_intent", new StatusEffectInstance(ModStatusEffects.UNCLEAR_INTENT, 1200, 0)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion){
        return Registry.registerReference(Registries.POTION, Identifier.of(AlchemyMod.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        AlchemyMod.LOGGER.info("Registering potions for " + AlchemyMod.MOD_ID);

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, Items.TRIPWIRE_HOOK, UNCLEAR_INTENT_POTION);
        });
    }
}