package io.github.trashoflevillage.trashlib;

import dev.architectury.platform.Platform;
import io.github.trashoflevillage.trashlib.initializers.BlockEntityInitializer;
import net.minecraft.block.entity.FurnaceBlockEntity;

import java.util.ArrayList;
import java.util.List;

public final class Trashlib {
    public static final String MOD_ID = "trashlib";
    private static final List<Runnable> CLIENT_RUNNABLES = new ArrayList<>();

    public static void init() {
    }

    public static void addClientRunnable(Runnable r) {
        CLIENT_RUNNABLES.add(r);
    }

    public static void initClient() {
        for (Runnable c : CLIENT_RUNNABLES) c.run();
    }
}