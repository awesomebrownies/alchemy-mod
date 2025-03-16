package net.infiltration;

import net.minecraft.entity.player.PlayerEntity;

public interface KeybindSwapClient {
    void handleKeybindSwap(PlayerEntity player, Swap swap);
}
