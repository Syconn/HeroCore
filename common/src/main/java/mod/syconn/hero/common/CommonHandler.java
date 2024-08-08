package mod.syconn.hero.common;

import mod.syconn.hero.registrar.ItemRegistrar;
import mod.syconn.hero.util.CommonEvent;
import mod.syconn.hero.util.Helper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class CommonHandler {

    public static CommonEvent<LivingEntity, Float, Float, Boolean> fallDamageEvent(LivingEntity livingEntity, float distance, float damageMultiplier, boolean expectedResult) {
        if (livingEntity instanceof Player player) {
            boolean flag = Helper.isWearingIronManSuit(player) || Helper.isHolding(player, ItemRegistrar.MJOLNIR.get());
            return new CommonEvent<>(livingEntity, distance, damageMultiplier, flag);
        }
        return new CommonEvent<>(livingEntity, distance, damageMultiplier, expectedResult);
    }
}
