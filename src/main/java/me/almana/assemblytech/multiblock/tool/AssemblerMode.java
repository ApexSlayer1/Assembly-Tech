package me.almana.assemblytech.multiblock.tool;

public enum AssemblerMode {
    FORM,
    SCAN;

    public AssemblerMode cycle(int dir) {
        AssemblerMode[] modes = values();
        return modes[Math.floorMod(ordinal() + dir, modes.length)];
    }
}
