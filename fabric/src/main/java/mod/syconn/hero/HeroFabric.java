package mod.syconn.hero;

import mod.syconn.hero.common.CommonHandler;
import mod.syconn.hero.events.LivingEntityEvents;
import mod.syconn.hero.network.Network;
import net.fabricmc.api.ModInitializer;

public class HeroFabric implements ModInitializer {
    
    public void onInitialize() {
        LivingEntityEvents.FALL_EVENT.register(CommonHandler::fallDamageEvent);
        
        HeroCore.init();
        Network.S2CPayloads();
    }
}
