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

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public class BlockEntityInitializerImpl {
    public static <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> register(
            String name,
            BlockEntityInitializer.BlockEntityFactory<T> factory,
            DeferredRegister<BlockEntityType<?>> deferredRegister,
            Supplier<List<Block>> blockSupplier
    )  {
        return deferredRegister.register(
                name,
                () -> {
                    Set<Block> blocks = new java.util.HashSet<>(Set.of());
                    blocks.addAll(blockSupplier.get());
                    return new BlockEntityType<T>(
                            factory::create,
                            blocks
                    );
                }
        );
    }
}
