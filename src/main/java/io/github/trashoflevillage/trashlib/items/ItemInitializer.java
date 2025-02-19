package io.github.trashoflevillage.trashlib.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ItemInitializer {
    public final String CURRENT_MOD_ID;

    public ItemInitializer(String currentModId) {
        CURRENT_MOD_ID = currentModId;
    }

    public Item registerItem(String id, Function<Item.Settings, Item> factory) {
        return registerItem(id, factory, new Item.Settings());
    }


    public <I extends Item> I registerItem(String name, Function<Item.Settings, I> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CURRENT_MOD_ID, name));
        I item = factory.apply(settings.registryKey(key));

        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, blockItem);
        }

        return Registry.register(Registries.ITEM, key, item);
    }

    public BlockItem registerBlockItem(String name, Block block) {
        return registerItem(name, settings -> new BlockItem(block, settings), new Item.Settings().useBlockPrefixedTranslationKey());
    }
}
