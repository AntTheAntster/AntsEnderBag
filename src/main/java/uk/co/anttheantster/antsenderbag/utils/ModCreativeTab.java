package uk.co.anttheantster.antsenderbag.utils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.co.anttheantster.antsenderbag.AntsEnderBag;
import uk.co.anttheantster.antsenderbag.items.ModItems;

import java.util.function.Supplier;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AntsEnderBag.MODID);

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

    public static final Supplier<CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TAB.register("creative_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.antsenderbag.tabname"))
                    .icon(() -> new ItemStack(ModItems.ENDER_BAG.get()))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.ENDER_BAG.get().getDefaultInstance());
                        output.accept(ModItems.ENDER_CORE.get().getDefaultInstance());

                    }).build());
}
