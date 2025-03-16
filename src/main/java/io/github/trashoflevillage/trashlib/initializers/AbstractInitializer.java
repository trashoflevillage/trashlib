package io.github.trashoflevillage.trashlib.initializers;

import java.util.ArrayList;

public abstract class AbstractInitializer {
    public final String MOD_ID;
    protected final ArrayList<String> ALIAS_MOD_IDS = new ArrayList<>();

    public AbstractInitializer(String modId) {
        MOD_ID = modId;
    }

    @SuppressWarnings("unchecked")
    public <T extends AbstractInitializer> T addModIdAlias(String modIdAlias) {
        ALIAS_MOD_IDS.add(modIdAlias);
        return (T)this;
    }
}
