package com.example;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.text.Text;

public class Ladle extends Item {
    public Ladle(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand)
    {



//        user.sendMessage(new LiteralText("This item is to be used on a cauldron containing water."), false);

        return ActionResult.SUCCESS;

    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        BlockState blockstate = world.getBlockState(context.getBlockPos());
        PlayerEntity player = context.getPlayer();

        ItemStack bottle = null;
        if (blockstate.getBlock() == Blocks.WATER_CAULDRON) {

            assert player != null;
            player.playSound(SoundEvents.ENTITY_GENERIC_SPLASH, 1.0F, 1.0F);

            bottle = new ItemStack(Items.GLASS_BOTTLE, 1);

            player.giveItemStack(bottle);

            return ActionResult.SUCCESS;
        }


        return super.useOnBlock(context);

    }



}
