package io.github.trashoflevillage.trashlib.blocks;

import io.github.trashoflevillage.trashlib.items.ItemInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class BlockInitializer {
    public final String MOD_ID;

    public BlockInitializer(String modId) {
        MOD_ID = modId;
    }

    public <B extends Block> B registerBlock(String name, Function<AbstractBlock.Settings, B> factory, AbstractBlock.Settings settings, boolean hasBlockItem) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name));
        B block = factory.apply(settings.registryKey(key));

        if (hasBlockItem)
            new ItemInitializer(MOD_ID).registerBlockItem(name, block);

        return Registry.register(Registries.BLOCK, key, block);
    }

    public <B extends Block> B registerBlock(String name, Function<AbstractBlock.Settings, B> factory, AbstractBlock.Settings settings) {
        return registerBlock(name, factory, settings, true);
    }
}
