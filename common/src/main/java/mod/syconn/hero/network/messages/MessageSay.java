package mod.syconn.hero.network.messages;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Player;

public record MessageSay(String msg) {

    public static StreamCodec<RegistryFriendlyByteBuf, MessageSay> CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, MessageSay::msg, MessageSay::new);

    public static void handle(MessageSay msg, Player player) {
        player.sendSystemMessage(Component.literal(msg.msg));
    }
}
