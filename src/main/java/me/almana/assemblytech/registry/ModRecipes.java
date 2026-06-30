package me.almana.assemblytech.registry;

import me.almana.assemblytech.Assemblytech;
import me.almana.assemblytech.voidminer.recipe.VoidMiningRecipe;
import me.almana.assemblytech.voidminer.recipe.VoidPumpingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModRecipes {

    private ModRecipes() {}

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, Assemblytech.MODID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, Assemblytech.MODID);

    public static final DeferredHolder<RecipeType<?>, RecipeType<VoidMiningRecipe>> VOID_MINING =
            RECIPE_TYPES.register("void_mining", () -> new RecipeType<VoidMiningRecipe>() {
                @Override
                public String toString() {
                    return VoidMiningRecipe.ID.toString();
                }
            });
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<VoidMiningRecipe>> VOID_MINING_SERIALIZER =
            RECIPE_SERIALIZERS.register("void_mining", () -> new RecipeSerializer<>(VoidMiningRecipe.CODEC, VoidMiningRecipe.STREAM_CODEC));

    public static final DeferredHolder<RecipeType<?>, RecipeType<VoidPumpingRecipe>> VOID_PUMPING =
            RECIPE_TYPES.register("void_pumping", () -> new RecipeType<VoidPumpingRecipe>() {
                @Override
                public String toString() {
                    return VoidPumpingRecipe.ID.toString();
                }
            });
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<VoidPumpingRecipe>> VOID_PUMPING_SERIALIZER =
            RECIPE_SERIALIZERS.register("void_pumping", () -> new RecipeSerializer<>(VoidPumpingRecipe.CODEC, VoidPumpingRecipe.STREAM_CODEC));

    public static void init() {}
}
