package mod.syconn.hero;

import mod.syconn.hero.client.ClientHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class FabricClient implements ClientModInitializer {

    public void onInitializeClient() {
        ClientHandler.registerRenderers(EntityRendererRegistry::register, BlockEntityRenderers::register);
    }
}
