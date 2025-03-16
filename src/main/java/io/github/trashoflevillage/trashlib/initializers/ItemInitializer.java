package io.github.trashoflevillage.trashlib.initializers;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ItemInitializer extends AbstractInitializer {
    private final ArrayList<ItemConvertible> registeredItems = new ArrayList();

    public ItemInitializer(String modId) {
        super(modId);
    }

    public Item register(String id, Function<Item.Settings, Item> factory) {
        return register(id, factory, new Item.Settings());
    }


    public <I extends Item> I register(String name, Function<Item.Settings, I> factory, Item.Settings settings) {
        Identifier id = Identifier.of(MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        I item = factory.apply(settings.registryKey(key));

        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, blockItem);
        }

        I output = Registry.register(Registries.ITEM, key, item);
        for (String alias : ALIAS_MOD_IDS) Registries.ITEM.addAlias(Identifier.of(alias, id.getPath()), id);
        registeredItems.add(output);
        return output;
    }

    public BlockItem registerBlockItem(String name, Block block) {
        return register(name, settings -> new BlockItem(block, settings), new Item.Settings().useBlockPrefixedTranslationKey());
    }

    public ArrayList<ItemConvertible> getRegisteredItems() {
        return registeredItems;
    }
}
