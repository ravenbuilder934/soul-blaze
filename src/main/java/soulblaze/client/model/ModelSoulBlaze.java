
package soulblaze.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelSoulBlaze<T extends Entity> extends EntityModel<T>
{
	private final ModelRenderer head;
	private final ModelRenderer torso;
	private final ModelRenderer torso2;
	private final ModelRenderer torso3;
	private final ModelRenderer torso4;
	private final ModelRenderer spikes;
	private final ModelRenderer spike1;
	private final ModelRenderer top;
	private final ModelRenderer bottom;
	private final ModelRenderer spike2;
	private final ModelRenderer top2;
	private final ModelRenderer bottom2;
	private final ModelRenderer spike3;
	private final ModelRenderer top3;
	private final ModelRenderer bottom3;
	private final ModelRenderer spike4;
	private final ModelRenderer top4;
	private final ModelRenderer bottom4;

	public ModelSoulBlaze()
	{
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(32, 0).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, 0.0F, false);

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, 4.0F, 2.0F);
		head.addChild(torso);
		torso.setTextureOffset(36, 14).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		torso.setTextureOffset(36, 20).addBox(-4.0F, 2.0F, -3.0F, 8.0F, 2.0F, 4.0F, -0.01F, false);

		torso2 = new ModelRenderer(this);
		torso2.setRotationPoint(0.0F, 4.0F, 0.0F);
		torso.addChild(torso2);
		torso2.setTextureOffset(36, 14).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		torso2.setTextureOffset(36, 20).addBox(-4.0F, 2.0F, -3.0F, 8.0F, 2.0F, 4.0F, -0.01F, false);

		torso3 = new ModelRenderer(this);
		torso3.setRotationPoint(0.0F, 4.0F, 0.0F);
		torso2.addChild(torso3);
		torso3.setTextureOffset(36, 14).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		torso4 = new ModelRenderer(this);
		torso4.setRotationPoint(0.0F, 4.0F, 0.0F);
		torso3.addChild(torso4);
		torso4.setTextureOffset(36, 14).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		spikes = new ModelRenderer(this);
		spikes.setRotationPoint(0.0F, 12.0F, 0.0F);
		setRotationAngle(spikes, 0.0F, -0.7854F, 0.0F);
		

		spike1 = new ModelRenderer(this);
		spike1.setRotationPoint(0.0F, 0.0F, 0.0F);
		spikes.addChild(spike1);
		spike1.setTextureOffset(12, 16).addBox(-2.0F, -4.0F, -10.0F, 4.0F, 8.0F, 2.0F, 0.0F, false);

		top = new ModelRenderer(this);
		top.setRotationPoint(0.0F, -4.0F, -10.0F);
		spike1.addChild(top);
		setRotationAngle(top, -0.2618F, 0.0F, 0.0F);
		top.setTextureOffset(0, 16).addBox(-2.0F, -8.0F, 0.0F, 4.0F, 8.0F, 2.0F, -0.01F, false);

		bottom = new ModelRenderer(this);
		bottom.setRotationPoint(0.0F, 4.0F, -10.0F);
		spike1.addChild(bottom);
		setRotationAngle(bottom, 0.2618F, 0.0F, 0.0F);
		bottom.setTextureOffset(24, 16).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 2.0F, -0.01F, false);

		spike2 = new ModelRenderer(this);
		spike2.setRotationPoint(0.0F, 0.0F, 0.0F);
		spikes.addChild(spike2);
		setRotationAngle(spike2, 0.0F, -1.5708F, 0.0F);
		spike2.setTextureOffset(12, 16).addBox(-2.0F, -4.0F, -10.0F, 4.0F, 8.0F, 2.0F, 0.0F, false);

		top2 = new ModelRenderer(this);
		top2.setRotationPoint(0.0F, -4.0F, -10.0F);
		spike2.addChild(top2);
		setRotationAngle(top2, -0.2618F, 0.0F, 0.0F);
		top2.setTextureOffset(0, 16).addBox(-2.0F, -8.0F, 0.0F, 4.0F, 8.0F, 2.0F, -0.01F, false);

		bottom2 = new ModelRenderer(this);
		bottom2.setRotationPoint(0.0F, 4.0F, -10.0F);
		spike2.addChild(bottom2);
		setRotationAngle(bottom2, 0.2618F, 0.0F, 0.0F);
		bottom2.setTextureOffset(24, 16).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 2.0F, -0.01F, false);

		spike3 = new ModelRenderer(this);
		spike3.setRotationPoint(0.0F, 0.0F, 0.0F);
		spikes.addChild(spike3);
		setRotationAngle(spike3, 0.0F, 3.1416F, 0.0F);
		spike3.setTextureOffset(12, 16).addBox(-2.0F, -4.0F, -10.0F, 4.0F, 8.0F, 2.0F, 0.0F, false);

		top3 = new ModelRenderer(this);
		top3.setRotationPoint(0.0F, -4.0F, -10.0F);
		spike3.addChild(top3);
		setRotationAngle(top3, -0.2618F, 0.0F, 0.0F);
		top3.setTextureOffset(0, 16).addBox(-2.0F, -8.0F, 0.0F, 4.0F, 8.0F, 2.0F, -0.01F, false);

		bottom3 = new ModelRenderer(this);
		bottom3.setRotationPoint(0.0F, 4.0F, -10.0F);
		spike3.addChild(bottom3);
		setRotationAngle(bottom3, 0.2618F, 0.0F, 0.0F);
		bottom3.setTextureOffset(24, 16).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 2.0F, -0.01F, false);

		spike4 = new ModelRenderer(this);
		spike4.setRotationPoint(0.0F, 0.0F, 0.0F);
		spikes.addChild(spike4);
		setRotationAngle(spike4, 0.0F, 1.5708F, 0.0F);
		spike4.setTextureOffset(12, 16).addBox(-2.0F, -4.0F, -10.0F, 4.0F, 8.0F, 2.0F, 0.0F, false);

		top4 = new ModelRenderer(this);
		top4.setRotationPoint(0.0F, -4.0F, -10.0F);
		spike4.addChild(top4);
		setRotationAngle(top4, -0.2618F, 0.0F, 0.0F);
		top4.setTextureOffset(0, 16).addBox(-2.0F, -8.0F, 0.0F, 4.0F, 8.0F, 2.0F, -0.01F, false);

		bottom4 = new ModelRenderer(this);
		bottom4.setRotationPoint(0.0F, 4.0F, -10.0F);
		spike4.addChild(bottom4);
		setRotationAngle(bottom4, 0.2618F, 0.0F, 0.0F);
		bottom4.setTextureOffset(24, 16).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 2.0F, -0.01F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		spikes.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}