package mod.syconn.hero.datagen;

import mod.syconn.hero.Constants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class DatapackDataGen extends FabricDynamicRegistryProvider {

    public DatapackDataGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void configure(HolderLookup.Provider registries, Entries entries) {
        CommonDatapack.addAll(entries::add);
    }

    public String getName() {
        return Constants.MOD_ID;
    }
}
