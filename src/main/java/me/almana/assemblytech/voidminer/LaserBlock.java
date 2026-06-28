package me.almana.assemblytech.voidminer;

import me.almana.assemblytech.multiblock.slave.MultiblockSlaveBlock;
import me.almana.assemblytech.multiblock.slave.MultiblockSlaveEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class LaserBlock extends MultiblockSlaveBlock {
    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;
    private static final VoxelShape CORE_SHAPE = Block.box(2.0, 2.0, 2.0, 14.0, 14.0, 14.0);
    private static final VoxelShape UP_SHAPE = Shapes.or(CORE_SHAPE, Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0));
    private static final VoxelShape DOWN_SHAPE = Shapes.or(CORE_SHAPE, Block.box(0.0, 14.0, 0.0, 16.0, 16.0, 16.0));
    private static final VoxelShape NORTH_SHAPE = Shapes.or(CORE_SHAPE, Block.box(0.0, 0.0, 14.0, 16.0, 16.0, 16.0));
    private static final VoxelShape SOUTH_SHAPE = Shapes.or(CORE_SHAPE, Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 2.0));
    private static final VoxelShape WEST_SHAPE = Shapes.or(CORE_SHAPE, Block.box(14.0, 0.0, 0.0, 16.0, 16.0, 16.0));
    private static final VoxelShape EAST_SHAPE = Shapes.or(CORE_SHAPE, Block.box(0.0, 0.0, 0.0, 2.0, 16.0, 16.0));

    public LaserBlock(Properties properties, Supplier<BlockEntityType<? extends MultiblockSlaveEntity>> entityType) {
        super(properties, entityType);
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.UP));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getClickedFace());
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case DOWN -> DOWN_SHAPE;
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST -> EAST_SHAPE;
            default -> UP_SHAPE;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
