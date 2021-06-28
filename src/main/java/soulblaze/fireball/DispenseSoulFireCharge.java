package soulblaze.fireball;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IDispenseItemBehavior;
import net.minecraft.dispenser.IPosition;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Random;

public class DispenseSoulFireCharge implements IDispenseItemBehavior
{
    @Override
    @Nonnull
    public ItemStack dispense(IBlockSource p_82487_1_, ItemStack p_82487_2_)
    {
        Direction direction = p_82487_1_.getBlockState().getValue(DispenserBlock.FACING);
        IPosition iposition = DispenserBlock.getDispensePosition(p_82487_1_);
        double d0 = iposition.x() + (double) ((float) direction.getStepX() * 0.3F);
        double d1 = iposition.y() + (double) ((float) direction.getStepY() * 0.3F);
        double d2 = iposition.z() + (double) ((float) direction.getStepZ() * 0.3F);
        World world = p_82487_1_.getLevel();
        Random random = world.random;
        double d3 = random.nextGaussian() * 0.05D + (double) direction.getStepX();
        double d4 = random.nextGaussian() * 0.05D + (double) direction.getStepY();
        double d5 = random.nextGaussian() * 0.05D + (double) direction.getStepZ();
        world.addFreshEntity(Util.make(new SmallBlueFireballEntity(world, d0, d1, d2, d3, d4, d5), (p_229425_1_) ->
                p_229425_1_.setItem(p_82487_2_)));
        p_82487_2_.shrink(1);
        return p_82487_2_;
    }

    protected void playSound(IBlockSource p_82485_1_)
    {
        p_82485_1_.getLevel().levelEvent(1018, p_82485_1_.getPos(), 0);
    }
}
