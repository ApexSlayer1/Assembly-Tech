package me.almana.assemblytech.voidminer.recipe;

import me.almana.assemblytech.multiblock.modifier.ModifierData;
import net.minecraft.util.RandomSource;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class VoidPumpingRoll {

    private VoidPumpingRoll() {}

    public static List<FluidStack> roll(List<VoidPumpEntry> entries, @Nullable ModifierData modifierData, RandomSource random) {
        if (entries.isEmpty()) return List.of();

        int extraDrops = modifierData != null ? modifierData.getExtraDrops() : 0;
        int parallelBonus = modifierData != null ? modifierData.getParallelBonus() : 0;
        int picks = 1 + extraDrops + parallelBonus;

        int total = 0;
        for (VoidPumpEntry e : entries) total += e.weight();

        List<FluidStack> out = new ArrayList<>(picks);
        for (int p = 0; p < picks; p++) {
            int roll = random.nextInt(total);
            int cursor = 0;
            for (VoidPumpEntry e : entries) {
                cursor += e.weight();
                if (roll < cursor) {
                    int range = e.amountMax() - e.amountMin() + 1;
                    int amount = e.amountMin() + (range > 1 ? random.nextInt(range) : 0);
                    out.add(new FluidStack(e.fluid().value(), amount));
                    break;
                }
            }
        }
        return out;
    }
}
