package mod.syconn.hero.datagen;

import mod.syconn.hero.Constants;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class LangGen extends LanguageProvider {

    public LangGen(PackOutput output) {
        super(output, Constants.MOD_ID, "en_us");
    }

    protected void addTranslations() {
        CommonLang.generateItems(this::add);
        CommonLang.generateString(this::add);
    }
}
