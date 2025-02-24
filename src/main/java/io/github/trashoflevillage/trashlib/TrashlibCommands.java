package io.github.trashoflevillage.trashlib;

import io.github.trashoflevillage.trashlib.util.GenHelper;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Blocks;
import net.minecraft.server.command.CommandManager;
import org.apache.commons.lang3.SystemProperties;

///
/// All trashlib commands are only available in a dev environment.
/// Most of them are for internally testing trashlib features, and will not be useful to you.
///
class TrashlibCommands {
    public static void registerAll() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("sphere")
                    .executes(context -> {
                        GenHelper.sphere(
                                context.getSource().getWorld(),
                                context.getSource().getPlayer().getBlockPos(),
                                (world, pos) -> Blocks.MOSSY_COBBLESTONE.getDefaultState(),
                                20
                        );
                        return 1;
                    }));
        });

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("hollow_sphere")
                    .executes(context -> {
                        GenHelper.hollowSphere(
                                context.getSource().getWorld(),
                                context.getSource().getPlayer().getBlockPos(),
                                (world, pos) -> Blocks.MOSSY_COBBLESTONE.getDefaultState(),
                                20
                        );
                        return 1;
                    }));
        });
    }
}
