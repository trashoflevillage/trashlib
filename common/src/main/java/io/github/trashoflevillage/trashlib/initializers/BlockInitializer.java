package io.github.trashoflevillage.trashlib.initializers;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.trashoflevillage.trashlib.util.AliasedID;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class BlockInitializer extends AbstractInitializer {
    private static final HashMap<RegistrySupplier<Block>, BlockRenderLayer> TRANSPARENT = new HashMap<>();
    private static final HashMap<BlockColorProvider, RegistrySupplier<Block>[]> COLOR_PROVIDERS = new HashMap<>();

    private final ArrayList<RegistrySupplier<Item>> REGISTERED_ITEMS = new ArrayList<>();
    private final Registrar<Block> REGISTRAR = MANAGER.get().get(Registries.BLOCK);

    public BlockInitializer(String modId) {
        super(modId);
    }

    ///
    /// Registers a block.
    /// Leave the fourth argument empty to use default block item settings.
    /// Set the fourth argument to null for no block item.
    ///
    public RegistrySupplier<Block> register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings, Item.Settings itemSettings) {
        Identifier id = Identifier.of(MOD_ID, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);
        RegistrySupplier<Block> block = REGISTRAR.register(id, () -> factory.apply(settings.registryKey(key)));

        if (itemSettings != null) {
            ItemInitializer itemInitializer = new ItemInitializer(MOD_ID);
            for (String alias : ALIAS_MOD_IDS) itemInitializer.addModIdAlias(alias);
            REGISTERED_ITEMS.add(itemInitializer.registerBlockItem(name, block, itemSettings));
        }

        for (String alias : ALIAS_MOD_IDS) AliasedID.addAlias(Registries.BLOCK, Identifier.of(alias, id.getPath()), id);
        return block;
    }

    ///
    /// Registers a block.
    /// Leave the fourth argument empty to use default block item settings.
    /// Set the fourth argument to null for no block item.
    ///
    public RegistrySupplier<Block> register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return register(name, factory, settings, new Item.Settings());
    }

    public ArrayList<RegistrySupplier<Item>> getRegisteredItems() {
        return REGISTERED_ITEMS;
    }

    /// This method only affects Fabric, though it's safe to use in Neoforge.
    ///
    /// To make a block transparent in NeoForge, set the field "render_type" to "cutout" in your block's model.
    @SafeVarargs
    public final void addTransparentBlocks(BlockRenderLayer layer, RegistrySupplier<Block>... blocks) {
        for (RegistrySupplier<Block> b : blocks) TRANSPARENT.put(b, layer);
    }

    @SafeVarargs
    public final void addColorProvider(BlockColorProvider provider, RegistrySupplier<Block>... blocks) {
        COLOR_PROVIDERS.put(
                provider, blocks
        );
    }

    public static HashMap<RegistrySupplier<Block>, BlockRenderLayer> getTransparentBlocks() {
        return TRANSPARENT;
    }

    public static HashMap<BlockColorProvider, RegistrySupplier<Block>[]> getColorProviders() {
        return COLOR_PROVIDERS;
    }
}
