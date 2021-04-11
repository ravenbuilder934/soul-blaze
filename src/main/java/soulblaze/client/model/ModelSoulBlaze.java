package soulblaze.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Arrays;

@OnlyIn(Dist.CLIENT)
public class ModelSoulBlaze<T extends Entity> extends SegmentedModel<T>
{
	private final ModelRenderer[] soulblazeSticks;
	private final ModelRenderer soulblazeHead = new ModelRenderer(this, 0, 0);
	private final ImmutableList<ModelRenderer> field_228242_f_;

	public ModelSoulBlaze() {
		this.soulblazeHead.addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F);
		this.soulblazeSticks = new ModelRenderer[12];

		for(int i = 0; i < this.soulblazeSticks.length; ++i) {
			this.soulblazeSticks[i] = new ModelRenderer(this, 0, 16);
			this.soulblazeSticks[i].addBox(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F);
		}

		Builder<ModelRenderer> builder = ImmutableList.builder();
		builder.add(this.soulblazeHead);
		builder.addAll(Arrays.asList(this.soulblazeSticks));
		this.field_228242_f_ = builder.build();
	}

	public Iterable<ModelRenderer> getParts() {
		return this.field_228242_f_;
	}

	/**
	 * Sets this entity's model rotation angles
	 */
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = ageInTicks * (float)Math.PI * -0.1F;

		for(int i = 0; i < 4; ++i) {
			this.soulblazeSticks[i].rotationPointY = -2.0F + MathHelper.cos(((float)(i * 2) + ageInTicks) * 0.25F);
			this.soulblazeSticks[i].rotationPointX = MathHelper.cos(f) * 9.0F;
			this.soulblazeSticks[i].rotationPointZ = MathHelper.sin(f) * 9.0F;
			++f;
		}

		f = ((float)Math.PI / 4F) + ageInTicks * (float)Math.PI * 0.03F;

		for(int j = 4; j < 8; ++j) {
			this.soulblazeSticks[j].rotationPointY = 2.0F + MathHelper.cos(((float)(j * 2) + ageInTicks) * 0.25F);
			this.soulblazeSticks[j].rotationPointX = MathHelper.cos(f) * 7.0F;
			this.soulblazeSticks[j].rotationPointZ = MathHelper.sin(f) * 7.0F;
			++f;
		}

		f = 0.47123894F + ageInTicks * (float)Math.PI * -0.05F;

		for(int k = 8; k < 12; ++k) {
			this.soulblazeSticks[k].rotationPointY = 11.0F + MathHelper.cos(((float)k * 1.5F + ageInTicks) * 0.5F);
			this.soulblazeSticks[k].rotationPointX = MathHelper.cos(f) * 5.0F;
			this.soulblazeSticks[k].rotationPointZ = MathHelper.sin(f) * 5.0F;
			++f;
		}

		this.soulblazeHead.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.soulblazeHead.rotateAngleX = headPitch * ((float)Math.PI / 180F);
	}
}
