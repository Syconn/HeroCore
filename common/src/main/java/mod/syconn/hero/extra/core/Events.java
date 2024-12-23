package mod.syconn.hero.extra.core;

import net.minecraft.world.entity.LivingEntity;

public class Events {

    public record LivingEntityFallEvent(LivingEntity entity, float distance, float damageMultiplier, boolean cancel) {}
}
