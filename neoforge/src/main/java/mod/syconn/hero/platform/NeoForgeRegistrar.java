package mod.syconn.hero.platform;

import mod.syconn.hero.HeroCore;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class NeoForgeRegistrar implements IRegistrar {

    public <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return HeroCore.ITEMS.register(id, item);
    }
}