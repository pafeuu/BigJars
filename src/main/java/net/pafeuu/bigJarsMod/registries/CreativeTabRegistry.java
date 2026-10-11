package net.pafeuu.bigJarsMod.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pafeuu.bigJarsMod.BigJarsMod;


public class CreativeTabRegistry {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BigJarsMod.MODID);

    public static final RegistryObject<CreativeModeTab> BIG_JARS_TAB = CREATIVE_MODE_TAB.register("big_jars_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(BlockRegistry.HUGE_SOURCE_JAR.get()))
                    .title(Component.translatable("creativetab.big_jars"))
                    .displayItems((pParameters,pOutput)->{
                        pOutput.accept(BlockRegistry.BIG_SOURCE_JAR.get());
                        pOutput.accept(BlockRegistry.HUGE_SOURCE_JAR.get());
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
