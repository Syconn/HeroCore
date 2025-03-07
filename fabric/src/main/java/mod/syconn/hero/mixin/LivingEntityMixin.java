package mod.syconn.hero.mixin;

import mod.syconn.hero.events.LivingEntityEvents;
import mod.syconn.hero.util.CommonEvent;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(at = @At(value = "HEAD"), method = "calculateFallDamage", cancellable = true)
    private void onFall(float fallDistance, float damageMultiplier, CallbackInfoReturnable<Integer> cir) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        CommonEvent<LivingEntity, Float, Float, Boolean> result = LivingEntityEvents.FALL_EVENT.invoker().fall(livingEntity, fallDistance, damageMultiplier, false);
        if (livingEntity.getType().is(EntityTypeTags.FALL_DAMAGE_IMMUNE) || result.getResult()) cir.setReturnValue(0);
        else {
            float f = (float)livingEntity.getAttributeValue(Attributes.SAFE_FALL_DISTANCE);
            float g = result.getP2() - f;
            cir.setReturnValue(Mth.ceil((double)(g * result.getP3()) * livingEntity.getAttributeValue(Attributes.FALL_DAMAGE_MULTIPLIER)));
        }
    }
}
