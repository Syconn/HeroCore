package mod.syconn.hero.platform;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public interface IRegistrar {

    <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item);
}
