package net.infiltration.statuseffect;

import net.infiltration.*;
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

                currentDialogue = TrashbeardHandler.retrieveRandomDialogue();
                player.sendMessage(Text.of(currentDialogue[0]), true);

                TaskScheduler.scheduleTask(() -> player.sendMessage(Text.of(currentDialogue[1]), true), 40);


                currentSwap = TrashbeardHandler.retrieveSwap();
                TaskScheduler.scheduleTask(() -> player.sendMessage(Text.of(keyPrettifier(currentSwap.getKey1()) + " -> "
                        + keyPrettifier(currentSwap.getKey2())), true), 80);

                handleKeybindSwap((PlayerEntity) entity);

                dialogueTimer = 0;
                dialogueInterval = ThreadLocalRandom.current().nextInt(15*20, 20*20);
                //15-20 second intervals
            }
        }
    }

    private static String keyPrettifier(String key){
        return switch (key) {
            case "key.jump" -> "Jump";
            case "key.sneak" -> "Sneak";
            case "key.sprint" -> "Sprint";
            case "key.left" -> "Left Strafe";
            case "key.right" -> "Right Strafe";
            case "key.back" -> "Walk Backward";
            case "key.forward" -> "Walk Forward";
            case "key.attack" -> "Attack";
            case "key.use" -> "Use";
            default -> key;
        };
    }

    private static void handleKeybindSwap(PlayerEntity player){
        //implementation for swapping keybinds
        if(player.getWorld().isClient){
            KeybindSwapProxy.handleKeybindSwap(player, currentSwap);
        }
    }
}
