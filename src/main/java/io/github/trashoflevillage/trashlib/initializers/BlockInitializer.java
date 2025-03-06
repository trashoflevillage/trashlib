package io.github.trashoflevillage.trashlib.initializers;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.function.Function;

public class BlockInitializer extends AbstractInitializer {
    private final ArrayList<ItemConvertible> registeredItems = new ArrayList<>();

    public BlockInitializer(String modId) {
        super(modId);
    }

    public <B extends Block> B register(String name, Function<AbstractBlock.Settings, B> factory, AbstractBlock.Settings settings, boolean hasBlockItem) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name));
        B block = factory.apply(settings.registryKey(key));

        if (hasBlockItem) {
            new ItemInitializer(MOD_ID).registerBlockItem(name, block);
            registeredItems.add(block);
        }

        return Registry.register(Registries.BLOCK, key, block);
    }

    public <B extends Block> B register(String name, Function<AbstractBlock.Settings, B> factory, AbstractBlock.Settings settings) {
        B b = register(name, factory, settings, true);
        return b;
    }

    public ArrayList<ItemConvertible> getRegisteredItems() {
        return registeredItems;
    }
}
