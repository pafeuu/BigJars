package net.pafeuu.bigJarsMod;

import net.pafeuu.bigJarsMod.registries.BlockRegistry;
import net.pafeuu.bigJarsMod.registries.CreativeTabRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.mojang.logging.LogUtils.getLogger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BigJarsMod.MODID)
public class BigJarsMod
{
    public static final String MODID = "druidic_quest_core";
    public static final Logger DQ_LOGGER = getLogger();

    public BigJarsMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        CreativeTabRegistry.register(modEventBus);
        BlockRegistry.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(CreativeTabRegistry::addCreative);

        context.registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC,  BigJarsMod.MODID + "/common_config.toml");
    }
}
