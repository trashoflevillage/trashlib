package io.github.trashoflevillage.trashlib.initializers;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
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
    private final Registrar<Block> REGISTRAR = MANAGER.get().get(Registries.BLOCK);

    public BlockInitializer(String modId) {
        super(modId);
    }

    public RegistrySupplier<Block> register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings, boolean hasBlockItem) {
        Identifier id = Identifier.of(MOD_ID, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);
        RegistrySupplier<Block> block = REGISTRAR.register(id, () -> factory.apply(settings.registryKey(key)));

        if (hasBlockItem) {
            ItemInitializer itemInitializer = new ItemInitializer(MOD_ID);
            for (String alias : ALIAS_MOD_IDS) itemInitializer.addModIdAlias(alias);
            //itemInitializer.registerBlockItem(name, block);
        }

        //for (String alias : ALIAS_MOD_IDS) Registries.BLOCK.addAlias(Identifier.of(alias, id.getPath()), id);
        return block;
    }

    public RegistrySupplier<Block> register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return register(name, factory, settings, true);
    }

    public ArrayList<ItemConvertible> getRegisteredItems() {
        return registeredItems;
    }
}
