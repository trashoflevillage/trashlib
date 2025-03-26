package io.github.trashoflevillage.trashlib.util;

import io.github.trashoflevillage.trashlib.initializers.TagInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ConventionalTags {
    public static class Items {
        private static final TagInitializer<Item> initializer = new TagInitializer<>("c", RegistryKeys.ITEM);

        public static final TagKey<Item> CONCRETE_POWDERS = initializer.register("concrete_powders");
        public static final TagKey<Item> CONCRETE = initializer.register("concrete");
        public static final TagKey<Item> GLASS_BLOCKS = initializer.register("glass_blocks");
        public static final TagKey<Item> GLASS_PANES = initializer.register("glass_panes");
    }
}
