package mod.syconn.hero;

import mod.syconn.hero.platform.services.IRegistrar;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import java.util.function.Supplier;

public class NeoForgeRegistrar implements IRegistrar {

    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntityType) {
        return HeroNeoForge.BLOCK_ENTITIES.register(id, blockEntityType);
    }

    public <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        return HeroNeoForge.BLOCKS.register(id, block);
    }

    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String id, Supplier<EntityType<T>> entity) {
        return HeroNeoForge.ENTITIES.register(id, entity);
    }

    public <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return HeroNeoForge.ITEMS.register(id, item);
    }

    public <T extends SoundEvent> Supplier<T> registerSound(String id, Supplier<T> sound) {
        return HeroNeoForge.SOUND_EVENTS.register(id, sound);
    }

    public <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String id, Supplier<T> tab) {
        return HeroNeoForge.CREATIVE_TABS.register(id, tab);
    }

    public <E extends Mob> Supplier<SpawnEggItem> makeSpawnEggFor(Supplier<EntityType<E>> entityType, int primaryEggColour, int secondaryEggColour, Item.Properties itemProperties) {
        return () -> new DeferredSpawnEggItem(entityType, primaryEggColour, secondaryEggColour, itemProperties);
    }

    public CreativeModeTab.Builder newCreativeTabBuilder() {
        return CreativeModeTab.builder();
    }
}