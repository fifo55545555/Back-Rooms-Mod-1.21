package net.filpos_.backroomsMod.item;

import net.filpos_.backroomsMod.BackroomsMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BackroomsMod.MOD_ID);

    public static final DeferredItem<Item> ALMOND_WATER = ITEMS.register("almondwater",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
    }
}
