package io.github.trashoflevillage.trashlib.neoforge;

import net.neoforged.fml.common.Mod;

import io.github.trashoflevillage.trashlib.Trashlib;

@Mod(Trashlib.MOD_ID)
public final class TrashlibNeoForge {
    public TrashlibNeoForge() {
        // Run our common setup.
        Trashlib.init();
    }
}
