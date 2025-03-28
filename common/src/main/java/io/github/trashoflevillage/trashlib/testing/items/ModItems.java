package io.github.trashoflevillage.trashlib.testing.items;

import dev.architectury.registry.registries.RegistrySupplier;
import io.github.trashoflevillage.trashlib.Trashlib;
import io.github.trashoflevillage.trashlib.initializers.ItemInitializer;
import net.minecraft.item.Item;

public class ModItems {
    private static final ItemInitializer INITIALIZER = new ItemInitializer(Trashlib.MOD_ID);

    public static final RegistrySupplier<Item> TEST_ITEM =
            INITIALIZER.register("test_item", Item::new, new Item.Settings().arch$tab(ModItemGroups.TEST_GROUP));

    public static void registerAll() {

    }
}
