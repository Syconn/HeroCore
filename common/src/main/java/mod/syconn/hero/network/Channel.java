package mod.syconn.hero.network;

import mod.syconn.hero.network.messages.IPayloadHandler;
import mod.syconn.hero.platform.Services;
import mod.syconn.hero.platform.services.INetwork;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.List;

public class Channel {

    private static final INetwork register = Services.NETWORK;

    public static List<IPayloadHandler> registerPlayToClient() {
        List<IPayloadHandler> payloads = new ArrayList<>();
        return payloads;
    }

    public static List<IPayloadHandler> registerPlayToServer() {
        List<IPayloadHandler> payloads = new ArrayList<>();
        return payloads;
    }

    public static List<IPayloadHandler> registerBiDirectional() {
        List<IPayloadHandler> payloads = new ArrayList<>();
        return payloads;
    }

    public static <MSG extends IPayloadHandler> void sendToServer(MSG message) {
        register.sendToServer(message);
    }

    public static <MSG extends IPayloadHandler> void sendToPlayer(MSG message, ServerPlayer serverPlayer) {
        register.sendToClient(message, serverPlayer);
    }
}
