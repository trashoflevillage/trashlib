package io.github.trashoflevillage.trashlib.initializers.fabric;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.trashoflevillage.trashlib.initializers.BlockEntityInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Set;

public class BlockEntityInitializerImpl {
    public static <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> register(
            String modId,
            String name,
            BlockEntityInitializer.BlockEntityFactory<T> factory,
            DeferredRegister<BlockEntityType<?>> deferredRegister,
            Set<Block> blocks
    )  {
        return deferredRegister.register(
                name,
                () -> Registry.register(
                        Registries.BLOCK_ENTITY_TYPE,
                        Identifier.of(modId, name),
                        FabricBlockEntityTypeBuilder.create(factory::create).build()
                )
        );
    }
}
