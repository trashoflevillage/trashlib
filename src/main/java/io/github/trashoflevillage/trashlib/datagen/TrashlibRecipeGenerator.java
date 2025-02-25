package io.github.trashoflevillage.trashlib.datagen;

import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.BlastingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.List;

public abstract class TrashlibRecipeGenerator extends RecipeGenerator {
    protected TrashlibRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        super(registries, exporter);
    }

    public void offerSwordRecipe(ItemConvertible output, ItemConvertible material) {
        this.createShaped(RecipeCategory.COMBAT, output)
                .input('#', material)
                .input('/', Items.STICK)
                .input('_', Items.AIR)
                .pattern("_#_")
                .pattern("_#_")
                .pattern("_/_")
                .group("sword")
                .criterion(hasItem(material), this.conditionsFromItem(material))
                .offerTo(this.exporter);
    }

    public void offerPickaxeRecipe(ItemConvertible output, ItemConvertible material) {
        this.createShaped(RecipeCategory.TOOLS, output)
                .input('#', material)
                .input('/', Items.STICK)
                .input('_', Items.AIR)
                .pattern("###")
                .pattern("_/_")
                .pattern("_/_")
                .group("pickaxe")
                .criterion(hasItem(material), this.conditionsFromItem(material))
                .offerTo(this.exporter);
    }

    public void offerAxeRecipe(ItemConvertible output, ItemConvertible material) {
        this.createShaped(RecipeCategory.TOOLS, output)
                .input('#', material)
                .input('/', Items.STICK)
                .input('_', Items.AIR)
                .pattern("##_")
                .pattern("#/_")
                .pattern("_/_")
                .group("axe")
                .criterion(hasItem(material), this.conditionsFromItem(material))
                .offerTo(this.exporter);
    }

    public void offerShovelRecipe(ItemConvertible output, ItemConvertible material) {
        this.createShaped(RecipeCategory.TOOLS, output)
                .input('#', material)
                .input('/', Items.STICK)
                .input('_', Items.AIR)
                .pattern("_#_")
                .pattern("_/_")
                .pattern("_/_")
                .group("shovel")
                .criterion(hasItem(material), this.conditionsFromItem(material))
                .offerTo(this.exporter);
    }

    public void offerHoeRecipe(ItemConvertible output, ItemConvertible material) {
        this.createShaped(RecipeCategory.TOOLS, output)
                .input('#', material)
                .input('/', Items.STICK)
                .input('_', Items.AIR)
                .pattern("##_")
                .pattern("_/_")
                .pattern("_/_")
                .group("hoe")
                .criterion(hasItem(material), this.conditionsFromItem(material))
                .offerTo(this.exporter);
    }

    public void offerRecipesForToolset(
            ItemConvertible material,
            ItemConvertible sword,
            ItemConvertible pickaxe,
            ItemConvertible axe,
            ItemConvertible shovel,
            ItemConvertible hoe
    ) {
        offerSwordRecipe(sword, material);
        offerPickaxeRecipe(pickaxe, material);
        offerAxeRecipe(axe, material);
        offerShovelRecipe(shovel, material);
        offerHoeRecipe(hoe, material);
    }

    public void offerSmeltingAndBlasting(
            List<ItemConvertible> inputs,
            RecipeCategory category,
            ItemConvertible output,
            float experience,
            int cookingTime,
            String group
    ) {
        offerSmelting(inputs, category, output, experience, cookingTime, group);
        offerBlasting(inputs, category, output, experience, cookingTime / 2, group);
    }

    public void offerSmeltingAndSmoking(
            List<ItemConvertible> inputs,
            RecipeCategory category,
            ItemConvertible output,
            float experience,
            int cookingTime,
            String group
    ) {
        offerSmelting(inputs, category, output, experience, cookingTime, group);
        offerSmoking(inputs, category, output, experience, cookingTime / 2, group);
    }

    public void offerSmoking(List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group) {
        this.offerMultipleOptions(RecipeSerializer.SMOKING, SmokingRecipe::new, inputs, category, output, experience, cookingTime, group, "_from_smoking");
    }
}
