package net.filpos_.backroomsMod.item;

import net.filpos_.backroomsMod.BackroomsMod;
import net.filpos_.backroomsMod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    //initialized register for creative mode tabs
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BackroomsMod.MOD_ID);


    //new creative mode tabs here

    // items
    public static final Supplier<CreativeModeTab> BACKROOMS_ITEMS_TAB = CREATIVE_MODE_TAB.register("backrooms_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALMOND_WATER.get()))
                    .title(Component.translatable("creativetab.backroomsmod.backrooms_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.ALMOND_WATER);
                        output.accept(ModItems.DIRTY_ALMOND_WATER);
                        output.accept(ModItems.GLITCH);
                        output.accept(ModItems.GLITCH_RAW);
                        output.accept(Item.byId(1));
                    }).build());

    // blocks
    public static final Supplier<CreativeModeTab> BACKROOMS_BLOCK_TAB = CREATIVE_MODE_TAB.register("backrooms_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.YELLOW_WALLPAPER.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(BackroomsMod.MOD_ID,"backrooms_items_tab"))   // Backrooms items tab always comes first
                    .title(Component.translatable("creativetab.backroomsmod.backrooms_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.YELLOW_WALLPAPER);
                        output.accept(ModBlocks.FLOOR_FABRIC);
                        output.accept(ModBlocks.GLITCH_ORE_SAND);
                        output.accept(ModBlocks.GLITCH_ORE_SAND_RED);
                        output.accept(ModBlocks.GLITCH_BLOCK);
                        output.accept(ModBlocks.CEILING_TILE);
                    }).build());

    //methods
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
