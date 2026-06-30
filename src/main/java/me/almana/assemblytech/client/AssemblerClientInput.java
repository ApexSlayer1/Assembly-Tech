package me.almana.assemblytech.client;

import me.almana.assemblytech.multiblock.tool.AssemblerItem;
import me.almana.assemblytech.network.CycleAssemblerModePayload;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;

public final class AssemblerClientInput {

    private AssemblerClientInput() {}

    public static void onScroll(InputEvent.MouseScrollingEvent event) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null || !player.isShiftKeyDown() || !player.isCreative()) return;

        ItemStack held = player.getMainHandItem();
        if (!(held.getItem() instanceof AssemblerItem)) return;

        double dy = event.getScrollDeltaY();
        if (dy == 0) return;

        event.setCanceled(true);
        ClientPacketDistributor.sendToServer(new CycleAssemblerModePayload(dy > 0 ? 1 : -1));
    }
}
