package net.infiltration.statuseffect;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.infiltration.Swap;
import net.infiltration.TaskScheduler;
import net.infiltration.TrashbeardHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

import java.util.concurrent.ThreadLocalRandom;

public class UnclearIntentEffect extends StatusEffect {

    private static int dialogueTimer = 0;
    private static int dialogueInterval = 40;

    public static String[] currentDialogue = {};
    public static Swap currentSwap = new Swap("", "");

    public UnclearIntentEffect(){
        super(StatusEffectCategory.HARMFUL, 0x7FB2FF);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier){
        return true;
    }
    public static void applyUpdateEffect(LivingEntity entity, int amplifier){
        if(entity instanceof PlayerEntity player && entity.getWorld().isClient){
            dialogueTimer++;
            if(dialogueTimer > dialogueInterval){
//                handleKeybindSwap((PlayerEntity) entity);

                currentDialogue = TrashbeardHandler.retrieveRandomDialogue();
                player.sendMessage(Text.of(currentDialogue[0]), true);

                TaskScheduler.scheduleTask(() -> player.sendMessage(Text.of(currentDialogue[1]), true), 40);


                currentSwap = TrashbeardHandler.retrieveSwap();
                TaskScheduler.scheduleTask(() -> player.sendMessage(Text.of(currentSwap.getKey1() + " -> " + currentSwap.getKey2()), true), 80);

                dialogueTimer = 0;
                dialogueInterval = ThreadLocalRandom.current().nextInt(15*20, 20*20);
                //15-20 second intervals
            }
        }
    }

    private void handleKeybindSwap(PlayerEntity player){
        //implementation for swapping keybinds
    }
}
