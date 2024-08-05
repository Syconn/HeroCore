package mod.syconn.hero.services;

import mod.syconn.hero.network.Channel;
import mod.syconn.hero.network.messages.IPayloadHandler;
import mod.syconn.hero.platform.services.INetwork;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class NeoNetwork implements INetwork {

    public <T extends IPayloadHandler> void sendToServer(T payload) {
        PacketDistributor.sendToServer(payload);
    }

    public <T extends IPayloadHandler> void sendToClient(T payload, ServerPlayer serverPlayer) {
        PacketDistributor.sendToPlayer(serverPlayer, payload);
    }

    public static void onRegisterPayloadHandler(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        Channel.registerPlayToClient().forEach(payload -> registrar.playToClient(payload.type(), payload.codec(), (msg, context) -> context.enqueueWork(() -> payload.handle(msg, context.player()))));
        Channel.registerPlayToServer().forEach(payload -> registrar.playToServer(payload.type(), payload.codec(), (msg, context) -> context.enqueueWork(() -> payload.handle(msg, context.player()))));
        Channel.registerBiDirectional().forEach(payload -> registrar.playBidirectional(payload.type(), payload.codec(), (msg, context) -> context.enqueueWork(() -> payload.handle(msg, context.player()))));
    }
}
