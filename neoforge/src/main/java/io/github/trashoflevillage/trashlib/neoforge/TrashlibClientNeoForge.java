package io.github.trashoflevillage.trashlib.neoforge;

import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.trashoflevillage.trashlib.Trashlib;
import io.github.trashoflevillage.trashlib.initializers.BlockInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.BlockRenderManager;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = Trashlib.MOD_ID, dist = Dist.CLIENT)
public class TrashlibClientNeoForge {
    public TrashlibClientNeoForge(IEventBus modBus) {

    }
}
