package net.Ang.Practiceccmod.item.custom;

import net.Ang.Practiceccmod.ToolActions.ModToolActions;
import net.Ang.Practiceccmod.block.ModBlocks;
import net.Ang.Practiceccmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolAction;

import java.util.Map;

public class FossilCutterItem extends Item {
    public FossilCutterItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        // Check if the block is a fossil block
        if (!level.isClientSide && level.getBlockState(pos).getBlock() == ModBlocks.FOSSIL_BLOCK_2.get()) {
            // Replace the fossil block with stone
            level.setBlock(pos, Blocks.STONE.defaultBlockState(), 3);

            // Drop the triceratops skull item
            ItemEntity skullDrop = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), ModItems.TRICERATOPS_SKULL.get().getDefaultInstance());
            level.addFreshEntity(skullDrop);

            // Return success
            return InteractionResult.SUCCESS;
        }

        return super.useOn(context);
    }
}
