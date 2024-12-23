package mod.syconn.hero.services;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import mod.syconn.hero.network.Network;
import mod.syconn.hero.network.messages.Payload;
import mod.syconn.hero.platform.services.INetwork;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class FabricNetwork implements INetwork {

    public static Map<Class<?>, Network.PlayMessage<?>> directory;

    public void sendToServer(Object payload) {
        ClientPlayNetworking.send(encode(payload));
    }

    public void sendToClient(Object payload, ServerPlayer serverPlayer) {
        ServerPlayNetworking.send(serverPlayer, encode(payload));
    }

    public <T> void registerPlayS2C(Network.PlayMessage<T> message) {
        directory = createDirectory(Network.register);
        PayloadTypeRegistry.playS2C().register(message.type(), message.codec());
    }

    public <T> void registerPlayC2S(Network.PlayMessage<T> message) {
        directory = createDirectory(Network.register);
        PayloadTypeRegistry.playC2S().register(message.type(), message.codec());
    }

    public <T> void registerClientHandler(Network.PlayMessage<T> message) {
        ClientPlayNetworking.registerGlobalReceiver(message.type(), (payload, context) -> context.client().execute(() -> message.handler().accept(payload.msg(), context.player())));
    }

    public <T> void registerServerHandler(Network.PlayMessage<T> message) {
        ServerPlayNetworking.registerGlobalReceiver(message.type(), (payload, context) -> context.server().execute(() -> message.handler().accept(payload.msg(), context.player())));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private <T> Payload<T> encode(Object message) {
        Network.PlayMessage msg = directory.get(message.getClass());
        if(msg == null) throw new IllegalArgumentException("Unregistered message: " + message.getClass().getName());
        return msg.getPayload(message);
    }

    private static Map<Class<?>, Network.PlayMessage<?>> createDirectory(Collection<Network.PlayMessage<?>> m) {
        Object2ObjectMap<Class<?>, Network.PlayMessage<?>> map = new Object2ObjectArrayMap<>();
        m.forEach(msg -> map.put(msg.msgClass(), msg));
        return Collections.unmodifiableMap(map);
    }
}
