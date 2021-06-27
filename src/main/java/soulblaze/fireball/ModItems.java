package soulblaze.fireball;

import net.minecraft.item.FireChargeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import soulblaze.SoulBlaze;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SoulBlaze.MOD_ID);

    public static final RegistryObject<FireChargeItem> BLUE_FIRE_CHARGE = ITEMS.register("blue_fire_charge", () -> new FireChargeItem((new Item.Properties()).tab(ItemGroup.TAB_MISC)));
}
