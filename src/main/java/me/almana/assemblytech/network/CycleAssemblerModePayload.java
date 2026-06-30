package me.almana.assemblytech.network;

import me.almana.assemblytech.Assemblytech;
import me.almana.assemblytech.multiblock.tool.AssemblerItem;
import me.almana.assemblytech.multiblock.tool.AssemblerMode;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record CycleAssemblerModePayload(int dir) implements CustomPacketPayload {

    public static final Type<CycleAssemblerModePayload> TYPE =
            new Type<>(Identifier.fromNamespaceAndPath(Assemblytech.MODID, "cycle_assembler_mode"));
    public static final StreamCodec<RegistryFriendlyByteBuf, CycleAssemblerModePayload> STREAM_CODEC =
            StreamCodec.of(
                    (buf, payload) -> buf.writeVarInt(payload.dir),
                    buf -> new CycleAssemblerModePayload(buf.readVarInt()));

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(CycleAssemblerModePayload payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player() instanceof ServerPlayer player) {
                AssemblerMode mode = AssemblerItem.cycle(player, payload.dir());
                player.sendSystemMessage(
                        Component.translatable("assemblytech.assembler.mode", mode.name()), true);
            }
        });
    }
}
