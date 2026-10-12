package net.pafeuu.bigJarsMod;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.pafeuu.bigJarsMod.registries.BlockRegistry;

@Mod.EventBusSubscriber(
        modid = BigJarsMod.MODID,
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public class ClientSetup {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemProperties.register(
                    Item.byBlock(BlockRegistry.BIG_SOURCE_JAR.get()),
                    new ResourceLocation(BigJarsMod.MODID, "source"),
                    (stack, level, entity, seed) -> {
                        CompoundTag tag = stack.getTagElement("BlockEntityTag");
                        if (tag != null) {
                            int source = tag.getInt("source");
                            int capacity = CommonConfig.BIG_JAR_CAPACITY.get();
                            return capacity > 0 ? (float) source / capacity : 0.0F;
                        }
                        return 0.0F;
                    }
            );
        });
    }
}
