package net.pafeuu.bigJarsMod.registries;

import com.hollingsworth.arsnouveau.common.util.RegistryWrapper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pafeuu.bigJarsMod.BigJarsMod;
import net.pafeuu.bigJarsMod.blockClasses.BigSourceJar;
import net.pafeuu.bigJarsMod.blockClasses.BigSourceJarTile;
import net.pafeuu.bigJarsMod.blockClasses.HugeSourceJar;
import net.pafeuu.bigJarsMod.blockClasses.HugeSourceJarTile;

import java.util.function.Supplier;

import static com.hollingsworth.arsnouveau.setup.registry.BlockRegistry.registerTile;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BigJarsMod.MODID);


    public static RegistryWrapper<BigSourceJar> BIG_SOURCE_JAR = registerBlockWrapper("big_source_jar",
            BigSourceJar::new);

    public static RegistryWrapper<BlockEntityType<BigSourceJarTile>> BIG_SOURCE_JAR_TILE = registerTile("big_jar_tile",
            BigSourceJarTile::new,
            BIG_SOURCE_JAR);

    public static RegistryWrapper<HugeSourceJar> HUGE_SOURCE_JAR = registerBlockWrapper("huge_source_jar",
            HugeSourceJar::new);

    public static RegistryWrapper<BlockEntityType<HugeSourceJarTile>> HUGE_SOURCE_JAR_TILE = registerTile("huge_jar_tile",
            HugeSourceJarTile::new,
            HUGE_SOURCE_JAR);


    private static <T extends Block> RegistryWrapper<T> registerBlockWrapper(String name, Supplier<T> block) {
        RegistryWrapper<T> toReturn = new RegistryWrapper<>(BLOCKS.register(name, block));
        registerBlockItemWrapper(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryWrapper<Item> registerBlockItemWrapper(String name, RegistryWrapper<T> block) {
        return new RegistryWrapper<>(ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties())));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
