package mod.syconn.hero;

import net.fabricmc.api.ModInitializer;

public class HeroFabric implements ModInitializer {
    
    public void onInitialize() {
        HeroCore.init();
    }
}
