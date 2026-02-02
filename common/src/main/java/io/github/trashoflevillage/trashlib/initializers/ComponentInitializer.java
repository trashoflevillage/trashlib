package io.github.trashoflevillage.trashlib.initializers;

import com.mojang.serialization.Codec;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ComponentInitializer extends AbstractInitializer {
    private final Registrar<ComponentType<?>> REGISTRAR;
    public ComponentInitializer(String modId) {
        super(modId);
        REGISTRAR = ((RegistrarManager)MANAGER.get()).get(Registries.DATA_COMPONENT_TYPE);
    }

    @SuppressWarnings("unchecked")
    public <T> RegistrySupplier<ComponentType<T>> register(String name, Codec<T> codec) {
        return REGISTRAR.register(
                Identifier.of(MOD_ID, name), () -> (ComponentType<T>)ComponentType.builder().codec((Codec<Object>) codec).build()
        );
    }
}
