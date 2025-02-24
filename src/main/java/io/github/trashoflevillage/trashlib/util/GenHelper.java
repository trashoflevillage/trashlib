package io.github.trashoflevillage.trashlib.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Interface;

public class GenHelper {
    public static void sphere(World world, BlockPos origin, TBlockStateProvider outside,  TBlockStateProvider inside, int radius) {
        BlockPos mutablePos = origin.mutableCopy();
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    if (x * x + y * y + z * z <= radius * radius) {
                        world.setBlockState(mutablePos.add(x, y, z), outside.getBlockState());
                    }
                }
            }
        }
        for (int x = -radius - 1; x <= radius - 1; x++) {
            for (int y = -radius - 1; y <= radius - 1; y++) {
                for (int z = -radius - 1; z <= radius - 1; z++) {
                    if (x * x + y * y + z * z <= (radius - 1) * (radius - 1)) {
                        world.setBlockState(mutablePos.add(x, y, z), inside.getBlockState());
                    }
                }
            }
        }
    }

    public static void sphere(World world, BlockPos origin,  TBlockStateProvider stateProvider, int radius) {
        sphere(world, origin, stateProvider, stateProvider, radius);
    }

    public static void hollowSphere(World world, BlockPos origin, TBlockStateProvider stateProvider, int radius) {
        sphere(world, origin, stateProvider, Blocks.AIR::getDefaultState, radius);
    }

    @FunctionalInterface
    public interface TBlockStateProvider {
        BlockState getBlockState();
    }
}
