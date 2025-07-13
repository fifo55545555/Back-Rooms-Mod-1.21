package net.filpos_.backroomsMod.item;

import net.filpos_.backroomsMod.BackroomsMod;
import net.filpos_.backroomsMod.item.custom.ChiselItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BackroomsMod.MOD_ID);


    //new items here    names: general type -> specific variant  example: glitch_ore_sand_red
    public static final DeferredItem<Item> ALMOND_WATER = ITEMS.register("almond_water",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DIRTY_ALMOND_WATER = ITEMS.register("dirty_almond_water",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GLITCH = ITEMS.register("glitch",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GLITCH_RAW = ITEMS.register("glitch_raw",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(256)));


    //classes
    public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
    }
}
