package io.github.trashoflevillage.trashlib.util;

import io.github.trashoflevillage.trashlib.initializers.TagInitializer;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ConventionalTags {
    public static class Items {
        private static final TagInitializer<Item> INITIALIZER = new TagInitializer<>("c", RegistryKeys.ITEM);

        public static final TagKey<Item> CONCRETE_POWDERS = of("concrete_powders");
        public static final TagKey<Item> CONCRETE = of("concrete");
        public static final TagKey<Item> GLASS_BLOCKS = of("glass_blocks");
        public static final TagKey<Item> GLASS_PANES = of("glass_panes");
        public static final TagKey<Item> SHULKER_BOXES = of("shulker_boxes");
        public static final TagKey<Item> GLAZED_TERRACOTTAS = of("glazed_terracottas");
        
        public static TagKey<Item> of(String name) {
            return INITIALIZER.register(name);
        }
    }

    public static class Blocks {
        private static final TagInitializer<Block> INITIALIZER = new TagInitializer<>("c", RegistryKeys.BLOCK);

        public static TagKey<Block> of(String name) {
            return INITIALIZER.register(name);
        }
    }

    public static class EntityTypes {
        private static final TagInitializer<EntityType<?>> initializer = new TagInitializer<>("c", RegistryKeys.ENTITY_TYPE);

        public static TagKey<EntityType<?>> of(String name) {
            return initializer.register(name);
        }
    }
}
