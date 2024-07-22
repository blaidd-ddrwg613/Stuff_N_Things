package io.github.ddrwg613.stuffnthings;

import io.github.ddrwg613.stuffnthings.block.ModBlocks;
import io.github.ddrwg613.stuffnthings.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StuffNThings.MODID);


    public static final RegistryObject<CreativeModeTab> STUFF_N_THINGS_TAB = CREATIVE_MODE_TABS.register("stuff_n_things_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab_stuff_n_things"))
                    .displayItems((parameters, output) -> {
                        for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                            output.accept(item.get());
                        }
                        for (RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()) {
                            output.accept(block.get());
                        }
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
