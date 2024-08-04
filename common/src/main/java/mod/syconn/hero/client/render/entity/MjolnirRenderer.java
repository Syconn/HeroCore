package mod.syconn.hero.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mod.syconn.hero.entity.ThrownMjolnir;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemDisplayContext;

public class MjolnirRenderer extends EntityRenderer<ThrownMjolnir> {

    private final ItemRenderer itemRenderer;

    public MjolnirRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        itemRenderer = pContext.getItemRenderer();
    }

    public void render(ThrownMjolnir pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight) {
        if (pEntity.getWeaponItem() != null) {
            pPoseStack.pushPose();
            pPoseStack.translate(0, 0.5f, 0);
            pPoseStack.mulPose(Axis.XP.rotationDegrees(180f));
//            pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTick, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
//            pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTick, pEntity.xRotO, pEntity.getXRot()) + 90.0F));
            itemRenderer.renderStatic(pEntity.getWeaponItem(), ItemDisplayContext.GROUND, pPackedLight, OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pEntity.level(), pEntity.getId());
            pPoseStack.popPose();
        }
    }

    public ResourceLocation getTextureLocation(ThrownMjolnir pEntity) {
        return InventoryMenu.BLOCK_ATLAS;
    }
}
