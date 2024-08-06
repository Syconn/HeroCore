package mod.syconn.hero;

import mod.syconn.hero.network.Network;
import net.fabricmc.api.ModInitializer;

public class HeroFabric implements ModInitializer {
    
    public void onInitialize() {
        HeroCore.init();
        Network.S2CPayloads();
    }
}
