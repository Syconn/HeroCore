package mod.syconn.hero.registrar;

import mod.syconn.hero.HeroMod;
import mod.syconn.hero.item.MjolnirItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.function.Supplier;

public class ItemRegistrar {

    public static final Supplier<MjolnirItem> MJOLNIR = registerItem("mjolnir", () -> new MjolnirItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));

    public static void init() {}

    private static <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return HeroMod.REGISTRAR.registerItem(id, item);
    }
}
