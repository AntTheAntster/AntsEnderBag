package uk.co.anttheantster.antsenderbag.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import uk.co.anttheantster.antsenderbag.AntsEnderBag;

@EventBusSubscriber(modid = AntsEnderBag.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KeyBinds {
    public static final KeyBinds INSTANCE = new KeyBinds();
    private KeyBinds() {}

    private static final String CATEGORY = "Ant's Ender Bag";


    public static final KeyMapping openEchest = new KeyMapping(
            "key.antsenderbag.use", KeyConflictContext.IN_GAME, InputConstants.getKey(InputConstants.KEY_L, -1),
            CATEGORY
    );

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(openEchest);
    }

}
