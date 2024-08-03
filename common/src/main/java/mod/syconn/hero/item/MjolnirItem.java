package mod.syconn.hero.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class MjolnirItem extends Item implements IUseAnim {

    public MjolnirItem(Properties pProperties) {
        super(pProperties.component(DataComponents.TOOL, Tiers.IRON.createToolProperties(BlockTags.MINEABLE_WITH_PICKAXE)).attributes(SwordItem.createAttributes(Tiers.NETHERITE, 3, -2.4F)));
    }

    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            int i = this.getUseDuration(pStack, pEntityLiving) - pTimeLeft;
            if (i >= 10) {
                float f = 3; // SPIN LAUNCH OR NOT
                if (!pLevel.isClientSide) {
                    if (f == 0.0F) {
                        ThrownTrident throwntrident = new ThrownTrident(pLevel, player, pStack);
                        throwntrident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
                        if (player.hasInfiniteMaterials()) throwntrident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        pLevel.addFreshEntity(throwntrident);
                        pLevel.playSound(null, throwntrident, SoundEvents.TRIDENT_THROW.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                        if (!player.hasInfiniteMaterials()) player.getInventory().removeItem(pStack);
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(this)); // TRIDENT FLING THING
                if (f > 0.0F) {
                    float f7 = player.getYRot();
                    float f1 = player.getXRot();
                    float f2 = -Mth.sin(f7 * (float) (Math.PI / 180.0)) * Mth.cos(f1 * (float) (Math.PI / 180.0));
                    float f3 = -Mth.sin(f1 * (float) (Math.PI / 180.0));
                    float f4 = Mth.cos(f7 * (float) (Math.PI / 180.0)) * Mth.cos(f1 * (float) (Math.PI / 180.0));
                    float f5 = Mth.sqrt(f2 * f2 + f3 * f3 + f4 * f4);
                    f2 *= f / f5;
                    f3 *= f / f5;
                    f4 *= f / f5;
                    player.push(f2, f3, f4);
                    player.startAutoSpinAttack(20, 8.0F, pStack);
                    if (player.onGround()) player.move(MoverType.SELF, new Vec3(0.0, 1.1999999F, 0.0));

                    pLevel.playSound(null, player, SoundEvents.TRIDENT_THROW.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                }
            }
        }
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pPlayer.startUsingItem(pHand);
        return InteractionResultHolder.consume(itemstack);
    }

    public UseAnim getAnimation() {
        return UseAnim.THROW_HAMMER;
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        return true;
    }
}
