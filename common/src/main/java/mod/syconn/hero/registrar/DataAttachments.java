package mod.syconn.hero.registrar;

import mod.syconn.hero.extra.data.attachment.IAttachmentType;
import mod.syconn.hero.extra.platform.Services;

import java.util.function.Supplier;

public class DataAttachments {

    public static void init() {}

    private static <T extends IAttachmentType<T>> String register(String id, Supplier<T> type) {
        return Services.ATTACHED_DATA.registerType(id, type);
    }
}
