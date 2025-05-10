package uk.co.anttheantster.antsenderbag.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class EnderBagItem extends Item {

    public EnderBagItem() {
        super(new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.EPIC)
                .fireResistant()
                .equippable(EquipmentSlot.BODY)
                .setId(ResourceKey.create(Registries.ITEM,
                        ResourceLocation.fromNamespaceAndPath("antsenderbag", "ender_bag"))));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltips, TooltipFlag tooltipFlag) {


        tooltips.accept(Component.translatable("item.antsenderbag.tooltip"));

        super.appendHoverText(stack, context, tooltipDisplay, tooltips, tooltipFlag);

    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

        openEchest(level, player);
        return InteractionResult.CONSUME;
    }

    public static void openEchest(Level level, Player player) {
        if (!level.isClientSide()) {
            player.openMenu(new SimpleMenuProvider(
                    (id, inventory, playerEntity) -> ChestMenu.threeRows(id, inventory, player.getEnderChestInventory()),
                    Component.translatable("container.enderchest")
            ));
        }
    }
}
