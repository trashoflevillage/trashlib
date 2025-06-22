package io.github.trashoflevillage.trashlib.fabric.client;

import dev.architectury.registry.registries.RegistrySupplier;
import io.github.trashoflevillage.trashlib.initializers.BlockInitializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.render.RenderLayer;

public final class TrashlibFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        for (RegistrySupplier<Block> i : BlockInitializer.getTransparentBlocks())
            BlockRenderLayerMap.INSTANCE.putBlock(i.get(), RenderLayer.getCutout());

        for (BlockColorProvider p : BlockInitializer.getColorProviders().keySet()) {
            for (RegistrySupplier<Block> b : BlockInitializer.getColorProviders().get(p)) {
                ColorProviderRegistry.BLOCK.register(
                        p, b.get()
                );
            }
        }
    }
}
