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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolAction;

import java.util.Map;

import static net.minecraft.world.level.block.Block.popResource;

public class FossilCutterItem extends Item {
    private static final Map<Block, Block> FossilCutterItem_MAP =
            Map.of(
                    ModBlocks.FOSSIL_BLOCK_1.get(), Blocks.STONE,
                    ModBlocks.FOSSIL_BLOCK_2.get(), Blocks.STONE
            );
    private boolean flag;

    public static void dropfossil(Level pLevel, BlockPos pPos) {

    }

    public FossilCutterItem(Properties pProperties) {
        super(pProperties);
    }

    public static final ToolAction FOSSIL_CUTTER_HARVEST = ToolAction.get("fossil_cutter_harvest");

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if (FossilCutterItem_MAP.containsKey(clickedBlock)) {
            if (!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), FossilCutterItem_MAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }

    protected ItemInteractionResult useItemOn(
            ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult
    ) {
        if (pStack.canPerformAction(ModToolActions.FOSSIL_CUTTER_HARVEST)) {
            pLevel.playSound(
                    pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.BEEHIVE_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F
            );
            dropfossil(pLevel, pPos);
            pStack.hurtAndBreak(1, pPlayer, LivingEntity.getSlotForHand(pHand));
            flag = true;
            pLevel.gameEvent(pPlayer, GameEvent.SHEAR, pPos);
        }
        return null;
    }
}