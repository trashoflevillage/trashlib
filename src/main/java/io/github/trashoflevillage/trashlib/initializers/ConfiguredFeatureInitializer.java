package io.github.trashoflevillage.trashlib.initializers;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class ConfiguredFeatureInitializer extends AbstractInitializer {
    public ConfiguredFeatureInitializer(String modId) {
        super(modId);
    }

    public RegistryKey<ConfiguredFeature<?, ?>> register(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MOD_ID, name));
    }
}
