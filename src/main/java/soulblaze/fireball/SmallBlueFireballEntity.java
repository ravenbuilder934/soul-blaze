package soulblaze.fireball;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.entity.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.*;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import soulblaze.entity.ModEntities;

public class SmallBlueFireballEntity extends AbstractBlueFireballEntity
{
    public SmallBlueFireballEntity(EntityType<? extends SmallBlueFireballEntity> p_i50160_1_, World p_i50160_2_)
    {
        super(p_i50160_1_, p_i50160_2_);
    }

    public SmallBlueFireballEntity(World p_i1771_1_, LivingEntity p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_)
    {
        super(ModEntities.SMALL_BLUE_FIREBALL, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_, p_i1771_1_);
    }

    public SmallBlueFireballEntity(World p_i1772_1_, double p_i1772_2_, double p_i1772_4_, double p_i1772_6_, double p_i1772_8_, double p_i1772_10_, double p_i1772_12_)
    {
        super(ModEntities.SMALL_BLUE_FIREBALL, p_i1772_2_, p_i1772_4_, p_i1772_6_, p_i1772_8_, p_i1772_10_, p_i1772_12_, p_i1772_1_);
    }

    protected void onHitEntity(EntityRayTraceResult p_213868_1_)
    {
        super.onHitEntity(p_213868_1_);
        if (!this.level.isClientSide)
        {
            Entity entity = p_213868_1_.getEntity();
            if (!entity.fireImmune())
            {
                Entity entity1 = this.getOwner();
                int i = entity.getRemainingFireTicks();
                entity.setSecondsOnFire(5);
                boolean flag = entity.hurt(DamageSource.fireball(this, entity1), 5.0F);
                if (!flag)
                {
                    entity.setRemainingFireTicks(i);
                }
                else if (entity1 instanceof LivingEntity)
                {
                    this.doEnchantDamageEffects((LivingEntity) entity1, entity);
                }
            }
        }
    }

    protected void onHitBlock(BlockRayTraceResult p_230299_1_)
    {
        super.onHitBlock(p_230299_1_);
        if (!this.level.isClientSide)
        {
            Entity entity = this.getOwner();
            if (entity == null || !(entity instanceof MobEntity) || this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) || net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this.getEntity()))
            {
                BlockPos blockpos = p_230299_1_.getBlockPos().relative(p_230299_1_.getDirection());
                if (this.level.isEmptyBlock(blockpos))
                {
                    this.level.setBlockAndUpdate(blockpos, AbstractFireBlock.getState(this.level, blockpos));
                }
            }
        }
    }

    protected void onHit(RayTraceResult p_70227_1_)
    {
        super.onHit(p_70227_1_);
        if (!this.level.isClientSide)
        {
            this.remove();
        }
    }

    public boolean isPickable()
    {
        return false;
    }

    public boolean hurt(DamageSource p_70097_1_, float p_70097_2_)
    {
        return false;
    }
}
