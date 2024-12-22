package mod.syconn.hero.datagen;

import mod.syconn.hero.registrar.TagRegistrar;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

@OnlyIn(Dist.CLIENT)

public class EquipmentGen implements DataProvider {

    private final PackOutput.PathProvider pathProvider;

    public EquipmentGen(PackOutput output) {
        this.pathProvider = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    private static void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        output.accept(TagRegistrar.MARK_42, onlyHumanoid("mark_42"));
    }

    private static EquipmentClientInfo onlyHumanoid(String name) {
        return EquipmentClientInfo.builder().addHumanoidLayers(ResourceLocation.withDefaultNamespace(name)).build();
    }

    private static EquipmentClientInfo humanoidAndHorse(String name) {
        return EquipmentClientInfo.builder()
                .addHumanoidLayers(ResourceLocation.withDefaultNamespace(name))
                .addLayers(
                        EquipmentClientInfo.LayerType.HORSE_BODY, EquipmentClientInfo.Layer.leatherDyeable(ResourceLocation.withDefaultNamespace(name), false)
                )
                .build();
    }

    @Override
    public CompletableFuture<?> run(CachedOutput p_387304_) {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> map = new HashMap<>();
        bootstrap((p_386976_, p_388942_) -> {
            if (map.putIfAbsent(p_386976_, p_388942_) != null) {
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + p_386976_);
            }
        });
        return DataProvider.saveAll(p_387304_, EquipmentClientInfo.CODEC, this.pathProvider::json, map);
    }

    @Override
    public String getName() {
        return "Equipment Asset Definitions";
    }
}
