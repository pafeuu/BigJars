package net.pafeuu.bigJarsMod.blockClasses;

import com.hollingsworth.arsnouveau.common.block.SourceJar;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.pafeuu.bigJarsMod.CommonConfig;
import net.pafeuu.bigJarsMod.registries.BlockRegistry;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BigSourceJar extends SourceJar {
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BigSourceJarTile(pos,state);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        //super.appendHoverText(stack, worldIn, tooltip, flagIn);
        if (stack.getTag() != null) {
            int mana = stack.getTag().getCompound("BlockEntityTag").getInt("source");
            tooltip.add(Component.literal(mana * 100 / CommonConfig.BIG_JAR_CAPACITY.get() + "% full"));
        }
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {

        context.getLevel().scheduleTick(context.getClickedPos(), BlockRegistry.BIG_SOURCE_JAR.get(), 1);
        return super.getStateForPlacement(context);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.tick(state, level, pos, random);
        if (level.getBlockEntity(pos) instanceof BigSourceJarTile jarTile) {
            jarTile.updateBlock();
        }
    }
}

