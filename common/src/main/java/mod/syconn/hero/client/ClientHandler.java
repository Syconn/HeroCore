package mod.syconn.hero.client;

import mod.syconn.hero.client.render.entity.MjolnirRenderer;
import mod.syconn.hero.network.Network;
import mod.syconn.hero.network.messages.MessageSay;
import mod.syconn.hero.registrar.EntityRegistrar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.BiConsumer;

public class ClientHandler {

    public static void registerRenderers(BiConsumer<EntityType<? extends Entity>, EntityRendererProvider> entityRenderers, BiConsumer<BlockEntityType<? extends BlockEntity>, BlockEntityRendererProvider> blockEntityRenderers) {
        entityRenderers.accept(EntityRegistrar.MJOLNIR_ENTITY_TYPE.get(), MjolnirRenderer::new);
    }

    public static void onClientPlayerTick(Player player) {
        if (Minecraft.getInstance().options.keyJump.isDown()) {
            Network.sendToServer(new MessageSay("HI"));
        }
    }
}
