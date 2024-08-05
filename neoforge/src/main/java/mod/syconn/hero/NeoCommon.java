package mod.syconn.hero;

import mod.syconn.hero.client.ClientHandler;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

public class NeoCommon {

    @SubscribeEvent
    public static void clientTickEvent(final PlayerTickEvent.Post event) {
        if (event.getEntity().level().isClientSide()) ClientHandler.onClientPlayerTick(event.getEntity());
    }
}
