package net.infiltration.potion;

import net.infiltration.AlchemyMod;
import net.infiltration.UnclearIntentPotion;
import net.infiltration.statuseffect.UnclearIntentEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<StatusEffect> UNCLEAR_INTENT = Registry.registerReference(
        Registries.STATUS_EFFECT,
        Identifier.of(AlchemyMod.MOD_ID, "unclear_intent"),
        new UnclearIntentEffect()
    );

    public static final RegistryEntry<Potion> UNCLEAR_INTENT_POTION = registerPotion("unclear_intent_potion",
        new Potion("unclear_intent", new StatusEffectInstance(UNCLEAR_INTENT, 3600, 0))
    );


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion){
        return Registry.registerReference(Registries.POTION, Identifier.of(AlchemyMod.MOD_ID, name), potion);
    }

//    public static void registerPotions(){
//        registerPotion("unclear_intent", (Potion) UNCLEAR_INTENT_POTION);
//        Registry.register(Registries.ITEM, Identifier.of("yourmodid", "keybind_swap_potion_item"), UnclearIntentPotion);
//    }

}
