package me.almana.assemblytech.voidminer.client;

import me.almana.assemblytech.Assemblytech;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

public final class LaserModel extends Model<LaserModel.State> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Assemblytech.MODID, "laser"), "main");
	private final ModelPart laser;
	private final ModelPart base;
	private final ModelPart lense2;
	private final ModelPart lights2;
	private final ModelPart svivvel;
	private final ModelPart frame;
	private final ModelPart lights1;
	private final ModelPart crystal;
	private final ModelPart lense;
	private final ModelPart mainBeam;
	private final ModelPart main_beam2;
	private final ModelPart laserPumps;
	private final ModelPart beams;
	private final ModelPart beam4;
	private final ModelPart beam6;
	private final ModelPart beams4;
	private final ModelPart beam8;
	private final ModelPart beam9;
	private final ModelPart beams2;
	private final ModelPart beam2;
	private final ModelPart beam3;
	private final ModelPart beams3;
	private final ModelPart beam5;
	private final ModelPart beam7;
	private final ModelPart laser1;
	private final ModelPart laser2;
	private final ModelPart center;

	public LaserModel(ModelPart root) {
		super(root, RenderTypes::entityCutout);
		this.laser = root.getChild("laser");
		this.base = root.getChild("base");
		this.lense2 = this.base.getChild("lense2");
		this.lights2 = this.base.getChild("lights2");
		this.svivvel = this.base.getChild("svivvel");
		this.frame = this.svivvel.getChild("frame");
		this.lights1 = this.frame.getChild("lights1");
		this.crystal = this.frame.getChild("crystal");
		this.lense = this.frame.getChild("lense");
		this.mainBeam = this.svivvel.getChild("main beam");
		this.main_beam2 = this.svivvel.getChild("main_beam2");
		this.laserPumps = this.base.getChild("laser pumps");
		this.beams = this.laserPumps.getChild("beams");
		this.beam4 = this.beams.getChild("beam4");
		this.beam6 = this.beams.getChild("beam6");
		this.beams4 = this.laserPumps.getChild("beams4");
		this.beam8 = this.beams4.getChild("beam8");
		this.beam9 = this.beams4.getChild("beam9");
		this.beams2 = this.laserPumps.getChild("beams2");
		this.beam2 = this.beams2.getChild("beam2");
		this.beam3 = this.beams2.getChild("beam3");
		this.beams3 = this.laserPumps.getChild("beams3");
		this.beam5 = this.beams3.getChild("beam5");
		this.beam7 = this.beams3.getChild("beam7");
		this.laser1 = this.laserPumps.getChild("laser1");
		this.laser2 = this.laserPumps.getChild("laser2");
		this.center = root.getChild("center");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition laser = partdefinition.addOrReplaceChild("laser", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 63).addBox(-7.5F, -0.75F, 0.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-7.5F, -0.75F, -1.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-1.5F, -0.75F, -7.5F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(32, 16).addBox(0.5F, -0.75F, -7.5F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(78, 95).addBox(2.1185F, -1.3923F, -1.0176F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = base.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(96, 9).addBox(2.1185F, 0.9874F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.3797F, -0.0176F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r2 = base.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(96, 3).addBox(2.1185F, 0.9874F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.3797F, -0.0176F, -3.1416F, -0.7854F, 3.1416F));

		PartDefinition cube_r3 = base.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(96, 0).addBox(2.1185F, 0.9874F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.3797F, -0.0176F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = base.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(88, 101).addBox(0.5F, -6.8708F, 3.2493F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(84, 101).addBox(0.5F, -6.8708F, 3.0993F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(76, 101).addBox(-1.5F, -6.8708F, 3.2493F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 101).addBox(-1.5F, -6.8708F, 3.0993F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2487F, 0.0F, 0.0F, 1.5708F, 1.0472F));

		PartDefinition cube_r5 = base.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(64, 101).addBox(0.5F, -6.8708F, 3.0993F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 101).addBox(-1.5F, -6.8708F, 3.0993F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(52, 101).addBox(-1.5F, -6.8708F, 3.2493F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 101).addBox(0.5F, -6.8708F, 3.2493F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2487F, 0.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r6 = base.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(44, 101).addBox(0.5F, -6.8708F, -4.0993F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 101).addBox(0.5F, -6.8708F, -4.2493F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 101).addBox(-1.5F, -6.8708F, -4.0993F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 101).addBox(-1.5F, -6.8708F, -4.2493F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2487F, 0.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r7 = base.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(4, 101).addBox(0.5F, -6.8708F, -4.2493F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 101).addBox(0.5F, -6.8708F, -4.0993F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 98).addBox(-1.5F, -6.8708F, -4.2493F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 96).addBox(-1.5F, -6.8708F, -4.0993F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2487F, 0.0F, 0.0F, 1.5708F, -1.0472F));

		PartDefinition cube_r8 = base.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(96, 100).addBox(0.5F, -0.5F, -0.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(92, 100).addBox(-1.5F, -0.5F, -0.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 82).addBox(-1.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 78).addBox(0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1739F, -0.317F, 5.1739F, -1.0472F, -0.7854F, 0.0F));

		PartDefinition cube_r9 = base.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(72, 100).addBox(-1.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 69).addBox(-1.5F, -0.5F, -0.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 65).addBox(0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 63).addBox(0.5F, -0.5F, -0.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1739F, -0.317F, 5.1739F, -1.0472F, 0.7854F, 0.0F));

		PartDefinition cube_r10 = base.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(100, 61).addBox(0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 50).addBox(-1.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 45).addBox(-1.5F, -0.5F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 43).addBox(0.5F, -0.5F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1739F, -0.317F, -5.1739F, 1.0472F, 0.7854F, 0.0F));

		PartDefinition cube_r11 = base.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(100, 35).addBox(0.5F, -0.5F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 33).addBox(0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 31).addBox(-1.5F, -0.5F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 29).addBox(-1.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1739F, -0.317F, -5.1739F, 1.0472F, -0.7854F, 0.0F));

		PartDefinition cube_r12 = base.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(32, 32).addBox(0.5F, -0.25F, -7.5F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-1.5F, -0.25F, -7.5F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(64, 2).addBox(-7.5F, -0.25F, 0.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 63).addBox(-7.5F, -0.25F, -1.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition lense2 = base.addOrReplaceChild("lense2", CubeListBuilder.create().texOffs(88, 60).addBox(2.0F, -0.4769F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(88, 64).addBox(-3.0F, -0.4769F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.7731F, 0.0F));

		PartDefinition cube_r13 = lense2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(68, 95).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5858F, 0.0231F, -2.2071F, 0.0F, 2.3562F, 0.0F));

		PartDefinition cube_r14 = lense2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(16, 102).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.0231F, -2.2929F, 0.0F, 2.3562F, 0.0F));

		PartDefinition cube_r15 = lense2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(102, 14).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0231F, -2.2929F, 0.0F, -2.3562F, 0.0F));

		PartDefinition cube_r16 = lense2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(62, 95).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5858F, 0.0231F, -2.2071F, 0.0F, -2.3562F, 0.0F));

		PartDefinition cube_r17 = lense2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(102, 12).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.0231F, 2.2929F, 0.0F, -2.3562F, 0.0F));

		PartDefinition cube_r18 = lense2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(56, 95).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5858F, 0.0231F, 2.2071F, 0.0F, -2.3562F, 0.0F));

		PartDefinition cube_r19 = lense2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(86, 94).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5858F, 0.0231F, 2.2071F, 0.0F, 2.3562F, 0.0F));

		PartDefinition cube_r20 = lense2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(102, 10).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0231F, 2.2929F, 0.0F, 2.3562F, 0.0F));

		PartDefinition cube_r21 = lense2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(60, 88).addBox(2.0F, -13.0F, -2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(88, 56).addBox(-3.0F, -13.0F, -2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 12.5231F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r22 = lense2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(70, 30).addBox(-1.9824F, 1.4086F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.6855F, -0.0176F, 0.0F, -1.5708F, 0.0F));

		PartDefinition lights2 = base.addOrReplaceChild("lights2", CubeListBuilder.create().texOffs(0, 48).addBox(-0.5F, -0.15F, -7.5F, 1.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(64, 4).addBox(-7.5F, -0.15F, -0.5F, 15.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition cube_r23 = lights2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(64, 5).addBox(-7.5F, -0.15F, -0.5F, 15.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 48).addBox(-0.5F, -0.15F, -7.5F, 1.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r24 = lights2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(80, 101).addBox(-0.5F, -6.7708F, 3.1993F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2513F, 0.0F, 0.0F, 1.5708F, 1.0472F));

		PartDefinition cube_r25 = lights2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(100, 67).addBox(-0.5F, -0.4F, -0.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1739F, 0.183F, 5.1739F, -1.0472F, 0.7854F, 0.0F));

		PartDefinition cube_r26 = lights2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(60, 101).addBox(-0.5F, -6.7708F, 3.1993F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2513F, 0.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r27 = lights2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(100, 80).addBox(-0.5F, -0.4F, -0.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1739F, 0.183F, 5.1739F, -1.0472F, -0.7854F, 0.0F));

		PartDefinition cube_r28 = lights2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(100, 100).addBox(-0.5F, -6.7708F, -4.1993F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2513F, 0.0F, 0.0F, 1.5708F, -1.0472F));

		PartDefinition cube_r29 = lights2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(100, 52).addBox(-0.5F, -0.4F, -0.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1739F, 0.183F, -5.1739F, 1.0472F, 0.7854F, 0.0F));

		PartDefinition cube_r30 = lights2.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(28, 101).addBox(-0.5F, -6.7708F, -4.1993F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2513F, 0.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r31 = lights2.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(100, 37).addBox(-0.5F, -0.4F, -0.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1739F, 0.183F, -5.1739F, 1.0472F, -0.7854F, 0.0F));

		PartDefinition svivvel = base.addOrReplaceChild("svivvel", CubeListBuilder.create().texOffs(70, 12).addBox(4.4999F, -0.0836F, -2.4989F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(70, 18).addBox(-6.5001F, -0.0836F, -2.4989F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0001F, -0.9164F, -0.0011F));

		PartDefinition cube_r32 = svivvel.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(14, 69).addBox(-6.5F, -0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(70, 34).addBox(4.5F, -0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0001F, 0.4164F, 0.0011F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r33 = svivvel.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(70, 24).addBox(4.5F, -0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(70, 6).addBox(-6.5F, -0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0001F, 0.4164F, 0.0011F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r34 = svivvel.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(70, 46).addBox(4.5F, -0.6565F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0001F, 0.5728F, 0.0011F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r35 = svivvel.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(70, 40).addBox(4.5F, -0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(46, 65).addBox(-6.5F, -0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0001F, 0.4164F, 0.0011F, 0.0F, 0.7854F, 0.0F));

		PartDefinition frame = svivvel.addOrReplaceChild("frame", CubeListBuilder.create(), PartPose.offset(0.001F, -3.3312F, -0.0091F));

		PartDefinition cube_r36 = frame.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(88, 70).addBox(-3.0F, 6.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2407F, -14.2306F, -1.9387F, -0.2921F, 0.7401F, -0.4194F));

		PartDefinition cube_r37 = frame.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(88, 68).addBox(0.0F, 6.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.243F, -14.2306F, -1.9387F, -0.2921F, -0.7401F, 0.4194F));

		PartDefinition cube_r38 = frame.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(40, 81).addBox(-3.0F, 6.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2407F, -14.2306F, 1.9592F, 0.2921F, -0.7401F, -0.4194F));

		PartDefinition cube_r39 = frame.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(30, 79).addBox(0.0F, 6.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.243F, -14.2306F, 1.9592F, 0.2921F, 0.7401F, 0.4194F));

		PartDefinition cube_r40 = frame.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(24, 102).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4756F, -9.2448F, 3.4696F, 0.6863F, 0.4176F, 1.1111F));

		PartDefinition cube_r41 = frame.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(100, 27).addBox(0.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.1651F, -1.0881F, 6.1592F, -0.0869F, 0.7816F, -0.1231F));

		PartDefinition cube_r42 = frame.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(100, 20).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1629F, -1.0881F, 6.1592F, -0.0869F, -0.7816F, 0.1231F));

		PartDefinition cube_r43 = frame.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(102, 22).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4733F, -9.2448F, 3.4696F, 0.6863F, -0.4176F, -1.1111F));

		PartDefinition cube_r44 = frame.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(100, 18).addBox(0.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.1651F, -1.0881F, -6.1387F, 0.0869F, -0.7816F, -0.1231F));

		PartDefinition cube_r45 = frame.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(20, 102).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4756F, -9.2448F, -3.4492F, -0.6863F, -0.4176F, 1.1111F));

		PartDefinition cube_r46 = frame.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(100, 6).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1629F, -1.0881F, -6.1387F, 0.0869F, 0.7816F, 0.1231F));

		PartDefinition cube_r47 = frame.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(102, 16).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4733F, -9.2448F, -3.4492F, -0.6863F, 0.4176F, -1.1111F));

		PartDefinition cube_r48 = frame.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(98, 84).addBox(-0.95F, 12.25F, -0.45F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 97).addBox(-0.95F, -0.25F, -0.45F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 54).addBox(-1.0F, 0.0F, -0.95F, 1.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.221F, -11.7524F, -2.2676F, -0.3999F, 0.6956F, -0.583F));

		PartDefinition cube_r49 = frame.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(96, 50).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5469F, 1.1413F, -6.5227F, 0.6537F, 0.4718F, 1.0353F));

		PartDefinition cube_r50 = frame.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(96, 35).addBox(0.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5491F, 1.1413F, -6.5227F, 0.6537F, -0.4718F, -1.0353F));

		PartDefinition cube_r51 = frame.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(78, 98).addBox(-0.05F, 12.25F, -0.45F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(84, 97).addBox(-0.05F, -0.25F, -0.45F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 6).addBox(0.0F, 0.0F, -0.95F, 1.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2233F, -11.7524F, -2.2676F, -0.3999F, -0.6956F, 0.583F));

		PartDefinition cube_r52 = frame.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(96, 30).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5469F, 1.1413F, 6.5432F, -0.6537F, -0.4718F, 1.0353F));

		PartDefinition cube_r53 = frame.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(98, 75).addBox(-0.95F, 12.25F, -0.55F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(88, 97).addBox(-0.95F, -0.25F, -0.55F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 38).addBox(-1.0F, 0.0F, -1.05F, 1.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.221F, -11.7524F, 2.2881F, 0.3999F, -0.6956F, -0.583F));

		PartDefinition cube_r54 = frame.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(96, 18).addBox(0.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5491F, 1.1413F, 6.5432F, -0.6537F, 0.4718F, -1.0353F));

		PartDefinition cube_r55 = frame.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(98, 23).addBox(-0.05F, -0.25F, -0.55F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 72).addBox(-0.05F, 12.25F, -0.55F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 22).addBox(0.0F, 0.0F, -1.05F, 1.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2233F, -11.7524F, 2.2881F, 0.3999F, 0.6956F, 0.583F));

		PartDefinition cube_r56 = frame.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(92, 90).addBox(0.8388F, 1.6014F, -0.9893F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0011F, -11.5994F, 0.0102F, -1.5708F, 0.5672F, -1.5708F));

		PartDefinition cube_r57 = frame.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(92, 87).addBox(-1.8388F, 1.6014F, -0.9893F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0011F, -11.5994F, 0.0102F, 0.0F, 0.0F, 1.0036F));

		PartDefinition cube_r58 = frame.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(80, 92).addBox(-1.8388F, 1.6014F, -1.0107F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0011F, -11.5994F, 0.0102F, 1.5708F, 0.5672F, 1.5708F));

		PartDefinition cube_r59 = frame.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(94, 6).addBox(-3.0986F, -0.8421F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0011F, -11.322F, -0.0004F, -1.5708F, 1.4399F, -1.5708F));

		PartDefinition cube_r60 = frame.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(92, 93).addBox(2.0986F, -0.8421F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0011F, -11.322F, -0.0004F, 1.5708F, 1.4399F, 1.5708F));

		PartDefinition cube_r61 = frame.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(96, 15).addBox(0.0F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1831F, -11.7524F, -0.0004F, 0.0F, 0.0F, -0.1309F));

		PartDefinition cube_r62 = frame.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(96, 12).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1808F, -11.7524F, -0.0004F, 0.0F, 0.0F, 0.1309F));

		PartDefinition cube_r63 = frame.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(92, 75).addBox(0.8388F, 1.6014F, -1.0107F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0011F, -11.5994F, 0.0102F, 0.0F, 0.0F, -1.0036F));

		PartDefinition cube_r64 = frame.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(92, 72).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7705F, -11.5994F, -1.7441F, -0.7006F, -0.3897F, 1.1475F));

		PartDefinition cube_r65 = frame.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(62, 92).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7682F, -11.5994F, -1.7441F, -0.7006F, 0.3897F, -1.1475F));

		PartDefinition cube_r66 = frame.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(56, 92).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7682F, -11.5994F, 1.7645F, 0.7006F, -0.3897F, -1.1475F));

		PartDefinition cube_r67 = frame.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(92, 47).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7705F, -11.5994F, 1.7645F, 0.7006F, 0.3897F, 1.1475F));

		PartDefinition cube_r68 = frame.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(70, 65).addBox(0.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4424F, 0.9359F, -6.4159F, -0.5942F, -0.5484F, 0.9136F));

		PartDefinition cube_r69 = frame.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(70, 62).addBox(-5.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4401F, 0.9359F, -6.4159F, -0.5942F, 0.5484F, -0.9136F));

		PartDefinition cube_r70 = frame.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(60, 70).addBox(0.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4424F, 0.9359F, 6.4364F, 0.5942F, 0.5484F, 0.9136F));

		PartDefinition cube_r71 = frame.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(28, 71).addBox(-5.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4401F, 0.9359F, 6.4364F, 0.5942F, -0.5484F, -0.9136F));

		PartDefinition lights1 = frame.addOrReplaceChild("lights1", CubeListBuilder.create(), PartPose.offset(-2.2233F, -11.7524F, -2.2676F));

		PartDefinition cube_r72 = lights1.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(24, 84).addBox(-0.3F, 3.0F, -0.45F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3999F, -0.6956F, 0.583F));

		PartDefinition cube_r73 = lights1.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(84, 62).addBox(-0.3F, 3.0F, -0.55F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.5556F, 0.3999F, 0.6956F, 0.583F));

		PartDefinition cube_r74 = lights1.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(20, 84).addBox(-0.7F, 3.0F, -0.45F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4444F, 0.0F, 0.0F, -0.3999F, 0.6956F, -0.583F));

		PartDefinition cube_r75 = lights1.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(84, 34).addBox(-0.7F, 3.0F, -0.55F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4444F, 0.0F, 4.5556F, 0.3999F, -0.6956F, -0.583F));

		PartDefinition crystal = frame.addOrReplaceChild("crystal", CubeListBuilder.create().texOffs(70, 52).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(84, 27).addBox(-1.5F, -9.5F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(80, 83).addBox(-1.0F, -9.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(84, 44).addBox(-1.5F, -3.6F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(84, 6).addBox(-1.0F, -3.6F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(96, 61).addBox(-0.25F, -9.0F, 0.4F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 88).addBox(-0.55F, -9.5F, 0.2F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(52, 92).addBox(0.25F, -9.3F, -0.6F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 96).addBox(-0.55F, -6.5F, -1.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 97).addBox(-1.35F, -8.3F, -1.1F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 97).addBox(-1.05F, -5.6F, -0.8F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 97).addBox(-0.3F, -5.6F, -0.8F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 65).addBox(-1.25F, -8.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 85).addBox(-0.95F, -9.0F, -1.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 65).addBox(0.05F, -8.0F, -1.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 69).addBox(0.3F, -6.0F, -0.8F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 94).addBox(0.2F, -9.0F, -0.2F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 88).addBox(0.2F, -9.0F, -0.2F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(92, 96).addBox(-0.1F, -7.0F, 0.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0011F, 1.7476F, 0.0102F));

		PartDefinition cube_r76 = crystal.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(90, 85).addBox(-1.5F, 5.3F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(88, 52).addBox(-0.5F, 5.3F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(52, 88).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(52, 71).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.9F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition lense = frame.addOrReplaceChild("lense", CubeListBuilder.create().texOffs(20, 75).addBox(2.0F, -13.0F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(88, 40).addBox(-3.0F, -13.0F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0011F, 1.2476F, 0.0102F));

		PartDefinition cube_r77 = lense.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(94, 81).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5858F, -12.5F, -2.2071F, 0.0F, 2.3562F, 0.0F));

		PartDefinition cube_r78 = lense.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(102, 8).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -12.5F, -2.2929F, 0.0F, 2.3562F, 0.0F));

		PartDefinition cube_r79 = lense.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(102, 4).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -12.5F, -2.2929F, 0.0F, -2.3562F, 0.0F));

		PartDefinition cube_r80 = lense.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(94, 78).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5858F, -12.5F, -2.2071F, 0.0F, -2.3562F, 0.0F));

		PartDefinition cube_r81 = lense.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(102, 2).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -12.5F, 2.2929F, 0.0F, -2.3562F, 0.0F));

		PartDefinition cube_r82 = lense.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(94, 44).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5858F, -12.5F, 2.2071F, 0.0F, -2.3562F, 0.0F));

		PartDefinition cube_r83 = lense.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(94, 27).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5858F, -12.5F, 2.2071F, 0.0F, 2.3562F, 0.0F));

		PartDefinition cube_r84 = lense.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(102, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -12.5F, 2.2929F, 0.0F, 2.3562F, 0.0F));

		PartDefinition cube_r85 = lense.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(44, 88).addBox(2.0F, -13.0F, -2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(36, 88).addBox(-3.0F, -13.0F, -2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r86 = lense.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(16, 65).addBox(-2.0F, -12.3F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 65).addBox(-2.0F, -12.75F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition mainBeam = svivvel.addOrReplaceChild("main beam", CubeListBuilder.create().texOffs(84, 10).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0001F, -10.0836F, 0.0011F));

		PartDefinition cube_r87 = mainBeam.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(84, 16).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition main_beam2 = svivvel.addOrReplaceChild("main_beam2", CubeListBuilder.create().texOffs(24, 94).addBox(-0.5F, -5.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0001F, 0.9164F, 0.0011F));

		PartDefinition cube_r88 = main_beam2.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(74, 95).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7418F, 0.0F));

		PartDefinition laserPumps = base.addOrReplaceChild("laser pumps", CubeListBuilder.create(), PartPose.offset(0.0F, -5.7385F, -0.0029F));

		PartDefinition beams = laserPumps.addOrReplaceChild("beams", CubeListBuilder.create(), PartPose.offset(0.0F, -0.8157F, -0.0147F));

		PartDefinition beam4 = beams.addOrReplaceChild("beam4", CubeListBuilder.create().texOffs(0, 90).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7348F, 2.1213F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r89 = beam4.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(88, 87).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition beam6 = beams.addOrReplaceChild("beam6", CubeListBuilder.create().texOffs(4, 90).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7348F, 2.1213F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r90 = beam6.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(76, 88).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition beams4 = laserPumps.addOrReplaceChild("beams4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.8157F, -0.0147F, 0.0F, 0.7854F, 0.0F));

		PartDefinition beam8 = beams4.addOrReplaceChild("beam8", CubeListBuilder.create().texOffs(36, 92).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7348F, 2.1213F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r91 = beam8.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(40, 92).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition beam9 = beams4.addOrReplaceChild("beam9", CubeListBuilder.create().texOffs(44, 92).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7348F, 2.1213F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r92 = beam9.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(48, 92).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition beams2 = laserPumps.addOrReplaceChild("beams2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.8157F, -0.0147F, 0.0F, 1.5708F, 0.0F));

		PartDefinition beam2 = beams2.addOrReplaceChild("beam2", CubeListBuilder.create().texOffs(8, 90).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7348F, 2.1213F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r93 = beam2.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(12, 90).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition beam3 = beams2.addOrReplaceChild("beam3", CubeListBuilder.create().texOffs(90, 78).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7348F, 2.1213F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r94 = beam3.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(28, 91).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition beams3 = laserPumps.addOrReplaceChild("beams3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.8157F, -0.0147F, 0.0F, 2.3562F, 0.0F));

		PartDefinition beam5 = beams3.addOrReplaceChild("beam5", CubeListBuilder.create().texOffs(32, 91).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7348F, 2.1213F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r95 = beam5.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(92, 10).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition beam7 = beams3.addOrReplaceChild("beam7", CubeListBuilder.create().texOffs(16, 92).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7348F, 2.1213F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r96 = beam7.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(92, 17).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition laser1 = laserPumps.addOrReplaceChild("laser1", CubeListBuilder.create().texOffs(84, 22).addBox(-1.0F, 1.4971F, 3.6278F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(52, 73).addBox(-1.2F, 3.5971F, 0.7278F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(42, 71).addBox(-1.0F, 2.4971F, 0.6278F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(28, 98).addBox(-1.2F, 2.5971F, 4.7278F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 98).addBox(0.2F, 2.5971F, 4.7278F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 73).addBox(0.2F, 3.5971F, 0.7278F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(28, 69).addBox(-0.5F, 1.1971F, 4.1278F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0911F, 3.0244F, -0.0147F, 0.0F, 1.5708F, -0.7854F));

		PartDefinition cube_r97 = laser1.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(48, 99).addBox(-0.5F, 2.598F, 2.598F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.4009F, 1.5298F, -1.4009F, -0.5236F, 2.5261F));

		PartDefinition cube_r98 = laser1.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(92, 50).addBox(-0.5F, 2.598F, 2.598F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.4009F, 1.5298F, -0.1699F, -0.5236F, 0.6155F));

		PartDefinition cube_r99 = laser1.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(38, 74).addBox(-0.5F, 2.598F, 2.598F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.4009F, 1.5298F, -0.7854F, -0.7854F, 1.5708F));

		PartDefinition cube_r100 = laser1.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(68, 98).addBox(-1.2F, 2.2962F, 4.8998F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 83).addBox(-1.0F, 2.1962F, 0.7998F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(82, 73).addBox(-1.2F, 3.2962F, 0.8998F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(88, 30).addBox(-1.0F, 1.1962F, 3.7998F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 98).addBox(0.2F, 2.2962F, 4.8998F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 81).addBox(0.2F, 3.2962F, 0.8998F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3008F, -0.1719F, -0.1699F, -0.5236F, 0.6155F));

		PartDefinition cube_r101 = laser1.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(10, 80).addBox(0.2F, 3.2962F, 0.8998F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(60, 98).addBox(0.2F, 2.2962F, 4.8998F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(80, 87).addBox(-1.0F, 1.1962F, 3.7998F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 80).addBox(-1.2F, 3.2962F, 0.8998F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(20, 79).addBox(-1.0F, 2.1962F, 0.7998F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(56, 98).addBox(-1.2F, 2.2962F, 4.8998F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3008F, -0.1719F, -1.4009F, -0.5236F, 2.5261F));

		PartDefinition cube_r102 = laser1.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(52, 98).addBox(-1.2F, 2.2962F, 4.8998F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(38, 76).addBox(-1.0F, 2.1962F, 0.7998F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(10, 75).addBox(-1.2F, 3.2962F, 0.8998F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 85).addBox(-1.0F, 1.1962F, 3.7998F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(98, 47).addBox(0.2F, 2.2962F, 4.8998F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 75).addBox(0.2F, 3.2962F, 0.8998F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3008F, -0.1719F, -0.7854F, -0.7854F, 1.5708F));

		PartDefinition laser2 = laserPumps.addOrReplaceChild("laser2", CubeListBuilder.create().texOffs(84, 47).addBox(-1.0F, -2.0385F, 0.0923F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(72, 73).addBox(-1.0F, -1.0385F, -2.9077F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(28, 74).addBox(0.2F, 0.0615F, -2.8077F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(20, 99).addBox(0.2F, -0.9385F, 1.1923F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 87).addBox(-1.2F, -0.9385F, 1.1923F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(74, 68).addBox(-1.2F, 0.0615F, -2.8077F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(70, 68).addBox(-0.5F, -2.3385F, 0.5923F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9089F, 3.0244F, -0.0147F, 0.0F, -1.5708F, 0.7854F));

		PartDefinition cube_r103 = laser2.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(70, 83).addBox(-1.0F, 2.1962F, 0.7998F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(88, 35).addBox(-1.0F, 1.1962F, 3.7998F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 99).addBox(-1.2F, 2.2962F, 4.8998F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 99).addBox(0.2F, 2.2962F, 4.8998F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 83).addBox(-1.2F, 3.2962F, 0.8998F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(50, 83).addBox(0.2F, 3.2962F, 0.8998F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.2347F, -3.7075F, -0.1699F, -0.5236F, 0.6155F));

		PartDefinition cube_r104 = laser2.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(96, 58).addBox(-3.1185F, 0.9874F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.2347F, -3.7075F, -0.9553F, 0.5236F, -0.6155F));

		PartDefinition cube_r105 = laser2.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(96, 55).addBox(-3.1185F, 0.9874F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.2347F, -3.7075F, -0.9553F, -0.5236F, 0.6155F));

		PartDefinition cube_r106 = laser2.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(78, 78).addBox(0.2F, 3.2962F, 0.8998F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(68, 78).addBox(-1.2F, 3.2962F, 0.8998F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(36, 99).addBox(0.2F, 2.2962F, 4.8998F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 93).addBox(-1.2F, 2.2962F, 4.8998F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 86).addBox(-1.0F, 1.1962F, 3.7998F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(58, 78).addBox(-1.0F, 2.1962F, 0.7998F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.2347F, -3.7075F, -1.4009F, -0.5236F, 2.5261F));

		PartDefinition cube_r107 = laser2.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(78, 57).addBox(-1.0F, 2.1962F, 0.7998F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 85).addBox(-1.0F, 1.1962F, 3.7998F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(98, 90).addBox(-1.2F, 2.2962F, 4.8998F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 99).addBox(0.2F, 2.2962F, 4.8998F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(78, 52).addBox(-1.2F, 3.2962F, 0.8998F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(48, 78).addBox(0.2F, 3.2962F, 0.8998F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.2347F, -3.7075F, -0.7854F, -0.7854F, 1.5708F));

		PartDefinition cube_r108 = laser2.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(96, 40).addBox(-3.1185F, 0.9874F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.2347F, -3.7075F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r109 = laser2.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(92, 24).addBox(0.0F, -2.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0829F, -3.6148F, -1.5708F, 0.7854F, -1.5708F));

		PartDefinition cube_r110 = laser2.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(44, 99).addBox(-0.5F, 2.598F, 2.598F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.9365F, -2.0057F, -1.4009F, -0.5236F, 2.5261F));

		PartDefinition cube_r111 = laser2.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(36, 86).addBox(-0.5F, 2.598F, 2.598F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.9365F, -2.0057F, -0.1699F, -0.5236F, 0.6155F));

		PartDefinition cube_r112 = laser2.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(48, 76).addBox(-0.5F, 2.598F, 2.598F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.9365F, -2.0057F, -0.7854F, -0.7854F, 1.5708F));

		PartDefinition center = partdefinition.addOrReplaceChild("center", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override
	public void setupAnim(State state) {
		resetPose();
		float spin = state.ticks() * Mth.TWO_PI / 80.0F;
		mainBeam.yRot = spin * 2.0F;
		main_beam2.yRot = spin * 2.0F;
		svivvel.yRot = -spin;
		beam2.yRot = spin;
		beam3.yRot = spin;
		beam4.yRot = spin;
		beam5.yRot = spin;
		beam6.yRot = spin;
		beam7.yRot = spin;
		beam8.yRot = spin;
		beam9.yRot = spin;
	}

	public record State(float ticks) {}
}
