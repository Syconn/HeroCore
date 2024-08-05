package mod.syconn.hero;

import mod.syconn.hero.services.FabricNetwork;
import net.fabricmc.api.ModInitializer;

public class HeroFabric implements ModInitializer {
    
    public void onInitialize() {
        HeroCore.init();
        FabricNetwork.registerServerPayloads();
    }
}
