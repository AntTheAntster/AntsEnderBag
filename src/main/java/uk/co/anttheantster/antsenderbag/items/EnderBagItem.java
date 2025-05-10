package uk.co.anttheantster.antsenderbag.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class EnderBagItem extends Item {

    public EnderBagItem() {
        super(new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.EPIC)
                .fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltips, TooltipFlag tooltipFlag) {

        tooltips.add(Component.translatable("item.antsenderbag.tooltip"));

        super.appendHoverText(stack, context, tooltips, tooltipFlag);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        openEchest(level, player);

        return InteractionResultHolder.success(player.getItemInHand(usedHand));
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
