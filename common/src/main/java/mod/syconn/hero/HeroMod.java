package mod.syconn.hero;

import mod.syconn.hero.platform.IRegistrar;
import mod.syconn.hero.registrar.ItemRegistrar;

import java.util.ServiceLoader;

public class HeroMod {

    public static final IRegistrar REGISTRAR = ServiceLoader.load(IRegistrar.class).findFirst().orElseThrow();

    public static void init() {
        ItemRegistrar.init();
    }
}