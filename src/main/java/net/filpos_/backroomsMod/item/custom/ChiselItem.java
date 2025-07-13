package net.filpos_.backroomsMod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;


import java.util.Map;

public class ChiselItem extends Item {

    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.OAK_PLANKS,  Blocks.BIRCH_PLANKS,
                    Blocks.BIRCH_PLANKS, Blocks.ACACIA_PLANKS,
                    Blocks.ACACIA_PLANKS, Blocks.SPRUCE_PLANKS,
                    Blocks.SPRUCE_PLANKS, Blocks.DARK_OAK_PLANKS,
                    Blocks.DARK_OAK_PLANKS, Blocks.CRIMSON_PLANKS,
                    Blocks.CRIMSON_PLANKS, Blocks.WARPED_PLANKS,
                    Blocks.WARPED_PLANKS, Blocks.OAK_PLANKS,
                    Blocks.SANDSTONE,Blocks.END_STONE_BRICKS
            );


    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

            if(CHISEL_MAP.containsKey(clickedBlock) && !level.isClientSide) {
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());
                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                                item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }

        return InteractionResult.SUCCESS;
    }

}
