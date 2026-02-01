package io.github.trashoflevillage.trashlib.fabric.client;

import dev.architectury.registry.registries.RegistrySupplier;
import io.github.trashoflevillage.trashlib.initializers.BlockInitializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;

import java.util.HashMap;

public final class TrashlibFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HashMap<RegistrySupplier<Block>, BlockRenderLayer> transparentBlocks = BlockInitializer.getTransparentBlocks();
        for (RegistrySupplier<Block> b : transparentBlocks.keySet())
            BlockRenderLayerMap.putBlock(b.get(), transparentBlocks.get(b));

        for (BlockColorProvider p : BlockInitializer.getColorProviders().keySet()) {
            for (RegistrySupplier<Block> b : BlockInitializer.getColorProviders().get(p)) {
                ColorProviderRegistry.BLOCK.register(
                        p, b.get()
                );
            }
        }
    }
}
