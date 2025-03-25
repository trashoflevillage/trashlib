package io.github.trashoflevillage.trashlib.initializers;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class EntityInitializer extends AbstractInitializer {
    private final Registrar<EntityType<?>> REGISTRAR = MANAGER.get().get(Registries.ENTITY_TYPE);

    public EntityInitializer(String modId) {
        super(modId);
    }

    public <E extends Entity> RegistrySupplier<EntityType<E>> register(String name, Supplier<EntityType<E>> factory) {
        RegistrySupplier<EntityType<E>> entity = this.REGISTRAR.register(Identifier.of(this.MOD_ID, name), factory);
        return entity;
    }
}
