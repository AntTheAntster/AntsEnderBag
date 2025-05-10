package uk.co.anttheantster.antsenderbag.items;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.co.anttheantster.antsenderbag.AntsEnderBag;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(AntsEnderBag.MODID);
    public static final void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final Supplier<Item> ENDER_BAG = ITEMS.register("ender_bag", EnderBagItem::new);

    public static final Supplier<Item> ENDER_CORE = ITEMS.register("ender_core", EnderCoreItem::new);


}
