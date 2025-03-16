package net.infiltration;

import net.minecraft.entity.player.PlayerEntity;

public class KeybindSwapProxy {
    private static KeybindSwapClient INSTANCE = ((player, swap) -> {

    });

    public static void setInstance(KeybindSwapClient instance){
        INSTANCE = instance;
    }

    public static void handleKeybindSwap(PlayerEntity entity, Swap swap){
        INSTANCE.handleKeybindSwap(entity, swap);
    }
}
