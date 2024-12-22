package mod.syconn.hero.datagen;

import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;

import static mod.syconn.hero.registrar.ItemRegistrar.*;

public class CommonLang {

    public static void generateItems(BiConsumer<Item, String> add) {
        add.accept(MJOLNIR.get(), "Mjolnir");
        add.accept(SHURIKEN.get(), "Shuriken");
        add.accept(GAUNTLET.get(), "Iron Man Gauntlet");
        add.accept(MARK_42_HELMET.get(), "Mark 42 Helmet");
        add.accept(MARK_42_CHESTPLATE.get(), "Mark 42 Chestplate");
        add.accept(MARK_42_LEGGINGS.get(), "Mark 42 Leggings");
        add.accept(MARK_42_BOOTS.get(), "Mark 42 Boots");
        add.accept(INGOT_STEEL.get(), "Steel Ingot");
        add.accept(INGOT_TIN.get(), "Tin Ingot");
        add.accept(TITANIUM_PLATE.get(), "Titanium Plate");
        add.accept(ARC_REACTOR.get(), "Arc Reactor");
    }

    public static void generateString(BiConsumer<String, String> add) {
        add.accept("itemGroup.hero.hero_items", "Super Hero Gear");
    }
}
