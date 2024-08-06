package mod.syconn.hero.util;

import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class Helper {

    public static boolean isWearingIronManSuit(Player player) {
        NonNullList<ItemStack> inv = player.getInventory().armor;
        System.out.println(inv);
        return true;
    }
}
