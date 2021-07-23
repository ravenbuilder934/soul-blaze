package soulblaze.brewing;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import soulblaze.item.ModItems;

public class StrengthPotionBrewingRecipe implements IBrewingRecipe
{
    @Override
    public boolean isInput(ItemStack input)
    {
        return input.getItem() == Items.POTION && PotionUtils.getPotion(input) == Potions.AWKWARD;
    }

    @Override
    public boolean isIngredient(ItemStack ingredient)
    {
        return ingredient.getItem() == ModItems.SOUL_BLAZE_POWDER.get();
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient)
    {
        if (!input.isEmpty() && !ingredient.isEmpty() && isIngredient(ingredient) && isInput(input))
        {
            return PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRENGTH);
        }
        return ItemStack.EMPTY;
    }
}
