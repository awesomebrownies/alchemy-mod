package net.infiltration.statuseffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class UnclearIntentEffect extends StatusEffect {
    public UnclearIntentEffect(){
        super(StatusEffectCategory.HARMFUL, 0x7FB2FF);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier){
        return true;
    }
    public void applyUpdateEffect(LivingEntity entity, int amplifier){
        if(entity instanceof PlayerEntity && entity.getWorld().isClient){
            handleKeybindSwap((PlayerEntity) entity);
        }
    }

    private void handleKeybindSwap(PlayerEntity player){
        //implementation for swapping keybinds
    }
}
