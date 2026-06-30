package me.almana.assemblytech.voidminer.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.material.Fluid;

import java.util.Optional;

public record VoidPumpEntry(Holder<Fluid> fluid, int weight, int amountMin, int amountMax) {

    public static final Codec<VoidPumpEntry> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            BuiltInRegistries.FLUID.holderByNameCodec().fieldOf("fluid").forGetter(VoidPumpEntry::fluid),
            Codec.intRange(1, Integer.MAX_VALUE).fieldOf("weight").forGetter(VoidPumpEntry::weight),
            Codec.intRange(1, Integer.MAX_VALUE).optionalFieldOf("amount").forGetter(e -> Optional.empty()),
            Codec.intRange(1, Integer.MAX_VALUE).optionalFieldOf("amount_min", 1000).forGetter(VoidPumpEntry::amountMin),
            Codec.intRange(1, Integer.MAX_VALUE).optionalFieldOf("amount_max", 1000).forGetter(VoidPumpEntry::amountMax)
    ).apply(inst, VoidPumpEntry::create));

    public VoidPumpEntry {
        if (amountMin > amountMax) throw new IllegalArgumentException("amountMin > amountMax");
    }

    private static VoidPumpEntry create(Holder<Fluid> fluid, int weight, Optional<Integer> amount, int min, int max) {
        if (amount.isPresent()) return new VoidPumpEntry(fluid, weight, amount.get(), amount.get());
        return new VoidPumpEntry(fluid, weight, min, max);
    }

    public static VoidPumpEntry of(Holder<Fluid> fluid, int weight, int amountMin, int amountMax) {
        return new VoidPumpEntry(fluid, weight, amountMin, amountMax);
    }

    public static VoidPumpEntry fixed(Holder<Fluid> fluid, int weight, int amount) {
        return new VoidPumpEntry(fluid, weight, amount, amount);
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeIdentifier(BuiltInRegistries.FLUID.getKey(fluid.value()));
        buf.writeVarInt(weight);
        buf.writeVarInt(amountMin);
        buf.writeVarInt(amountMax);
    }

    public static VoidPumpEntry read(FriendlyByteBuf buf) {
        Identifier id = buf.readIdentifier();
        int weight = buf.readVarInt();
        int min = buf.readVarInt();
        int max = buf.readVarInt();
        return new VoidPumpEntry(BuiltInRegistries.FLUID.wrapAsHolder(BuiltInRegistries.FLUID.getValue(id)), weight, min, max);
    }
}
