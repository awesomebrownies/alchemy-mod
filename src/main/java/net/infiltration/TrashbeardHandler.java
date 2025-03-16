package net.infiltration;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.concurrent.ThreadLocalRandom;

public class TrashbeardHandler {
    public static void sendActionBar(ServerPlayerEntity player, String message) {
        player.sendMessage(Text.literal(message).formatted(Formatting.YELLOW), true);
    }
    public static String[] retrieveStartDialogue(){
        String[][] dialogue = {{
            "Oh! Don't mind me j-just tinkering around", "*trips* AH!"
        }};

        return dialogue[ThreadLocalRandom.current().nextInt(0, dialogue.length)];
    }
    public static String[] retrieveRandomDialogue(){
        String[][] dialogue = {
                {"Levers, hmmm, OH! Another one!", "The real problem... which one do i flip?"},
                {"s-sparks! *puts two cables together together*", "*regrets life choices*"},
        };

        return dialogue[ThreadLocalRandom.current().nextInt(0, dialogue.length)];
    }
    public static Swap retrieveSwap(){
        String[] keys = {"key.jump", "key.sneak", "key.sprint", "key.left", "key.right", "key.back", "key.forward", "key.attack", "key.use"};
        int firstIndex = ThreadLocalRandom.current().nextInt(0, keys.length);
        String randomKey = keys[firstIndex];
        int secondIndex = ThreadLocalRandom.current().nextInt(0, keys.length-1);
        if(secondIndex == firstIndex){
            secondIndex++;
        }
        String secondRandomKey = keys[secondIndex];

        return new Swap(randomKey, secondRandomKey);
    }
}
