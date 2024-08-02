package mod.syconn.hero;

import net.fabricmc.api.ModInitializer;

public class HeroCore implements ModInitializer {
    
    @Override
    public void onInitialize() {
        HeroMod.init();
    }
}
