package mod.syconn.hero.registrar;

import mod.syconn.hero.platform.Services;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class EntityRegistrar {

    private static <T extends Mob> Supplier<EntityType<T>> registerEntity(String name, EntityType.EntityFactory<T> entity, float width, float height, MobCategory mobCategory) {
        return Services.REGISTRAR.registerEntity(name, () -> EntityType.Builder.of(entity,mobCategory).sized(width, height).build(name));
    }
}
