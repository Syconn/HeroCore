package mod.syconn.hero;

import mod.syconn.hero.client.ClientHandler;
import mod.syconn.hero.services.FabricNetwork;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class FabricClient implements ClientModInitializer {

    public void onInitializeClient() {
        ClientHandler.registerRenderers(EntityRendererRegistry::register, BlockEntityRenderers::register);
        ClientTickEvents.END_CLIENT_TICK.register(client -> ClientHandler.onClientPlayerTick(client.player));
        FabricNetwork.registerClientPayloads();
    }
}
