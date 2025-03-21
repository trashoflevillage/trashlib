package io.github.trashoflevillage.trashlib.neoforge;

import io.github.trashoflevillage.trashlib.util.AliasedID;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

import io.github.trashoflevillage.trashlib.Trashlib;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

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
