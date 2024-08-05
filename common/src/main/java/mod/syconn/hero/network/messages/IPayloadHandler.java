package mod.syconn.hero.network.messages;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;

public interface IPayloadHandler extends CustomPacketPayload {

    <B extends ByteBuf, T extends CustomPacketPayload> StreamCodec<B, T> codec();

    <T extends CustomPacketPayload> void handle(T payload, Player player);
}
