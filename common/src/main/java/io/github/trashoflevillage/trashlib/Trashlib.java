package io.github.trashoflevillage.trashlib;

import io.github.trashoflevillage.trashlib.testing.blocks.ModBlocks;
import io.github.trashoflevillage.trashlib.testing.items.ModItems;

public final class Trashlib {
    public static final String MOD_ID = "trashlib";

    public static void init() {
        ModItems.registerAll();
        ModBlocks.registerAll();
    }
}
