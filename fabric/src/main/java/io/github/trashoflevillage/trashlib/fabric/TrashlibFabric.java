package io.github.trashoflevillage.trashlib.fabric;

import io.github.trashoflevillage.trashlib.util.AliasedID;
import net.fabricmc.api.ModInitializer;

import io.github.trashoflevillage.trashlib.Trashlib;
import net.minecraft.registry.Registries;

public final class TrashlibFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Trashlib.init();
        registerAliasedIDs();
    }

    private void registerAliasedIDs() {
        for (AliasedID alias : AliasedID.aliasedIds) {
            alias.getRegistry().addAlias(alias.getOldId(), alias.getNewId());
        }
    }
}
