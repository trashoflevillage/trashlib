package io.github.trashoflevillage.trashlib.neoforge;

import net.neoforged.fml.common.Mod;

import io.github.trashoflevillage.trashlib.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
