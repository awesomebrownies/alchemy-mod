package net.infiltration;

import net.fabricmc.api.ModInitializer;

import net.infiltration.potion.ModPotions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlchemyMod implements ModInitializer {
    public static final String MOD_ID = "alchemy_mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // Register everything in the correct order
        ModStatusEffects.registerStatusEffects();
        ModItems.registerModItems();
        ModPotions.registerPotions();
        AlchemyItemGroups.initialize();
        TaskScheduler.init();


        LOGGER.info("AlchemyMod initialized successfully!");
    }
}