package mod.syconn.hero.network;

import mod.syconn.hero.Constants;
import mod.syconn.hero.network.messages.MessageLaunch;
import mod.syconn.hero.network.messages.Payload;
import mod.syconn.hero.platform.Services;
import mod.syconn.hero.platform.services.INetwork;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class Network {

    private static final INetwork network = Services.NETWORK;
    public static final ArrayList<PlayMessage<?>> register = new ArrayList<>();

    public static void registerMessages() {
        register.add(PlayMessage.of("say", MessageLaunch.class, MessageLaunch.CODEC, MessageLaunch::handle, PacketFlow.SERVERBOUND));
    }

    public static void sendToServer(Object message) {
        network.sendToServer(message);
    }

    public static void sendToPlayer(Object message, ServerPlayer serverPlayer) {
        network.sendToClient(message, serverPlayer);
    }

    public static void C2SPayloads() {
        register.stream().filter(PlayMessage::clientBound).forEach(network::registerClientHandler);
    }

    public static void S2CPayloads() {
        register.stream().filter(PlayMessage::clientBound).forEach(network::registerPlayS2C);
        register.stream().filter(PlayMessage::serverBound).forEach(network::registerPlayC2S);
        register.stream().filter(PlayMessage::serverBound).forEach(network::registerServerHandler);
    }

    public record PlayMessage<T> (CustomPacketPayload.Type<Payload<T>> type, Class<T> msgClass, StreamCodec<RegistryFriendlyByteBuf, Payload<T>> codec, StreamCodec<RegistryFriendlyByteBuf, T> forgeCodec, BiConsumer<T, Player> handler, PacketFlow flow) {

        public static <T> PlayMessage<T> of(String id, Class<T> msgClass, StreamCodec<RegistryFriendlyByteBuf, T> forgeCodec, BiConsumer<T, Player> handler, PacketFlow flow) {
            CustomPacketPayload.Type<Payload<T>> payloadType = new CustomPacketPayload.Type<>(Constants.withId(id));
            return new PlayMessage<>(payloadType, msgClass, Payload.codec(payloadType, forgeCodec), forgeCodec, handler, flow);
        }

        public Payload<T> getPayload(T msg) {
            return new Payload<>(this.type, msg);
        }

        public boolean clientBound() { return this.flow == PacketFlow.CLIENTBOUND; }
        public boolean serverBound() { return this.flow == PacketFlow.SERVERBOUND; }
    }
}
