package io.github.trashoflevillage.trashlib.util;

import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class AliasedID {
    public static final ArrayList<AliasedID> aliasedIds = new ArrayList<>();

    private final DefaultedRegistry<?> registry;
    private final Identifier oldId;
    private final Identifier newId;

    private AliasedID(DefaultedRegistry<?> registry, Identifier oldId, Identifier newId) {
        this.registry = registry;
        this.oldId = oldId;
        this.newId = newId;
    }

    public static void addAlias(DefaultedRegistry<?> registry, Identifier oldId, Identifier newId) {
        aliasedIds.add(new AliasedID(registry, oldId, newId));
    }

    public DefaultedRegistry<?> getRegistry() {
        return registry;
    }

    public Identifier getNewId() {
        return newId;
    }

    public Identifier getOldId() {
        return oldId;
    }
}
