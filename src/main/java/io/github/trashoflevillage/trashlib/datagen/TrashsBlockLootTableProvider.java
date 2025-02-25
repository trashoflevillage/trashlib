package io.github.trashoflevillage.trashlib.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public abstract class TrashsBlockLootTableProvider extends FabricBlockLootTableProvider {
    protected TrashsBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public void addSlabDrops(Block block) {
        lootTables.put(block.getLootTableKey().orElseThrow(() ->
                new IllegalStateException("Block " + block + " does not have loot table")), slabDrops(block));
    }

    public void addOreDrops(Block block, Item item, int minCount, int maxCount) {
        if (minCount < 1) minCount = 1;
        if (maxCount < minCount) maxCount = minCount;
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        LootTable.Builder builder =
                this.dropsWithSilkTouch(
                    block,
                    this.applyExplosionDecay(
                            block,
                            ItemEntry.builder(item)
                                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minCount, maxCount)))
                                    .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
        lootTables.put(block.getLootTableKey().orElseThrow(() ->
                new IllegalStateException("Block " + block + " does not have loot table")), builder);
    }

    public void addOreDrops(Block block, Item item) {
        addOreDrops(block, item, 1, 1);
    }
}
