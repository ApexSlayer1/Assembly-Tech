package me.almana.assemblytech.voidminer.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.MapCodec;
import me.almana.assemblytech.Assemblytech;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.special.NoDataSpecialModelRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.resources.Identifier;
import org.joml.Vector3fc;

import java.util.function.Consumer;

public final class LaserItemRenderer implements NoDataSpecialModelRenderer {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(Assemblytech.MODID, "laser");
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(
            Assemblytech.MODID,
            "textures/entity/laser/laser_finished_tier_1.png"
    );

    private final LaserModel model;

    private LaserItemRenderer(LaserModel model) {
        this.model = model;
    }

    @Override
    public void submit(
            PoseStack poseStack,
            SubmitNodeCollector submitNodeCollector,
            int lightCoords,
            int overlayCoords,
            boolean hasFoil,
            int outlineColor
    ) {
        poseStack.pushPose();
        poseStack.translate(0.5F, 1.5F, 0.5F);
        poseStack.scale(1.0F, -1.0F, -1.0F);
        submitNodeCollector.submitModel(
                model,
                new LaserModel.State(0.0F),
                poseStack,
                TEXTURE,
                lightCoords,
                overlayCoords,
                0,
                null
        );
        poseStack.popPose();
    }

    @Override
    public void getExtents(Consumer<Vector3fc> output) {
        PoseStack poseStack = new PoseStack();
        poseStack.translate(0.5F, 1.5F, 0.5F);
        poseStack.scale(1.0F, -1.0F, -1.0F);
        model.root().getExtentsForGui(poseStack, output);
    }

    public record Unbaked() implements NoDataSpecialModelRenderer.Unbaked {
        public static final MapCodec<LaserItemRenderer.Unbaked> MAP_CODEC = MapCodec.unit(new LaserItemRenderer.Unbaked());

        @Override
        public MapCodec<? extends NoDataSpecialModelRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        @Override
        public SpecialModelRenderer<Void> bake(SpecialModelRenderer.BakingContext context) {
            return new LaserItemRenderer(new LaserModel(context.entityModelSet().bakeLayer(LaserModel.LAYER_LOCATION)));
        }
    }
}
