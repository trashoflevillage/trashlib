package io.github.trashoflevillage.trashlib.initializers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class EntityInitializer extends AbstractInitializer {
    public EntityInitializer(String modId) {
        super(modId);
    }

    public RegistryKey<EntityType<?>> registerKey(String name) {
        return RegistryKey.of(
                RegistryKeys.ENTITY_TYPE,
                Identifier.of(MOD_ID, name)
        );
    }

    @SuppressWarnings("unchecked")
    public <T extends Entity> EntityType<T> register(String name, RegistryKey<EntityType<?>> key, EntityType.Builder<?> builder) {
        return (EntityType<T>)Registry.register(
                Registries.ENTITY_TYPE,
                Identifier.of(MOD_ID, name),
                builder.build(key));
    }
}
