package net.pafeuu.bigJarsMod.registries;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pafeuu.bigJarsMod.BigJarsMod;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BigJarsMod.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
