package soulblaze;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = SoulBlaze.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities
{

    public static EntityType<BlazeEntity> SOUL_BLAZE;

    public static void init()
    {
        SOUL_BLAZE = EntityType.Builder.of(BlazeEntity::new, EntityClassification.MONSTER).fireImmune().sized(0.6F, 1.8F).clientTrackingRange(8).build(getEntityResource("soulblaze").toString());
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> e)
    {
        final IForgeRegistry<EntityType<?>> registry = e.getRegistry();
        registry.register(SOUL_BLAZE.setRegistryName(SoulBlaze.MOD_ID, "soulblaze"));
    }

    @SubscribeEvent
    public static void registerSpawnEggs(final RegistryEvent.Register<Item> event)
    {
        init();
        event.getRegistry().registerAll(
                new SpawnEggItem(SOUL_BLAZE, 4411786, 16775294, new Item.Properties().tab(ItemGroup.TAB_MISC)).setRegistryName(SoulBlaze.MOD_ID, "soulblaze_spawn_egg"));
    }

    @SubscribeEvent
    public static void registerAttributes(final EntityAttributeCreationEvent event)
    {
        event.put(SOUL_BLAZE, BlazeEntity.createAttributes().build());
    }

    private static ResourceLocation getEntityResource(String entityName)
    {
        return new ResourceLocation(SoulBlaze.MOD_ID, entityName);
    }
}
