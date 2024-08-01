package mod.syconn.hero;

import net.fabricmc.api.ModInitializer;

public class HeroCore implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();
    }
}
