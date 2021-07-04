package soulblaze.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import soulblaze.SoulBlaze;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SoulBlaze.MOD_ID);

    public static final RegistryObject<SoulFireChargeItem> SOUL_FIRE_CHARGE = ITEMS.register("soul_fire_charge", () -> new SoulFireChargeItem((new Item.Properties()).tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<SoulBlazeRodItem> SOUL_BLAZE_ROD = ITEMS.register("soul_blaze_rod", () -> new SoulBlazeRodItem((new Item.Properties()).tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> SOUL_BLAZE_POWDER = ITEMS.register("soul_blaze_powder", () -> new Item((new Item.Properties()).tab(ItemGroup.TAB_BREWING)));
}
