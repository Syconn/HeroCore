package mod.syconn.hero.registrar;

import mod.syconn.hero.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;

public class DamageSources {

    public static final ResourceKey<DamageType> MJOLNIR = ResourceKey.create(Registries.DAMAGE_TYPE, Constants.loc("mjolnir"));

    public static DamageSource mjolnir(Entity causer) {
        return new DamageSource(causer.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(MJOLNIR), causer);
    }
}
