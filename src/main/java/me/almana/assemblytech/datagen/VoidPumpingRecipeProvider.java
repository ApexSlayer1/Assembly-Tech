package me.almana.assemblytech.datagen;

import me.almana.assemblytech.Assemblytech;
import me.almana.assemblytech.registry.ModItems;
import me.almana.assemblytech.voidminer.recipe.VoidPumpEntry;
import me.almana.assemblytech.voidminer.recipe.VoidPumpingRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public final class VoidPumpingRecipeProvider extends RecipeProvider.Runner {

    public VoidPumpingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public String getName() {
        return "Void Pumping Recipes";
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            protected void buildRecipes() {
                buildVoidPumpingRecipes(output);
            }
        };
    }

    private static void buildVoidPumpingRecipes(RecipeOutput output) {
        emit(output, ModItems.FLUID_DESIGNATOR.get(), "fluid_designator", "earth", fluidEntries());
    }

    private static void emit(RecipeOutput output, ItemLike designatorItem, String path, String texture, List<VoidPumpEntry> entries) {
        var designator = BuiltInRegistries.ITEM.wrapAsHolder(designatorItem.asItem());
        ResourceKey<Recipe<?>> key = ResourceKey.create(Registries.RECIPE,
                Identifier.fromNamespaceAndPath(Assemblytech.MODID, "void_pumping/" + path));
        output.accept(key, new VoidPumpingRecipe(texture, designator, entries), null);
    }

    // fluid designator: water bulk, lava rare; amounts in mB
    private static List<VoidPumpEntry> fluidEntries() {
        List<VoidPumpEntry> entries = new ArrayList<>();
        addFluid(entries, Fluids.WATER, 100, 1000, 1000);
        addFluid(entries, Fluids.LAVA, 20, 250, 500);
        return entries;
    }

    private static void addFluid(List<VoidPumpEntry> entries, Fluid fluid, int weight, int min, int max) {
        entries.add(VoidPumpEntry.of(BuiltInRegistries.FLUID.wrapAsHolder(fluid), weight, min, max));
    }
}
