package mod.syconn.hero.datagen;

import mod.syconn.hero.registrar.DamageSources;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DeathMessageType;

import java.util.function.BiConsumer;

public class CommonDatapack {

    public static RegistrySetBuilder COMMON = new RegistrySetBuilder().add(Registries.DAMAGE_TYPE, bootstrap ->
            bootstrap.register(DamageSources.MJOLNIR, new DamageType("mjolnir", DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0.1f, DamageEffects.HURT, DeathMessageType.DEFAULT)));
}
