package mod.syconn.hero;

import mod.syconn.hero.network.Network;
import mod.syconn.hero.registrar.EntityRegistrar;
import mod.syconn.hero.registrar.ItemRegistrar;

public class HeroCore {

    public static void init() {
        Network.registerMessages();
        EntityRegistrar.init();
        ItemRegistrar.init();
    }
}