package mod.syconn.hero.events;

import mod.syconn.hero.extra.core.Events;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.entity.LivingEntity;

public class EntityEvents {

    public static Event<LivingEntityFallCallback> FALL_EVENT = EventFactory.createArrayBacked(LivingEntityFallCallback.class, (listeners) ->
            (livingEntity, distance, damageMultiplier, cancelled) -> {
                for (LivingEntityFallCallback listener : listeners) return listener.fall(livingEntity, distance, damageMultiplier, cancelled);
                return new Events.LivingEntityFallEvent(livingEntity, distance, damageMultiplier, cancelled);
    });

    public interface LivingEntityFallCallback {
        Events.LivingEntityFallEvent fall(LivingEntity livingEntity, float distance, float damageMultiplier, boolean cancelled);
    }
}
