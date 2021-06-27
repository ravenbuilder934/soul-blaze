package soulblaze;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import soulblaze.client.RenderSoulBlaze;
import soulblaze.entity.ModEntities;
import soulblaze.fireball.ModItems;
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
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SOUL_BLAZE, RenderSoulBlaze::new);
    }
}
