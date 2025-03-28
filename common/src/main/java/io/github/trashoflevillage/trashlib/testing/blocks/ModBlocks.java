package io.github.trashoflevillage.trashlib.testing.blocks;

import dev.architectury.registry.registries.RegistrySupplier;
import io.github.trashoflevillage.trashlib.Trashlib;
import io.github.trashoflevillage.trashlib.initializers.BlockInitializer;
import io.github.trashoflevillage.trashlib.testing.items.ModItemGroups;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ModBlocks {
    private static final BlockInitializer INITIALIZER = new BlockInitializer(Trashlib.MOD_ID);

    public static final RegistrySupplier<Block> TEST_BLOCK =
            INITIALIZER.register(
                    "test_block",
                    Block::new,
                    AbstractBlock.Settings.create(),
                    new Item.Settings().arch$tab(ModItemGroups.TEST_GROUP)
            );

    public static void registerAll() {
        registerTransparentBlcoks();
    }

    private static void registerTransparentBlcoks() {
        INITIALIZER.addTransparentBlocks(TEST_BLOCK);
    }
}
