package io.github.ddrwg613.stuffnthings.item;

import io.github.ddrwg613.stuffnthings.StuffNThings;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StuffNThings.MODID);

    // Add Items to deferred register
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    public static final RegistryObject<StickItem>  STICK_ITEM = ITEMS.register("a_stick", ()-> new StickItem(new Item.Properties()
            .durability(25)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
