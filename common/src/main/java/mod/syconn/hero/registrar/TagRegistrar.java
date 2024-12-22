package mod.syconn.hero.registrar;

import mod.syconn.hero.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public class TagRegistrar {
    
    public static TagKey<Item> TITANIUM_PLATE = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "titanium_plate"));

    public static final ResourceKey<EquipmentAsset> MARK_42 = EquipmentAssets.createId("mark_42");
}
