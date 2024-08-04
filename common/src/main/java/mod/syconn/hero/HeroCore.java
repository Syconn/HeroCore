package mod.syconn.hero;

import mod.syconn.hero.registrar.ArmorMaterialRegistrar;
import mod.syconn.hero.registrar.EntityRegistrar;
import mod.syconn.hero.registrar.ItemRegistrar;

public class HeroCore {

    public static void init() {
        EntityRegistrar.init();
        ArmorMaterialRegistrar.init();
        ItemRegistrar.init();
    }
}