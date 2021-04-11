package soulblaze;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import soulblaze.entities.SoulBlazeEntity;

@Mod.EventBusSubscriber(modid = SoulBlaze.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {

	public static EntityType<SoulBlazeEntity> SOUL_BLAZE;

	public static void init()
	{
		SOUL_BLAZE = EntityType.Builder.create(SoulBlazeEntity::new, EntityClassification.MONSTER).immuneToFire().size(0.6F, 1.8F).trackingRange(8).build(getEntityResource("soulblaze").toString());
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
				new SpawnEggItem(SOUL_BLAZE, 4411786, 16775294, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(SoulBlaze.MOD_ID, "soulblaze_spawn_egg"));
	}

	public static void registerEntityAttributes()
	{
		GlobalEntityTypeAttributes.put(SOUL_BLAZE, SoulBlazeEntity.registerAttributes().create());
	}

	private static ResourceLocation getEntityResource(String entityName)
	{
		return new ResourceLocation(SoulBlaze.MOD_ID, entityName);
	}
}
