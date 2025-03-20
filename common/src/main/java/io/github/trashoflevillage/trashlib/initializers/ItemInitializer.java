package io.github.trashoflevillage.trashlib.initializers;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Supplier;

public class ItemInitializer extends AbstractInitializer {
    private final ArrayList<ItemConvertible> REGISTERED_ITEMS = new ArrayList();
    private final Registrar<Item> REGISTRAR = MANAGER.get().get(Registries.ITEM);

    public ItemInitializer(String modId) {
        super(modId);
    }

    public RegistrySupplier<Item> register(String id, Function<Item.Settings, Item> factory) {
        return register(id, factory, new Item.Settings());
    }

    public RegistrySupplier<Item> register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        RegistrySupplier<Item> item = REGISTRAR.register(id, () -> factory.apply(settings.registryKey(key)));
        return item;
    }

    public RegistrySupplier<Item> registerBlockItem(String name, RegistrySupplier<Block> block) {
        return register(name, (s) -> new BlockItem(block.get(), s), new Item.Settings().useBlockPrefixedTranslationKey());
    }

    public ArrayList<ItemConvertible> getRegisteredItems() {
        return REGISTERED_ITEMS;
    }
}
