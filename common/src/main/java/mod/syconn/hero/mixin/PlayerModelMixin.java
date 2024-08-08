package mod.syconn.hero.mixin;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerModel.class)
public class PlayerModelMixin<T extends LivingEntity> {

    @SuppressWarnings("all")
    @Inject(at = @At("TAIL"), method = "setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V")
    private void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch, CallbackInfo info) {
        if (!(pEntity instanceof Player player))
            return;

//        PlayerModel<T> model = (PlayerModel<T>) (Object) this;
//        if (!Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
//            if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ItemRegistrar.MJOLNIR.get())) {
//                model.leftArm.zRot = (float) Math.toRadians(90.0F);
//            }
//        }
    }

    private void copyArmAngles(PlayerModel<T> model){
        copyModelAngles(model.rightArm, model.rightSleeve);
        copyModelAngles(model.leftArm, model.leftSleeve);
    }

    private static void copyModelAngles(ModelPart source, ModelPart target) {
        target.xRot = source.xRot;
        target.yRot = source.yRot;
        target.zRot = source.zRot;
    }
}
