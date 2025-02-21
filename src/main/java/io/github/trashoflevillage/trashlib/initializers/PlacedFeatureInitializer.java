package io.github.trashoflevillage.trashlib.initializers;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;

public class PlacedFeatureInitializer extends AbstractInitializer {
    public PlacedFeatureInitializer(String modId) {
        super(modId);
    }

    public RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, name));
    }
}
