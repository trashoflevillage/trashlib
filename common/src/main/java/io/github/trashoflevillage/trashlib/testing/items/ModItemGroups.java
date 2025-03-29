package io.github.trashoflevillage.trashlib.testing.items;

import dev.architectury.registry.registries.RegistrySupplier;
import io.github.trashoflevillage.trashlib.Trashlib;
import io.github.trashoflevillage.trashlib.initializers.ItemGroupInitializer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;

public class ModItemGroups {
    private static final ItemGroupInitializer INITIALIZER = new ItemGroupInitializer(Trashlib.MOD_ID);

    public static final RegistrySupplier<ItemGroup> TEST_GROUP = INITIALIZER.register(
            "test", Items.POPPY.getDefaultStack()
    );

    public static void registerAll() {}
}
