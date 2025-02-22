package io.github.trashoflevillage.trashlib.worldgen.features;

import io.github.trashoflevillage.trashlib.TrashLib;
import io.github.trashoflevillage.trashlib.initializers.FeatureInitializer;
import io.github.trashoflevillage.trashlib.worldgen.features.custom.CrystalSpikeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;

public class TrashlibFeatures {
    public static final FeatureInitializer initializer = new FeatureInitializer(TrashLib.MOD_ID);

    public static final Feature<SimpleBlockFeatureConfig> CRYSTAL_SPIKE = initializer.register(
            "crystal_spike", new CrystalSpikeFeature(SimpleBlockFeatureConfig.CODEC)
    );

    public static void register() {}
}
