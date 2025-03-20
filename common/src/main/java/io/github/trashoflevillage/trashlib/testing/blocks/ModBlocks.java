package io.github.trashoflevillage.trashlib.testing.blocks;

import dev.architectury.registry.registries.RegistrySupplier;
import io.github.trashoflevillage.trashlib.Trashlib;
import io.github.trashoflevillage.trashlib.initializers.BlockInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public class ModBlocks {
    private static final BlockInitializer initializer = new BlockInitializer(Trashlib.MOD_ID);

    public static final RegistrySupplier<Block> TEST_BLOCK =
            initializer.register("test_block", Block::new, AbstractBlock.Settings.create());

    public static void registerAll() {}
}
