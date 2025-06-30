package io.github.trashoflevillage.trashlib.initializers.neoforge;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.trashoflevillage.trashlib.initializers.BlockEntityInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Set;

@SuppressWarnings("unchecked")
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
                    new BlockEntityType<T>(
                        (BlockEntityType.BlockEntityFactory<T>)factory,
                        blocks
                    )
                )
        );
    }
}
