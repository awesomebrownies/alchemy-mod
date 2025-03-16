package net.infiltrationclient;

import net.infiltration.AlchemyMod;
import net.infiltration.Swap;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;

public class KeybindSwapImpl implements net.infiltration.KeybindSwapClient{
    public void handleKeybindSwap(PlayerEntity player, Swap swap){
        MinecraftClient client = MinecraftClient.getInstance();

        KeyBinding[] keyBindings = client.options.allKeys;

        KeyBinding key1 = null;
        KeyBinding key2 = null;

        for(KeyBinding keyBinding : keyBindings){

            if(keyBinding.getTranslationKey().equals(swap.getKey1())){
                key1 = keyBinding;
            }else if(keyBinding.getTranslationKey().equals(swap.getKey2())){
                key2 = keyBinding;
            }
        }
        //continue forward if both are valid
        if(key1 != null  && key2 != null){
            KeyBinding keyStorage = key1;
            key1.setBoundKey(key2.getDefaultKey());
            key2.setBoundKey(keyStorage.getDefaultKey());

            KeyBinding.updateKeysByCode();
            client.options.write();
        }
    }
}
