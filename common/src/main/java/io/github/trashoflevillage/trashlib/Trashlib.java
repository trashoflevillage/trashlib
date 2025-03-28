package io.github.trashoflevillage.trashlib;

import dev.architectury.platform.Platform;
import io.github.trashoflevillage.trashlib.testing.blocks.ModBlocks;
import io.github.trashoflevillage.trashlib.testing.items.ModItemGroups;
import io.github.trashoflevillage.trashlib.testing.items.ModItems;

public final class Trashlib {
    public static final String MOD_ID = "trashlib";

    public static void init() {
        initTesting();
    }

    private static void initTesting() {
        ModItems.registerAll();
        ModBlocks.registerAll();
        ModItemGroups.registerAll();
    }
}
