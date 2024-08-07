package mod.syconn.hero.registrar;

import mod.syconn.hero.Constants;
import mod.syconn.hero.item.MjolnirItem;
import mod.syconn.hero.platform.Services;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;

import java.util.function.Supplier;

public class ItemRegistrar {

    public static final Supplier<MjolnirItem> MJOLNIR = registerItem("mjolnir", () -> new MjolnirItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static final Supplier<Item> SHURIKEN = registerItem("shuriken",() -> new Item(new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> GAUNTLET = registerItem("repulsor", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final Supplier<Item> MARK_42_HELMET = registerItem("mark_42_helmet", () -> new ArmorItem(ArmorMaterials.MARK_42, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15))));
    public static final Supplier<Item> MARK_42_CHESTPLATE = registerItem("mark_42_chestplate", () -> new ArmorItem(ArmorMaterials.MARK_42, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15))));
    public static final Supplier<Item> MARK_42_LEGGINGS = registerItem("mark_42_leggings", () -> new ArmorItem(ArmorMaterials.MARK_42, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))));
    public static final Supplier<Item> MARK_42_BOOTS = registerItem("mark_42_boots", () -> new ArmorItem(ArmorMaterials.MARK_42, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(15))));

    public static final Supplier<Item> INGOT_STEEL = registerItem("ingot_steel", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final Supplier<Item> INGOT_TIN = registerItem("ingot_tin", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final Supplier<Item> TITANIUM_PLATE = registerItem("titanium_plate", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> ARC_REACTOR = registerItem("arc_reactor", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final Supplier<CreativeModeTab> TAB = Services.REGISTRAR.registerCreativeModeTab("hero_items", () -> Services.REGISTRAR.newCreativeTabBuilder()
            .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".hero_items"))
            .icon(() -> new ItemStack(MJOLNIR.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(MJOLNIR.get());
                entries.accept(SHURIKEN.get());
                entries.accept(GAUNTLET.get());
                entries.accept(MARK_42_HELMET.get());
                entries.accept(MARK_42_CHESTPLATE.get());
                entries.accept(MARK_42_LEGGINGS.get());
                entries.accept(MARK_42_BOOTS.get());
                entries.accept(ARC_REACTOR.get());
                entries.accept(INGOT_STEEL.get());
                entries.accept(INGOT_TIN.get());
                entries.accept(TITANIUM_PLATE.get());
            }).build());

    public static void init() {}

    private static <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return Services.REGISTRAR.registerItem(id, item);
    }
}
