package mod.syconn.hero;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(Constants.MOD_ID)
public class HeroCore {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);

    public HeroCore(IEventBus eventBus) {
        ITEMS.register(eventBus);
        HeroMod.init();
    }
}