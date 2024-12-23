package mod.syconn.hero;

import mod.syconn.hero.client.ClientHandler;
import mod.syconn.hero.common.CommonHandler;
import mod.syconn.hero.util.CommonEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeCommon {

    @SubscribeEvent
    public static void clientTickEvent(TickEvent.PlayerTickEvent event) {
        if (event.side.isClient()) ClientHandler.onClientPlayerTick(event.player);
    }

    @SubscribeEvent
    public static void onFallEvent(LivingFallEvent pEvent) {
        CommonEvent<LivingEntity, Float, Float, Boolean> commonEvent = CommonHandler.fallDamageEvent(pEvent.getEntity(), pEvent.getDistance(), pEvent.getDamageMultiplier(), false);
        pEvent.setDistance(commonEvent.getP2());
        pEvent.setDamageMultiplier(commonEvent.getP3());
        pEvent.setCanceled(commonEvent.getResult());
    }
}
