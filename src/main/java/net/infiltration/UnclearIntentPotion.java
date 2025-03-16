package net.infiltration;

import net.infiltration.potion.ModPotions;
import net.infiltration.statuseffect.UnclearIntentEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.PotionItem;
import net.minecraft.item.consume.UseAction;
import net.minecraft.world.World;

public class UnclearIntentPotion extends PotionItem {
    public UnclearIntentPotion(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entity){
        PlayerEntity player = entity instanceof PlayerEntity ? (PlayerEntity) entity : null;
        assert player != null;

        player.addStatusEffect(new StatusEffectInstance(ModPotions.UNCLEAR_INTENT, 3600, 0));

        return stack;
    }

    @Override
    public UseAction getUseAction(ItemStack stack){
        return UseAction.DRINK;
    }


}
