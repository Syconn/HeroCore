package mod.syconn.hero.registrar;

import mod.syconn.hero.Constants;
import mod.syconn.hero.platform.Services;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

public class ArmorMaterialRegistrar {

    public static final Supplier<ArmorMaterial> MARK_42 = Services.REGISTRAR.registerArmorMaterial("mark_42", () -> new ArmorMaterial(new HashMap<>() {{
        put(ArmorItem.Type.BOOTS, 2);
        put(ArmorItem.Type.LEGGINGS, 5);
        put(ArmorItem.Type.CHESTPLATE, 6);
        put(ArmorItem.Type.HELMET, 2);
        put(ArmorItem.Type.BODY, 5);
    }}, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(ItemRegistrar.TITANIUM_PLATE.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "mark_42"))),0.0F, 0.0F));

    public static void init() {}
}
