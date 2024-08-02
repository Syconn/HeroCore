package mod.syconn.hero.registrar;

import mod.syconn.hero.Constants;
import mod.syconn.hero.item.MjolnirItem;
import mod.syconn.hero.platform.Services;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import java.util.function.Supplier;

public class ItemRegistrar {

    public static final Supplier<MjolnirItem> MJOLNIR = registerItem("mjolnir", () -> new MjolnirItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));

    public static final Supplier<CreativeModeTab> TAB = Services.REGISTRAR.registerCreativeModeTab("hero_items", () -> Services.REGISTRAR.newCreativeTabBuilder()
            .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".hero_items"))
            .icon(() -> new ItemStack(MJOLNIR.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(MJOLNIR.get());
            }).build());

    public static void init() {}

    private static <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return Services.REGISTRAR.registerItem(id, item);
    }
}
