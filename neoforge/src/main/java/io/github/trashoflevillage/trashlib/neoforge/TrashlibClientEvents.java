package io.github.trashoflevillage.trashlib.neoforge;

import com.mojang.serialization.MapCodec;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.trashoflevillage.trashlib.Trashlib;
import io.github.trashoflevillage.trashlib.initializers.BlockInitializer;
import io.github.trashoflevillage.trashlib.initializers.ItemInitializer;
import net.minecraft.block.Block;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.render.item.tint.TintSource;
import net.minecraft.client.render.item.tint.TintSourceTypes;
import net.minecraft.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = Trashlib.MOD_ID)
public class TrashlibClientEvents {
    @SubscribeEvent
    public static void registerBlockColorHandlers(RegisterColorHandlersEvent.Block event) {
        for (BlockColorProvider p : BlockInitializer.getColorProviders().keySet()) {
            for (RegistrySupplier<Block> b : BlockInitializer.getColorProviders().get(p)) {
                event.register(p, b.get());
            }
        }
    }

    @SubscribeEvent
    public static void  registerItemColorHandlers(RegisterColorHandlersEvent.ItemTintSources event) {
        for (MapCodec<? extends TintSource> p : ItemInitializer.getColorProviders().keySet()) {
            event.register(ItemInitializer.getColorProviders().get(p), p);
        }
    }
}
