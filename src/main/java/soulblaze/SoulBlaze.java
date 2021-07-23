package soulblaze;

import net.minecraft.block.DispenserBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import soulblaze.brewing.MundanePotionBrewingRecipe;
import soulblaze.brewing.StrengthPotionBrewingRecipe;
import soulblaze.client.RenderSoulBlaze;
import soulblaze.dispenser.DispenseSoulFireCharge;
import soulblaze.entity.ModEntities;
import soulblaze.item.ModItems;
import soulblaze.spawning.ModSpawns;

@Mod(SoulBlaze.MOD_ID)
public class SoulBlaze
{
    public static final String MOD_ID = "soulblaze";

    public SoulBlaze()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ModSpawns());
        DispenserBlock.registerBehavior(ModItems.SOUL_FIRE_CHARGE.get(), new DispenseSoulFireCharge());
        BrewingRecipeRegistry.addRecipe(new MundanePotionBrewingRecipe());
        BrewingRecipeRegistry.addRecipe(new StrengthPotionBrewingRecipe());
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SOUL_BLAZE, RenderSoulBlaze::new);
    }
}
