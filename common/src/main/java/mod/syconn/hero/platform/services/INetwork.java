package mod.syconn.hero.platform.services;

import mod.syconn.hero.network.messages.IPayloadHandler;
import net.minecraft.server.level.ServerPlayer;

public interface INetwork {

    <T extends IPayloadHandler> void sendToServer(T payload);
    <T extends IPayloadHandler> void sendToClient(T payload, ServerPlayer serverPlayer);
}
