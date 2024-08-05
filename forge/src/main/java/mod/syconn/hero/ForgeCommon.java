package mod.syconn.hero;

import mod.syconn.hero.client.ClientHandler;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeCommon {

    @SubscribeEvent
    public static void clientTickEvent(TickEvent.PlayerTickEvent event) {
        if (event.side.isClient()) ClientHandler.onClientPlayerTick(event.player);
    }
}
