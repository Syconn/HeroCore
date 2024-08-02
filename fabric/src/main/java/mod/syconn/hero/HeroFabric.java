package mod.syconn.hero;

import net.fabricmc.api.ModInitializer;

public class HeroFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        HeroCore.init();
    }
}
