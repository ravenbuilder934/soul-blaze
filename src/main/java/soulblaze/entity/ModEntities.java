package soulblaze.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import soulblaze.SoulBlaze;

@Mod.EventBusSubscriber(modid = SoulBlaze.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities
{
    public static EntityType<SoulBlazeEntity> SOUL_BLAZE;
    public static EntityType<SmallBlueFireballEntity> SMALL_BLUE_FIREBALL;

    public static void init()
    {
        SOUL_BLAZE = EntityType.Builder.of(SoulBlazeEntity::new, EntityClassification.MONSTER).fireImmune().sized(0.6F, 1.8F).clientTrackingRange(8).build(getEntityResource("soulblaze").toString());
        SMALL_BLUE_FIREBALL = EntityType.Builder.<SmallBlueFireballEntity>of(SmallBlueFireballEntity::new, EntityClassification.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(4).updateInterval(10).build(getEntityResource("small_blue_fireball").toString());
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> e)
    {
        final IForgeRegistry<EntityType<?>> registry = e.getRegistry();
        registry.register(SOUL_BLAZE.setRegistryName(SoulBlaze.MOD_ID, "soulblaze"));
        registry.register(SMALL_BLUE_FIREBALL.setRegistryName(SoulBlaze.MOD_ID, "small_blue_fireball"));
    }

    @SubscribeEvent
    public static void registerSpawnEggs(final RegistryEvent.Register<Item> event)
    {
        init();
        event.getRegistry().registerAll(new SpawnEggItem(SOUL_BLAZE, 4411786, 16775294, new Item.Properties().tab(ItemGroup.TAB_MISC)).setRegistryName(SoulBlaze.MOD_ID, "soulblaze_spawn_egg"));
    }

    @SubscribeEvent
    public static void registerAttributes(final EntityAttributeCreationEvent event)
    {
        event.put(SOUL_BLAZE, SoulBlazeEntity.createAttributes().build());
    }

    private static ResourceLocation getEntityResource(String entityName)
    {
        return new ResourceLocation(SoulBlaze.MOD_ID, entityName);
    }
}
