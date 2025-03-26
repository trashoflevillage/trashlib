package io.github.trashoflevillage.trashlib.initializers;

import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class TagInitializer<T> extends AbstractInitializer {
    private final RegistryKey<? extends Registry<T>> registryRef;

    public TagInitializer(String modId, RegistryKey<? extends Registry<T>> registryRef) {
        super(modId);
        this.registryRef = registryRef;
    }

    public TagKey<T> register(String id) {
        return TagKey.of(registryRef, Identifier.of(MOD_ID, id));
    }
}
