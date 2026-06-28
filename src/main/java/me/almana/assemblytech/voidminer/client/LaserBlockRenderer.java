package me.almana.assemblytech.voidminer.client;

import com.mojang.blaze3d.vertex.PoseStack;
import me.almana.assemblytech.Assemblytech;
import me.almana.assemblytech.multiblock.slave.MultiblockSlaveEntity;
import me.almana.assemblytech.registry.ModBlocks;
import me.almana.assemblytech.voidminer.LaserBlock;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public final class LaserBlockRenderer implements BlockEntityRenderer<MultiblockSlaveEntity, LaserBlockRenderer.State> {

    private static final int FULL_BRIGHT = 0xF000F0;

    private static final Identifier[] TEXTURES = {
            texture(1),
            texture(2),
            texture(3),
            texture(4),
            texture(5),
            texture(6),
            texture(7)
    };

    private final LaserModel model;

    public LaserBlockRenderer(BlockEntityRendererProvider.Context context) {
        this.model = new LaserModel(context.bakeLayer(LaserModel.LAYER_LOCATION));
    }

    @Override
    public State createRenderState() {
        return new State();
    }

    @Override
    public void extractRenderState(
            MultiblockSlaveEntity blockEntity,
            State state,
            float partialTicks,
            Vec3 cameraPosition,
            ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress
    ) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.visible = blockEntity.getBlockState().is(ModBlocks.DRILL_BLOCK.get());
        if (!state.visible) return;
        state.facing = blockEntity.getBlockState().getValue(LaserBlock.FACING);
        state.tier = tier(blockEntity, state.facing);
        state.ticks = ticks(blockEntity, partialTicks);
        state.lightCoords = FULL_BRIGHT;
    }

    @Override
    public void submit(State state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        if (!state.visible) return;

        poseStack.pushPose();
        poseStack.translate(
                0.5F + state.facing.getStepX(),
                0.5F + state.facing.getStepY(),
                0.5F + state.facing.getStepZ()
        );
        poseStack.mulPose(state.facing.getRotation());
        poseStack.scale(1.0F, -1.0F, -1.0F);
        submitNodeCollector.submitModel(
                model,
                new LaserModel.State(state.ticks),
                poseStack,
                TEXTURES[state.tier - 1],
                state.lightCoords,
                OverlayTexture.NO_OVERLAY,
                0,
                state.breakProgress
        );
        poseStack.popPose();
    }

    private static Identifier texture(int tier) {
        return Identifier.fromNamespaceAndPath(Assemblytech.MODID, "textures/entity/laser/laser_finished_tier_" + tier + ".png");
    }

    private static float ticks(MultiblockSlaveEntity blockEntity, float partialTick) {
        Level level = blockEntity.getLevel();
        return level == null ? partialTick : level.getGameTime() + partialTick;
    }

    private static int tier(MultiblockSlaveEntity blockEntity, Direction facing) {
        Level level = blockEntity.getLevel();
        if (level == null) return 1;

        int tier = ModBlocks.controllerTier(level.getBlockState(blockEntity.getBlockPos().relative(facing, 5)).getBlock());
        return tier == 0 ? 1 : tier;
    }

    public static final class State extends BlockEntityRenderState {
        boolean visible;
        Direction facing = Direction.UP;
        int tier = 1;
        float ticks;
    }
}
