package me.almana.assemblytech.multiblock.tool;

import me.almana.assemblytech.multiblock.api.StructureComponent;
import me.almana.assemblytech.multiblock.api.StructureDefinition;
import me.almana.assemblytech.multiblock.controller.MultiblockControllerEntity;
import me.almana.assemblytech.multiblock.validation.ValidationResult;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AssemblerItem extends Item {

    private static final Map<UUID, AssemblerMode> MODES = new HashMap<>();
    private static final Map<UUID, BlockPos> CORNER = new HashMap<>();

    public AssemblerItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    public static AssemblerMode mode(Player player) {
        return MODES.getOrDefault(player.getUUID(), AssemblerMode.FORM);
    }

    public static AssemblerMode cycle(Player player, int dir) {
        AssemblerMode next = mode(player).cycle(dir);
        MODES.put(player.getUUID(), next);
        return next;
    }

    @Override
    public InteractionResult useOn(UseOnContext ctx) {
        Level level = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        Player player = ctx.getPlayer();

        if (player == null) return InteractionResult.PASS;

        boolean creative = player.isCreative();
        boolean sneaking = player.isShiftKeyDown();

        if (creative && mode(player) == AssemblerMode.SCAN) {
            if (level.isClientSide()) return InteractionResult.SUCCESS;
            handleScan((ServerLevel) level, pos, player);
            return InteractionResult.SUCCESS;
        }

        BlockEntity be = level.getBlockEntity(pos);
        if (!(be instanceof MultiblockControllerEntity controller)) return InteractionResult.PASS;
        if (level.isClientSide()) return InteractionResult.SUCCESS;

        if (creative && sneaking) {
            pickUpStructure(level, controller, pos);
        } else if (creative) {
            placeStructure(level, controller, pos);
        } else if (sneaking) {
            level.destroyBlock(pos, true);
        } else {
            formOrShowNext(player, controller);
        }

        return InteractionResult.SUCCESS;
    }

    private void pickUpStructure(Level level, MultiblockControllerEntity controller, BlockPos controllerPos) {
        List<BlockPos> slaves = controller.getSlavePositions();
        controller.deform();
        for (BlockPos slave : slaves) {
            level.removeBlock(slave, false);
        }
        level.removeBlock(controllerPos, false);
    }

    private void placeStructure(Level level, MultiblockControllerEntity controller, BlockPos controllerPos) {
        controller.tryForm();
    }

    private void handleScan(ServerLevel level, BlockPos pos, Player player) {
        UUID id = player.getUUID();
        BlockPos first = CORNER.get(id);
        if (first == null) {
            CORNER.put(id, pos.immutable());
            sendActionBar(player, Component.translatable(
                    "assemblytech.assembler.corner_set", pos.getX(), pos.getY(), pos.getZ()));
            return;
        }

        CORNER.remove(id);
        try {
            Path file = StructureScan.export(level, first, pos);
            sendActionBar(player, Component.translatable(
                    "assemblytech.assembler.saved", file.getFileName().toString()));
        } catch (IOException e) {
            sendActionBar(player, Component.translatable("assemblytech.assembler.save_failed"));
        }
    }

    private static void sendActionBar(Player player, Component message) {
        if (player instanceof ServerPlayer sp) {
            sp.sendSystemMessage(message, true);
        }
    }

    private void formOrShowNext(Player player, MultiblockControllerEntity controller) {
        if (controller.isFormed()) {
            if (player instanceof ServerPlayer sp) {
                sp.sendSystemMessage(Component.translatable("assemblytech.multiblock.already_formed"), true);
            }
            return;
        }

        ValidationResult result = controller.tryForm();
        if (result.isValid()) {
            if (player instanceof ServerPlayer sp) {
                sp.sendSystemMessage(Component.translatable("assemblytech.multiblock.formed"), true);
            }
        } else {
            List<StructureComponent> missing = result.missingComponents();
            if (!missing.isEmpty()) {
                StructureComponent next = missing.get(0);
                BlockPos offset = next.offset();
                if (player instanceof ServerPlayer sp) {
                    sp.sendSystemMessage(
                            Component.translatable("assemblytech.multiblock.missing",
                                    next.type().name(),
                                    offset.getX(), offset.getY(), offset.getZ()),
                            true
                    );
                }
            }
        }
    }

    public static void showStructureInfo(Player player, MultiblockControllerEntity controller) {
        StructureDefinition structure = controller.getMultiblockType().structure();
        if (player instanceof ServerPlayer sp) {
            sp.sendSystemMessage(
                    Component.translatable("assemblytech.multiblock.info",
                            controller.getMultiblockType().id().toString(),
                            structure.size()),
                    false
            );

            if (controller.isFormed()) {
                sp.sendSystemMessage(Component.translatable("assemblytech.multiblock.status_formed"), false);
            } else {
                ValidationResult result = StructureValidator_check(controller);
                List<StructureComponent> missing = result.missingComponents();
                sp.sendSystemMessage(
                        Component.translatable("assemblytech.multiblock.status_incomplete", missing.size()),
                        false
                );
            }
        }
    }

    private static ValidationResult StructureValidator_check(MultiblockControllerEntity controller) {
        if (controller.getLevel() == null) return ValidationResult.failure(List.of());
        return me.almana.assemblytech.multiblock.validation.StructureValidator.validate(
                controller.getLevel(),
                controller.getBlockPos(),
                controller.getMultiblockType().structure()
        );
    }
}
