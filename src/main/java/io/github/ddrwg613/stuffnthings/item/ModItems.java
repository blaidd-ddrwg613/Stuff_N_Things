package io.github.ddrwg613.stuffnthings.item;

import io.github.ddrwg613.stuffnthings.StuffNThings;
import io.github.ddrwg613.stuffnthings.block.ModBlocks;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StuffNThings.MODID);

    // Add Items to deferred register
    // Normal Items
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    // Advanced Item
    public static final RegistryObject<StickItem>  STICK_ITEM = ITEMS.register("a_stick", ()-> new StickItem(new Item.Properties()
            .durability(25)));
    // Food Item
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            ()-> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(5)
                            .saturationMod(0.2f)
                            .effect(() -> new MobEffectInstance(MobEffects.SATURATION,40,1),100)
                            .alwaysEat()
                            .fast()
                            .build())
                    .stacksTo(16)));
    // Fuel Item
    public static final RegistryObject<FuelItem> TINY_COAL = ITEMS.register("tiny_coal",
            ()-> new FuelItem(new Item.Properties(), 200));

    // Fuel Block ?? must be a better way to do this....
    public static final RegistryObject<FuelBlockItem> CHARCOAL_BLOCK = ITEMS.register("charcoal_block",
            ()-> new FuelBlockItem(ModBlocks.CHARCOAL_BLOCK.get(), new Item.Properties(),14400));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
