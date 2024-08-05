package mod.syconn.hero.services;

import mod.syconn.hero.network.Channel;
import mod.syconn.hero.network.messages.IPayloadHandler;
import mod.syconn.hero.platform.services.INetwork;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;

public class FabricNetwork implements INetwork {

    public <T extends IPayloadHandler> void sendToServer(T payload) {
        ClientPlayNetworking.send(payload);
    }

    public <T extends IPayloadHandler> void sendToClient(T payload, ServerPlayer serverPlayer) {
        ServerPlayNetworking.send(serverPlayer, payload);
    }

    public static void registerClientPayloads() {
        Channel.registerPlayToClient().forEach(payload -> PayloadTypeRegistry.playC2S().register(payload.type(), payload.codec()));
        Channel.registerBiDirectional().forEach(payload -> PayloadTypeRegistry.playC2S().register(payload.type(), payload.codec()));
        Channel.registerPlayToClient().forEach(payload -> ClientPlayNetworking.registerGlobalReceiver(payload.type(), (msg, context) -> context.client().execute(() -> payload.handle(msg, context.player()))));
        Channel.registerBiDirectional().forEach(payload -> ClientPlayNetworking.registerGlobalReceiver(payload.type(), (msg, context) -> context.client().execute(() -> payload.handle(msg, context.player()))));
    }

    public static void registerServerPayloads() {
        Channel.registerPlayToServer().forEach(payload -> PayloadTypeRegistry.playS2C().register(payload.type(), payload.codec()));
        Channel.registerBiDirectional().forEach(payload -> PayloadTypeRegistry.playS2C().register(payload.type(), payload.codec()));
        Channel.registerPlayToClient().forEach(payload -> ServerPlayNetworking.registerGlobalReceiver(payload.type(), (msg, context) -> context.server().execute(() -> payload.handle(msg, context.player()))));
        Channel.registerBiDirectional().forEach(payload -> ServerPlayNetworking.registerGlobalReceiver(payload.type(), (msg, context) -> context.server().execute(() -> payload.handle(msg, context.player()))));

    }
}
