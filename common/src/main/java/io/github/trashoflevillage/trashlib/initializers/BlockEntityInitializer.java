package io.github.trashoflevillage.trashlib.initializers;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.BlockPos;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class BlockEntityInitializer extends AbstractInitializer {
    private final DeferredRegister<BlockEntityType<?>> DEFERRED_REGISTER;
    public BlockEntityInitializer(String modId) {
        super(modId);
        DEFERRED_REGISTER = DeferredRegister.create(modId, RegistryKeys.BLOCK_ENTITY_TYPE);
        DEFERRED_REGISTER.register();
    }

    public <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> register(
            String name,
            BlockEntityFactory<T> factory,
            Supplier<List<Block>> blockSupplier
    ) {
        return register(name, factory, DEFERRED_REGISTER, blockSupplier);
    }

    @ExpectPlatform
    private static <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> register(
            String name,
            BlockEntityFactory<T> factory,
            DeferredRegister<BlockEntityType<?>> deferredRegister,
            Supplier<List<Block>> blockSupplier
    ) {
        throw new AssertionError("Called BlockInitializer.register() without modloader implementation.");
    }

    public interface BlockEntityFactory<T extends BlockEntity> {
        T create(BlockPos pos, BlockState state);
    }
}
