package mod.syconn.hero.network.messages;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Player;

public record MessageLaunch(boolean setFly) {

    public static StreamCodec<RegistryFriendlyByteBuf, MessageLaunch> CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, MessageLaunch::setFly, MessageLaunch::new);

    public static void handle(MessageLaunch msg, Player player) {
        if (msg.setFly()) {
            player.getAbilities().flying = true;
            player.onUpdateAbilities();
        } else {
            player.push(0, 1, 0);
        }
    }
}
