package io.github.trashoflevillage.trashlib.worldgen.features.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.joml.Vector3d;

import java.util.function.Predicate;

public class CrystalSpikeFeature extends Feature<SimpleBlockFeatureConfig> {
    public CrystalSpikeFeature(Codec<SimpleBlockFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<SimpleBlockFeatureConfig> context) {
        Predicate<BlockState> predicate = Feature.notInBlockTagPredicate(BlockTags.FEATURES_CANNOT_REPLACE);
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        SimpleBlockFeatureConfig config = context.getConfig();
        Random rng = world.getRandom();

        if (world.getBlockState(origin).isAir()) return false;

        int size = rng.nextBetween(2, 4);
        Vector3d direction = new Vector3d(
                (rng.nextDouble() * 2) - 1,
                (rng.nextDouble() * 2) - 1,
                (rng.nextDouble() * 2) - 1
        );

        int iterationsPerSize = rng.nextBetween(3, 5);
        double currentX = origin.getX();
        double currentY = origin.getY();
        double currentZ = origin.getZ();
        double negX = origin.getX();
        double negY = origin.getY();
        double negZ = origin.getZ();
        for (int i = size; i > 0; i--) {
            for (int a = 0; a < iterationsPerSize; a++) {
                BlockPos currentPos = new BlockPos(
                        (int) Math.round(currentX), (int) Math.round(currentY), (int) Math.round(currentZ)
                );
                BlockPos negPos = new BlockPos(
                        (int) Math.round(negX), (int) Math.round(negY), (int) Math.round(negZ)
                );
                for (int x = -i; x <= i; x++) {
                    for (int y = -i; y <= i; y++) {
                        for (int z = -i; z <= i; z++) {
                            if ((!(x == -i || y == -i || z == -i || x == i || y == i || z == i)) || rng.nextBetween(0, 3) <= 2) {
                                if (world.isValidForSetBlock(currentPos.add(x, y, z)))
                                    setBlockStateIf(world, currentPos.add(x, y, z), config.toPlace().get(rng, currentPos), predicate);
                                if (world.isValidForSetBlock(negPos.add(x, y, z)))
                                    setBlockStateIf(world, negPos.add(x, y, z), config.toPlace().get(rng, currentPos), predicate);
                            }
                        }
                    }
                }
                currentX += direction.x * i;
                currentY += direction.y * i;
                currentZ += direction.z * i;
                negX += direction.x * -i;
                negY += direction.y * -i;
                negZ += direction.z * -i;
            }
        }
        return true;
    }
}
