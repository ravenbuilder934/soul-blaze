package soulblaze;

import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = SoulBlaze.MOD_ID)
public class ModSpawns
{
    static Random rand = new Random();

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onSpecialSpawn(LivingSpawnEvent.SpecialSpawn event)
    {
        if (event.getEntity() instanceof BlazeEntity && rand.nextInt(2) == 1) //50% chance to cancel the normal blaze and spawn a soul blaze instead
        {
            event.setCanceled(true);
            BlazeEntity soulBlaze = ModEntities.SOUL_BLAZE.create((World) event.getWorld());
            if (soulBlaze != null)
            {
                soulBlaze.setPos(event.getX(), event.getY(), event.getZ());
                event.getWorld().addFreshEntity(soulBlaze);
            }
        }
    }
}
