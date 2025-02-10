package io.github.trashoflevillage.trashlib.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class BlockInitializer {
    public static String CURRENT_MOD_ID;

    public static void setCurrentModId(String newId) {
        CURRENT_MOD_ID = newId;
    }

    public static <B extends Block> B registerBlock(String name, Function<AbstractBlock.Settings, B> factory, AbstractBlock.Settings settings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CURRENT_MOD_ID, name));
        B block = factory.apply(settings.registryKey(key));

        return Registry.register(Registries.BLOCK, key, block);
    }
}
