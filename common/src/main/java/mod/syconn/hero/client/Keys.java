package mod.syconn.hero.client;

import mod.syconn.hero.Constants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;
import java.util.function.Consumer;

public class Keys {
    
    public static final KeyMapping ABILITY1 = new KeyMapping(keyId("use.ability1"), GLFW.GLFW_KEY_X, modCategory());
    public static final KeyMapping ABILITY2 = new KeyMapping(keyId("use.ability2"), GLFW.GLFW_KEY_C, modCategory());
    public static final KeyMapping ABILITY3 = new KeyMapping(keyId("use.ability3"), GLFW.GLFW_KEY_V, modCategory());
    
    public static void registerMapping(Consumer<KeyMapping> mappings) {
        mappings.accept(ABILITY1);
        mappings.accept(ABILITY2);
        mappings.accept(ABILITY3);
    }
    
    private static String keyId(String id) {
        return "key." + Constants.MOD_ID + "." + id;
    }

    private static String modCategory() {
        return "key.categories." + Constants.MOD_ID;
    }
}
