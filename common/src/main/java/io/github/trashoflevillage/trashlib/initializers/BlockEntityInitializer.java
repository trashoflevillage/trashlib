package io.github.trashoflevillage.trashlib.initializers;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class BlockEntityInitializer extends AbstractInitializer {
    private final DeferredRegister<BlockEntityType<?>> DEFERRED_REGISTER;
    public BlockEntityInitializer(String modId) {
        super(modId);
        DEFERRED_REGISTER = DeferredRegister.create(modId, RegistryKeys.BLOCK_ENTITY_TYPE);
    }

    public <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> register(
            String name,
            BlockEntityFactory<T> factory,
            Set<Block> blocks
    ) {
        return register(this.MOD_ID, name, factory, DEFERRED_REGISTER, blocks);
    }

    @ExpectPlatform
    private static <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> register(
            String modId,
            String name,
            BlockEntityFactory<T> factory,
            DeferredRegister<BlockEntityType<?>> deferredRegister,
            Set<Block> blocks
    ) {
        throw new AssertionError("Called BlockInitializer.register() without modloader implementation.");
    }

    public interface BlockEntityFactory<T extends BlockEntity> {
        T create(BlockPos var1, BlockState var2);
    }
}
