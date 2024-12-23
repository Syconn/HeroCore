package mod.syconn.hero.capabilities;

import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExampleCapability implements ICapabilitySerializable<CompoundTag> {

//    public static Capability<SpaceSuit> SPACE_SUIT = CapabilityManager.get(new CapabilityToken<>() {});
//    private SpaceSuit spaceSuit = null;
//    private final LazyOptional<SpaceSuit> holder = LazyOptional.of(this::createSpaceSuit);

//    private SpaceSuit createSpaceSuit() {
//        if (this.spaceSuit == null) this.spaceSuit = new SpaceSuit();
//        return this.spaceSuit;
//    }

    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
//        if (cap == SPACE_SUIT) return this.holder.cast();
        return LazyOptional.empty();
    }

    public CompoundTag serializeNBT(HolderLookup.Provider registryAccess) {
//        return createSpaceSuit().serializeNBT(registryAccess);
        return null;
    }

    public void deserializeNBT(HolderLookup.Provider registryAccess, CompoundTag nbt) {
//        createSpaceSuit().deserializeNBT(registryAccess, nbt);
    }
}