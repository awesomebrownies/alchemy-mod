package net.infiltration.mixin;

import net.infiltration.AlchemyMod;
import net.infiltration.ModStatusEffects;
import net.infiltration.potion.ModPotions;
import net.infiltration.statuseffect.UnclearIntentEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "tickStatusEffects", at = @At("HEAD"))
    private void onTickStatusEffects(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity)(Object)this;

        // Check if the entity has your effect
        StatusEffectInstance effectInstance = entity.getStatusEffect(ModStatusEffects.UNCLEAR_INTENT);
        if (effectInstance != null) {
                UnclearIntentEffect.applyUpdateEffect(entity, effectInstance.getAmplifier());
        }
    }
}
