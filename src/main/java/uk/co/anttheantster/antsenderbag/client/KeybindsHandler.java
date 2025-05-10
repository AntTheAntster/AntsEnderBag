package uk.co.anttheantster.antsenderbag.client;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import uk.co.anttheantster.antsenderbag.items.EnderBagItem;

public class KeybindsHandler {

    @SubscribeEvent
    public void clientTick(PlayerTickEvent.Post event) {

        if (KeyBinds.openEchest.consumeClick()){
            EnderBagItem.openEchest(event.getEntity().level(), event.getEntity());
        }
    }

}
