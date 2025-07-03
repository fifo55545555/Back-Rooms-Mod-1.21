package net.filpos_.backroomsMod.block;

import net.filpos_.backroomsMod.BackroomsMod;
import net.filpos_.backroomsMod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    //initialized register for blocks
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BackroomsMod.MOD_ID);


    //new blocks here
    public static final DeferredBlock<Block> YELLOW_WALLPAPER = registerBlock("yellow_wallpaper",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .sound(SoundType.BAMBOO_WOOD)
            ));

    public static final DeferredBlock<Block> FLOOR_FABRIC = registerBlock("floor_fabric",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .sound(SoundType.WOOL)
            ));

    public static final DeferredBlock<Block> GLITCH_ORE_SAND = registerBlock("glitch_ore_sand",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .sound(SoundType.SAND)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> GLITCH_ORE_SAND_RED = registerBlock("glitch_ore_sand_red",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .sound(SoundType.SAND)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> GLITCH_BLOCK = registerBlock("glitch_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .sound(SoundType.AMETHYST)
                    .requiresCorrectToolForDrops()
            ));
    public static final DeferredBlock<Block> CEILING_TILE  = registerBlock("ceiling_tile",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .sound(SoundType.TUFF_BRICKS)
                    .requiresCorrectToolForDrops()
            ));


    // methods
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
