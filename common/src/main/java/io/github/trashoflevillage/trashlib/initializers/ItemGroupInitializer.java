package io.github.trashoflevillage.trashlib.initializers;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ItemGroupInitializer extends AbstractInitializer {
    private final Registrar<ItemGroup> REGISTRAR = MANAGER.get().get(Registries.ITEM_GROUP);

    public ItemGroupInitializer(String modId) {
        super(modId);
    }

    public RegistrySupplier<ItemGroup> register(String name, Supplier<ItemStack> iconSupplier) {
        Identifier id = Identifier.of(MOD_ID, name);
        RegistrySupplier<ItemGroup> itemGroup = REGISTRAR.register(id, () -> CreativeTabRegistry.create(
                Text.translatable("itemgroup." + MOD_ID + "." + name),
                iconSupplier
        ));
        return itemGroup;
    }
}
