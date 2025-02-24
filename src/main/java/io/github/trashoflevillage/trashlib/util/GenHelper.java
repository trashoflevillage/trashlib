package io.github.trashoflevillage.trashlib.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GenHelper {
    public static void sphere(World world, BlockPos origin, BlockStateProvider outside, BlockStateProvider inside, int radius) {
        BlockPos mutablePos = origin.mutableCopy();
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    if (x * x + y * y + z * z <= radius * radius) {
                        BlockPos pos = mutablePos.add(x, y, z);
                        BlockState state = outside.getBlockState(world, pos);
                        if (state != null) world.setBlockState(pos, state);
                    }
                }
            }
        }
        for (int x = -radius - 1; x <= radius - 1; x++) {
            for (int y = -radius - 1; y <= radius - 1; y++) {
                for (int z = -radius - 1; z <= radius - 1; z++) {
                    if (x * x + y * y + z * z <= (radius - 1) * (radius - 1)) {
                        BlockPos pos = mutablePos.add(x, y, z);
                        BlockState state = inside.getBlockState(world, pos);
                        if (state != null) world.setBlockState(pos, state);
                    }
                }
            }
        }
    }

    public static void sphere(World world, BlockPos origin, BlockStateProvider stateProvider, int radius) {
        sphere(world, origin, stateProvider, stateProvider, radius);
    }

    public static void hollowSphere(World world, BlockPos origin, BlockStateProvider stateProvider, int radius) {
        sphere(world, origin, stateProvider, (w, p) -> {
            return Blocks.AIR.getDefaultState();
        }, radius);
    }

    public interface BlockStateProvider {
        BlockState getBlockState(World world, BlockPos pos);
    }
}
