package io.github.trashoflevillage.trashlib.testing.items;

import dev.architectury.registry.registries.RegistrySupplier;
import io.github.trashoflevillage.trashlib.Trashlib;
import io.github.trashoflevillage.trashlib.initializers.ItemInitializer;
import net.minecraft.item.Item;

public class ModItems {
    private static final ItemInitializer initializer = new ItemInitializer(Trashlib.MOD_ID);

    public static final RegistrySupplier<Item> TEST_ITEM =
            initializer.register("test_item", Item::new, new Item.Settings());

    public static void registerAll() {}
}
