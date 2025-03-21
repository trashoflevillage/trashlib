package io.github.trashoflevillage.trashlib.initializers;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.trashoflevillage.trashlib.util.AliasedID;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class BlockInitializer extends AbstractInitializer {
    private static final ArrayList<RegistrySupplier<Block>> TRANSPARENT = new ArrayList<>();

    private final ArrayList<RegistrySupplier<Item>> REGISTERED_ITEMS = new ArrayList<>();
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
            REGISTERED_ITEMS.add(itemInitializer.registerBlockItem(name, block));
        }

        for (String alias : ALIAS_MOD_IDS) AliasedID.addAlias(Registries.BLOCK, Identifier.of(alias, id.getPath()), id);
        return block;
    }

    public RegistrySupplier<Block> register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return register(name, factory, settings, true);
    }

    public ArrayList<RegistrySupplier<Item>> getRegisteredItems() {
        return REGISTERED_ITEMS;
    }

    /// This method only affects Fabric, though it's safe to use in Neoforge.
    ///
    /// To make a block transparent in NeoForge, set the field "render_type" to "cutout" in your block's model.
    @SafeVarargs
    public final void addTransparentBlocks(RegistrySupplier<Block>... blocks) {
        TRANSPARENT.addAll(Arrays.asList(blocks));
    }

    public static ArrayList<RegistrySupplier<Block>> getTransparentBlocks() {
        return TRANSPARENT;
    }
}
