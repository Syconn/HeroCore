package mod.syconn.hero.util;

import mod.syconn.hero.registrar.ItemRegistrar;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class Helper {

    public static boolean isWearingIronManSuit(Player player) {
        NonNullList<ItemStack> inv = player.getInventory().armor;
        return inv.get(0).is(ItemRegistrar.MARK_42_BOOTS.get()) && inv.get(1).is(ItemRegistrar.MARK_42_LEGGINGS.get()) && inv.get(2).is(ItemRegistrar.MARK_42_CHESTPLATE.get()) && inv.get(3).is(ItemRegistrar.MARK_42_HELMET.get());
    }
}
