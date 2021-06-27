package soulblaze.client;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import soulblaze.entity.SoulBlazeEntity;

@OnlyIn(Dist.CLIENT)
public class RenderSoulBlaze extends MobRenderer<SoulBlazeEntity, ModelSoulBlaze<SoulBlazeEntity>>
{
    private static final ResourceLocation SOUL_BLAZE_TEXTURES = new ResourceLocation("soulblaze:textures/entity/soulblaze.png");

    public RenderSoulBlaze(EntityRendererManager renderManagerIn)
    {
        super(renderManagerIn, new ModelSoulBlaze<>(), 0.5F);
    }

    protected int getBlockLightLevel(SoulBlazeEntity entityIn, BlockPos partialTicks)
    {
        return 15;
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(SoulBlazeEntity entity)
    {
        return SOUL_BLAZE_TEXTURES;
    }
}
