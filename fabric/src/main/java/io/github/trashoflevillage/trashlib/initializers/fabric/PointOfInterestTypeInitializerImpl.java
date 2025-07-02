package io.github.trashoflevillage.trashlib.initializers.fabric;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.trashoflevillage.trashlib.initializers.BlockEntityInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class PointOfInterestTypeInitializerImpl {
    public static Supplier<PointOfInterestType> registerFabric(String modId, String name, Supplier<Set<BlockState>> statesProvider, int ticketCount, int searchDistance) {
        PointOfInterestType type = PointOfInterestHelper.register(Identifier.of(modId, name), ticketCount, searchDistance, statesProvider.get());
        return () -> type;
    }
}
