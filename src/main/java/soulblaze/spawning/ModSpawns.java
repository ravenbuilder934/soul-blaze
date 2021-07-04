package soulblaze.spawning;

import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import soulblaze.SoulBlaze;
import soulblaze.entity.ModEntities;
import soulblaze.entity.SoulBlazeEntity;

import java.util.Random;

@Mod.EventBusSubscriber(modid = SoulBlaze.MOD_ID)
public class ModSpawns
{
    private static final Logger LOGGER = LogManager.getLogger();
    static Random rand = new Random();

    /**
     * 50% chance to cancel the normal blaze and spawn a soul blaze instead.
     * Doesn't apply if the blaze is being spawned from a spawn egg or a command.
     */
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onSpecialSpawn(LivingSpawnEvent.SpecialSpawn event)
    {
        if (event.getEntity() instanceof BlazeEntity && !(event.getSpawnReason() == SpawnReason.SPAWN_EGG) && !(event.getSpawnReason() == SpawnReason.COMMAND) && rand.nextInt(2) == 1)
        {
            event.setCanceled(true);
            SoulBlazeEntity soulBlaze = ModEntities.SOUL_BLAZE.create((World) event.getWorld());
            if (soulBlaze != null)
            {
                soulBlaze.setPos(event.getX(), event.getY(), event.getZ());
                event.getWorld().addFreshEntity(soulBlaze);
                LOGGER.info("Works!");
            }
        }
    }
}
