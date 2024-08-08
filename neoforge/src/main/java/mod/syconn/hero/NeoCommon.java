package mod.syconn.hero;

import mod.syconn.hero.client.ClientHandler;
import mod.syconn.hero.common.CommonHandler;
import mod.syconn.hero.util.CommonEvent;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

public class NeoCommon {

    @SubscribeEvent
    public static void clientTickEvent(final PlayerTickEvent.Post event) {
        if (event.getEntity().level().isClientSide()) ClientHandler.onClientPlayerTick(event.getEntity());
    }

    @SubscribeEvent
    public static void onFallEvent(LivingFallEvent pEvent) {
        CommonEvent<LivingEntity, Float, Float, Boolean> commonEvent = CommonHandler.fallDamageEvent(pEvent.getEntity(), pEvent.getDistance(), pEvent.getDamageMultiplier(), false);
        pEvent.setDistance(commonEvent.getP2());
        pEvent.setDamageMultiplier(commonEvent.getP3());
        pEvent.setCanceled(commonEvent.getResult());
    }
}
