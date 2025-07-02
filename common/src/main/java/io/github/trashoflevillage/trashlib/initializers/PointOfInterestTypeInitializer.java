package io.github.trashoflevillage.trashlib.initializers;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;

import java.util.Set;
import java.util.function.Supplier;

public class PointOfInterestTypeInitializer extends AbstractInitializer {
    private final Registrar<PointOfInterestType> REGISTRAR = MANAGER.get().get(Registries.POINT_OF_INTEREST_TYPE);
    private final DeferredRegister<PointOfInterestType> DEFERRED_REGISTER;
    public PointOfInterestTypeInitializer(String modId) {
        super(modId);
        DEFERRED_REGISTER = DeferredRegister.create(modId, RegistryKeys.POINT_OF_INTEREST_TYPE);
        DEFERRED_REGISTER.register();
    }

    /// 
    /// Registers a PointOfInterestType.
    /// Returns a Supplier rather than a RegistrySupplier because RegistrySupplier\<PointOfInterestType> isn't
    /// plausible in Fabric.
    /// 
    /// @param statesProvider The supplier for BlockStates for this POI type
    /// @param ticketCount The number of entities that can associate with any instance of a POI.
    /// @param searchDistance The maximum distance at which this POI can be found at.
    /// 
    public Supplier<PointOfInterestType> register(String name, Supplier<Set<BlockState>> statesProvider, int ticketCount, int searchDistance) {
        if (!Platform.isFabric()) {
            return registerNonFabric(name, statesProvider, ticketCount, searchDistance);
        } else {
            return registerFabric(MOD_ID, name, statesProvider, ticketCount, searchDistance);
        }
    }

    private Supplier<PointOfInterestType> registerNonFabric(String name, Supplier<Set<BlockState>> statesProvider, int ticketCount, int searchDistance) {
        return DEFERRED_REGISTER.register(
                name, () -> new PointOfInterestType(statesProvider.get(), ticketCount, searchDistance)
        );
    }

    @ExpectPlatform
    private static Supplier<PointOfInterestType> registerFabric(String modId, String name, Supplier<Set<BlockState>> statesProvider, int ticketCount, int searchDistance) {
        throw new AssertionError("Called PointOfInterestType.register() without modloader implementation.");
    }
}
