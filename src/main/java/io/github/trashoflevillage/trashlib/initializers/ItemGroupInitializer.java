package io.github.trashoflevillage.trashlib.initializers;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroupInitializer extends AbstractInitializer {
    public ItemGroupInitializer(String modId) {
        super(modId);
    }

    public ItemGroup register(String path, String translationKey, ItemConvertible icon, ItemConvertible... contents) {
        return Registry.register(Registries.ITEM_GROUP, Identifier.of(MOD_ID, path),
                FabricItemGroup.builder().displayName(Text.translatable(translationKey))
                        .icon(() -> new ItemStack(icon))
                        .entries(((displayContext, entries) -> {
                            for (ItemConvertible i : contents) entries.add(i);
                        }))
                        .build()
        );
    }
}
