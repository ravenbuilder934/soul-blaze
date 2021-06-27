package soulblaze.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import soulblaze.fireball.SmallBlueFireballEntity;

import java.util.EnumSet;

public class SoulBlazeEntity extends BlazeEntity
{
    private static final DataParameter<Byte> DATA_FLAGS_ID = EntityDataManager.defineId(SoulBlazeEntity.class, DataSerializers.BYTE);

    public SoulBlazeEntity(EntityType<? extends SoulBlazeEntity> p_i50215_1_, World p_i50215_2_)
    {
        super(p_i50215_1_, p_i50215_2_);
        this.setPathfindingMalus(PathNodeType.WATER, -1.0F);
        this.setPathfindingMalus(PathNodeType.LAVA, 8.0F);
        this.setPathfindingMalus(PathNodeType.DANGER_FIRE, 0.0F);
        this.setPathfindingMalus(PathNodeType.DAMAGE_FIRE, 0.0F);
        this.xpReward = 10;
    }

    public static AttributeModifierMap.MutableAttribute createAttributes()
    {
        return MonsterEntity.createMonsterAttributes().add(Attributes.ATTACK_DAMAGE, 6.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.23F).add(Attributes.FOLLOW_RANGE, 48.0D);
    }

    protected void registerGoals()
    {
        this.goalSelector.addGoal(4, new SoulBlazeEntity.BlueFireballAttackGoal(this));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 0.0F));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    protected void defineSynchedData()
    {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte) 0);
    }

    private void setCharged(boolean p_70844_1_)
    {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (p_70844_1_)
        {
            b0 = (byte) (b0 | 1);
        }
        else
        {
            b0 = (byte) (b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    static class BlueFireballAttackGoal extends Goal
    {
        private final SoulBlazeEntity soulblaze;
        private int attackStep;
        private int attackTime;
        private int lastSeen;

        public BlueFireballAttackGoal(SoulBlazeEntity p_i45846_1_)
        {
            this.soulblaze = p_i45846_1_;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse()
        {
            LivingEntity livingentity = this.soulblaze.getTarget();
            return livingentity != null && livingentity.isAlive() && this.soulblaze.canAttack(livingentity);
        }

        public void start()
        {
            this.attackStep = 0;
        }

        public void stop()
        {
            this.soulblaze.setCharged(false);
            this.lastSeen = 0;
        }

        public void tick()
        {
            --this.attackTime;
            LivingEntity livingentity = this.soulblaze.getTarget();
            if (livingentity != null)
            {
                boolean flag = this.soulblaze.getSensing().canSee(livingentity);
                if (flag)
                {
                    this.lastSeen = 0;
                }
                else
                {
                    ++this.lastSeen;
                }

                double d0 = this.soulblaze.distanceToSqr(livingentity);
                if (d0 < 4.0D)
                {
                    if (!flag)
                    {
                        return;
                    }

                    if (this.attackTime <= 0)
                    {
                        this.attackTime = 20;
                        this.soulblaze.doHurtTarget(livingentity);
                    }

                    this.soulblaze.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
                }
                else if (d0 < this.getFollowDistance() * this.getFollowDistance() && flag)
                {
                    double d1 = livingentity.getX() - this.soulblaze.getX();
                    double d2 = livingentity.getY(0.5D) - this.soulblaze.getY(0.5D);
                    double d3 = livingentity.getZ() - this.soulblaze.getZ();
                    if (this.attackTime <= 0)
                    {
                        ++this.attackStep;
                        if (this.attackStep == 1)
                        {
                            this.attackTime = 60;
                            this.soulblaze.setCharged(true);
                        }
                        else if (this.attackStep <= 4)
                        {
                            this.attackTime = 6;
                        }
                        else
                        {
                            this.attackTime = 100;
                            this.attackStep = 0;
                            this.soulblaze.setCharged(false);
                        }

                        if (this.attackStep > 1)
                        {
                            float f = MathHelper.sqrt(MathHelper.sqrt(d0)) * 0.5F;
                            if (!this.soulblaze.isSilent())
                            {
                                this.soulblaze.level.levelEvent((PlayerEntity) null, 1018, this.soulblaze.blockPosition(), 0);
                            }

                            for (int i = 0; i < 1; ++i)
                            {
                                SmallBlueFireballEntity smallbluefireballentity = new SmallBlueFireballEntity(this.soulblaze.level, this.soulblaze, d1 + this.soulblaze.getRandom().nextGaussian() * (double) f, d2, d3 + this.soulblaze.getRandom().nextGaussian() * (double) f);
                                smallbluefireballentity.setPos(smallbluefireballentity.getX(), this.soulblaze.getY(0.5D) + 0.5D, smallbluefireballentity.getZ());
                                this.soulblaze.level.addFreshEntity(smallbluefireballentity);
                            }
                        }
                    }

                    this.soulblaze.getLookControl().setLookAt(livingentity, 10.0F, 10.0F);
                }
                else if (this.lastSeen < 5)
                {
                    this.soulblaze.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
                }

                super.tick();
            }
        }

        private double getFollowDistance()
        {
            return this.soulblaze.getAttributeValue(Attributes.FOLLOW_RANGE);
        }
    }
}
