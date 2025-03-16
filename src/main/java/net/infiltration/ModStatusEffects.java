package net.infiltration;

import net.infiltration.AlchemyMod;
import net.infiltration.statuseffect.UnclearIntentEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    public static final RegistryEntry<StatusEffect> UNCLEAR_INTENT = Registry.registerReference(
            Registries.STATUS_EFFECT,
            Identifier.of(AlchemyMod.MOD_ID, "unclear_intent"),
            new UnclearIntentEffect()
    );

    public static void registerStatusEffects() {
        // Registration happens when the static field is initialized
        // This method just exists to be called from onInitialize to ensure initialization
        AlchemyMod.LOGGER.info("Registering status effects for " + AlchemyMod.MOD_ID);
    }
}