package io.github.trashoflevillage.trashlib.initializers;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class FeatureInitializer extends AbstractInitializer {
    public FeatureInitializer(String modId) {
        super(modId);
    }

    public <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        Identifier id = Identifier.of(MOD_ID, name);
        for (String alias : ALIAS_MOD_IDS) Registries.FEATURE.addAlias(Identifier.of(alias, id.getPath()), id);
        return Registry.register(Registries.FEATURE, id, feature);
    }
}
