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

//    public RegistryKey<EntityType<?>> registerKey(String name) {
//        return RegistryKey.of(
//                RegistryKeys.ENTITY_TYPE,
//                Identifier.of(MOD_ID, name)
//        );
//    }
//
//    @SuppressWarnings("unchecked")
//    public <T extends Entity> EntityType<T> register(String name, RegistryKey<EntityType<?>> key, EntityType.Builder<?> builder) {
//        Identifier id = Identifier.of(MOD_ID, name);
//        //for (String alias : ALIAS_MOD_IDS) Registries.ENTITY_TYPE.addAlias(Identifier.of(alias, id.getPath()), id);
//        return (EntityType<T>)Registry.register(
//                Registries.ENTITY_TYPE,
//                id,
//                builder.build(key));
//    }

    public RegistrySupplier<EntityType<?>> register(String name, Supplier<EntityType<?>> factory /*RegistryKey<EntityType<?>> key, EntityType.Builder<?> builder*/) {
        RegistrySupplier<EntityType<?>> entity = REGISTRAR.register(Identifier.of(MOD_ID, name), factory);
        return entity;
    }
}
