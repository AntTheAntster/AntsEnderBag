package uk.co.anttheantster.antsenderbag.client;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import uk.co.anttheantster.antsenderbag.items.EnderBagItem;
import uk.co.anttheantster.antsenderbag.items.ModItems;

public class KeybindsHandler {

    @SubscribeEvent
    public void clientTick(PlayerTickEvent.Post event) {

        ItemStack item = new ItemStack(ModItems.ENDER_BAG.get());
        if (event.getEntity() instanceof Player player) {
            if (player.getInventory().contains(item)){
                if (KeyBinds.openEchest.consumeClick()){
                    EnderBagItem.openEchest(event.getEntity().level(), event.getEntity());
                }
            }
        }
    }
}
