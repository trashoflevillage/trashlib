package io.github.trashoflevillage.trashlib.fabric.client;

import dev.architectury.registry.registries.RegistrySupplier;
import io.github.trashoflevillage.trashlib.initializers.BlockInitializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public final class TrashlibFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        for (RegistrySupplier<Block> i : BlockInitializer.getTransparentBlocks())
            BlockRenderLayerMap.INSTANCE.putBlock(i.get(), RenderLayer.getCutout());
    }
}
