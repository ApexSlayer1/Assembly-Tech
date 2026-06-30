package me.almana.assemblytech.voidminer.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.almana.assemblytech.Assemblytech;
import me.almana.assemblytech.registry.ModRecipes;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.List;

public record VoidPumpingRecipe(String texture, Holder<Item> designator, List<VoidPumpEntry> entries) implements Recipe<VoidPumpingRecipe.Input> {

    public static final Identifier ID = Identifier.fromNamespaceAndPath(Assemblytech.MODID, "void_pumping");
    public static final MapCodec<VoidPumpingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            com.mojang.serialization.Codec.STRING.optionalFieldOf("texture", "")
                    .xmap(texture -> texture.isEmpty() ? "earth" : texture, texture -> texture)
                    .forGetter(VoidPumpingRecipe::texture),
            BuiltInRegistries.ITEM.holderByNameCodec().fieldOf("designator").forGetter(VoidPumpingRecipe::designator),
            VoidPumpEntry.CODEC.listOf().fieldOf("entries").forGetter(VoidPumpingRecipe::entries)
    ).apply(inst, VoidPumpingRecipe::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, VoidPumpingRecipe> STREAM_CODEC = StreamCodec.of(
            VoidPumpingRecipe::write,
            VoidPumpingRecipe::read
    );

    @Override
    public boolean matches(Input input, Level level) {
        return input.designator() == designator.value();
    }

    @Override
    public ItemStack assemble(Input input) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean showNotification() {
        return true;
    }

    @Override
    public String group() {
        return "void_pumping";
    }

    @Override
    public RecipeSerializer<? extends Recipe<Input>> getSerializer() {
        return ModRecipes.VOID_PUMPING_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<Input>> getType() {
        return ModRecipes.VOID_PUMPING.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    private static VoidPumpingRecipe read(RegistryFriendlyByteBuf buf) {
        String texture = buf.readUtf();
        Item designator = BuiltInRegistries.ITEM.getValue(buf.readIdentifier());
        List<VoidPumpEntry> entries = buf.readList(VoidPumpEntry::read);
        return new VoidPumpingRecipe(texture, BuiltInRegistries.ITEM.wrapAsHolder(designator), entries);
    }

    private static void write(RegistryFriendlyByteBuf buf, VoidPumpingRecipe recipe) {
        buf.writeUtf(recipe.texture());
        buf.writeIdentifier(BuiltInRegistries.ITEM.getKey(recipe.designator().value()));
        buf.writeCollection(recipe.entries(), (entryBuf, entry) -> entry.write(entryBuf));
    }

    public record Input(Item designator) implements RecipeInput {

        @Override
        public ItemStack getItem(int index) {
            return ItemStack.EMPTY;
        }

        @Override
        public int size() {
            return 0;
        }
    }
}
