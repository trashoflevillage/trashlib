package io.github.trashoflevillage.trashlib.neoforge;

import dev.architectury.registry.registries.DeferredRegister;
import io.github.trashoflevillage.trashlib.util.AliasedID;
import net.neoforged.fml.common.Mod;

import io.github.trashoflevillage.trashlib.Trashlib;

@Mod(Trashlib.MOD_ID)
public final class TrashlibNeoForge {
    public TrashlibNeoForge() {
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
