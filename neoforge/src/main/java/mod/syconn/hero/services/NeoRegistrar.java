package mod.syconn.hero.services;

import mod.syconn.hero.HeroNeo;
import mod.syconn.hero.platform.services.IRegistrar;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import java.util.function.Supplier;

public class NeoRegistrar implements IRegistrar {

    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntityType) {
        return HeroNeo.BLOCK_ENTITIES.register(id, blockEntityType);
    }

    public <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        return HeroNeo.BLOCKS.register(id, block);
    }

    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String id, Supplier<EntityType<T>> entity) {
        return HeroNeo.ENTITIES.register(id, entity);
    }

    public <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return HeroNeo.ITEMS.register(id, item);
    }

    public <T extends ArmorMaterial> Holder<T> registerArmorMaterial(String id, Supplier<T> armorMaterial) {
        return (Holder<T>) HeroNeo.ARMOR_MATERIALS.register(id, armorMaterial);
    }

    public <T extends SoundEvent> Supplier<T> registerSound(String id, Supplier<T> sound) {
        return HeroNeo.SOUND_EVENTS.register(id, sound);
    }

    public <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String id, Supplier<T> tab) {
        return HeroNeo.CREATIVE_TABS.register(id, tab);
    }

    public <E extends Mob> Supplier<SpawnEggItem> makeSpawnEggFor(Supplier<EntityType<E>> entityType, int primaryEggColour, int secondaryEggColour, Item.Properties itemProperties) {
        return () -> new DeferredSpawnEggItem(entityType, primaryEggColour, secondaryEggColour, itemProperties);
    }

    public CreativeModeTab.Builder newCreativeTabBuilder() {
        return CreativeModeTab.builder();
    }
}