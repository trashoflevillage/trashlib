//package io.github.trashoflevillage.trashlib.initializers;
//
//import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
//import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
//import net.minecraft.item.*;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.registry.RegistryKey;
//import net.minecraft.text.Text;
//import net.minecraft.util.Identifier;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ItemGroupInitializer extends AbstractInitializer {
//    public ItemGroupInitializer(String modId) {
//        super(modId);
//    }
//
//    public ItemGroup register(String path, String translationKey, ItemConvertible icon, ItemConvertible... contents) {
//        return Registry.register(Registries.ITEM_GROUP, Identifier.of(MOD_ID, path),
//                FabricItemGroup.builder().displayName(Text.translatable(translationKey))
//                        .icon(() -> new ItemStack(icon))
//                        .entries(((displayContext, entries) -> {
//                            for (ItemConvertible i : contents) entries.add(i);
//                        }))
//                        .build()
//        );
//    }
//
//    @SafeVarargs
//    public final ItemGroup register(String path, String translationKey, ItemConvertible icon, ArrayList<ItemConvertible>... contents) {
//        return Registry.register(Registries.ITEM_GROUP, Identifier.of(MOD_ID, path),
//                FabricItemGroup.builder().displayName(Text.translatable(translationKey))
//                        .icon(() -> new ItemStack(icon))
//                        .entries(((displayContext, entries) -> {
//                            for (ArrayList<ItemConvertible> items : contents) for (ItemConvertible i : items) entries.add(i);
//                        }))
//                        .build()
//        );
//    }
//
//    public static void addItemsToItemGroup(RegistryKey<ItemGroup> group, ItemConvertible... items) {
//        ItemGroupEvents.modifyEntriesEvent(group).register(content -> {
//            for (ItemConvertible i : items)
//                content.add(i);
//        });
//    }
//}
