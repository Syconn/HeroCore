package mod.syconn.hero.services;

import mod.syconn.hero.Constants;
import mod.syconn.hero.network.Channel;
import mod.syconn.hero.network.messages.IPayloadHandler;
import mod.syconn.hero.platform.services.INetwork;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.*;

public class ForgeNetwork implements INetwork {

    public static final SimpleChannel CHANNEL = ChannelBuilder.named(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "network")).networkProtocolVersion(1).simpleChannel();

    public <T extends IPayloadHandler> void sendToServer(T payload) {
        CHANNEL.send(payload, PacketDistributor.SERVER.noArg());
    }

    public <T extends IPayloadHandler> void sendToClient(T payload, ServerPlayer serverPlayer) {
        CHANNEL.send(payload, PacketDistributor.PLAYER.with(serverPlayer));
    }

    private static void register() {
        Channel.registerPlayToClient().forEach(payload -> CHANNEL.messageBuilder(payload.getClass(), NetworkDirection.PLAY_TO_CLIENT).codec(payload.codec()).consumerMainThread((msg, context) -> payload.handle(msg, context.getSender())).add());
        Channel.registerPlayToServer().forEach(payload -> CHANNEL.messageBuilder(payload.getClass(), NetworkDirection.PLAY_TO_SERVER).codec(payload.codec()).consumerMainThread((msg, context) -> payload.handle(msg, context.getSender())).add());
        Channel.registerBiDirectional().forEach(payload -> CHANNEL.messageBuilder(payload.getClass(), NetworkProtocol.PLAY).codec(payload.codec()).consumerMainThread((msg, context) -> payload.handle(msg, context.getSender())).add());
    }

    public static void setupNetwork(FMLCommonSetupEvent event) {
        event.enqueueWork(ForgeNetwork::register);
    }
}
