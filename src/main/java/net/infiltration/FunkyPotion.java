//package com.example;
//
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.projectile.ProjectileEntity;
//import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.potion.Potion;
//import net.minecraft.potion.PotionUtil;
//import net.minecraft.registry.entry.RegistryEntry;
//import net.minecraft.util.ActionResult;
//import net.minecraft.util.Hand;
//import net.minecraft.world.World;
//import net.minecraft.util.math.Vec3d;
//import net.minecraft.item.Items;
//import net.minecraft.potion.Potions;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.List;
//import java.util.Random;
//
//public class FunkyPotion extends Item {
//
//    public FunkyPotion(Settings settings) {
//        super(settings);
//    }
//
//    @Override
//    public ActionResult use(World world, PlayerEntity user, Hand hand) {
//        if (world.isClient) {
//            return ActionResult.SUCCESS;
//        }
//
//        // Define a list of potions to choose from (excluding Mundane, Thick, and Awkward)
//        List<@NotNull RegistryEntry<Potion>> potions = List.of(
//                Potions.WATER,            // Water potion
//                Potions.REGENERATION,     // Regeneration potion
//                Potions.SWIFTNESS,        // Swiftness potion
//                Potions.STRENGTH,         // Strength potion
//                Potions.INVISIBILITY,     // Invisibility potion
//                Potions.FIRE_RESISTANCE   // Fire Resistance potion
//        );
//
//        // Randomly select a potion from the list
//        Random random = new Random();
//        Potion selectedPotion = (Potion) potions.get(random.nextInt(potions.size()));
//
//        // Create the potion ItemStack
//        ItemStack potionItemStack = PotionUtil.setPotion(new ItemStack(Items.SPLASH_POTION), selectedPotion);
//
//        // Create the ThrownItemEntity (this is a generic thrown entity for items)
//        ThrownItemEntity thrownPotionEntity = new ThrownItemEntity(world, user);
//
//        // Set the potion item stack
//        thrownPotionEntity.setStack(potionItemStack);
//
//        // Set the potion's motion (direction and speed)
//        Vec3d direction = user.getRotationVector();  // Get the direction the player is facing
//        thrownPotionEntity.setVelocity(direction.x * 0.5, direction.y * 0.5, direction.z * 0.5); // Adjust velocity as needed
//
//        // Spawn the thrown potion entity in the world
//        world.spawnEntity(thrownPotionEntity);
//
//        return ActionResult.SUCCESS; // Return success
//    }
//}
