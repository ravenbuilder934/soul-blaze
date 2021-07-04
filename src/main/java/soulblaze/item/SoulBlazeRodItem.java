package soulblaze.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SoulBlazeRodItem extends Item
{
    public SoulBlazeRodItem(Item.Properties properties)
    {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        return 2400;
    }
}
