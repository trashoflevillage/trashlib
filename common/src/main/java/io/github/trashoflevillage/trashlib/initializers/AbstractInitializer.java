package io.github.trashoflevillage.trashlib.initializers;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.RegistrarManager;

import java.util.ArrayList;
import java.util.function.Supplier;

public abstract class AbstractInitializer {
    public final Supplier<RegistrarManager> MANAGER;
    public final String MOD_ID;
    protected final ArrayList<String> ALIAS_MOD_IDS = new ArrayList<>();

    public AbstractInitializer(String modId) {
        MOD_ID = modId;
        MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));
    }

    @SuppressWarnings("unchecked")
    public <T extends AbstractInitializer> T addModIdAlias(String modIdAlias) {
        ALIAS_MOD_IDS.add(modIdAlias);
        return (T)this;
    }
}
