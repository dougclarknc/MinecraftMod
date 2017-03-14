package me.dougclarknc.minecraftmods.minerseye.item;


import java.util.Collections;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import me.dougclarknc.minecraftmods.minerseye.MinersEyeMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * 
 * @author dougc
 * @date Oct 2, 2016
 * @version
 */
public class MinersMultiTool extends ItemTool implements ItemModelProvider{
	protected String name = "Miners Multitool";
	public static float attack_speed = -3.0F;
	public static float base_damage = 20.0F;
	
	public MinersMultiTool(ToolMaterial material, String name) {
		super(base_damage, attack_speed, material, blocks);
		this.setHarvestLevel("pickaxe", 3);
		this.setHarvestLevel("axe", 3);
		this.setHarvestLevel("spade", 3);
		this.setHarvestLevel("hoe", 3);
		this.setHarvestLevel("sword", 3);
		this.efficiencyOnProperMaterial = 12.0F;
		this.setMaxDamage(3000);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
		//setCreativeTab(MinersEyeMod.creativeTab);
	}
	
	/**
	 * The {@link Material}s that this tool is effective on.
	 */
	private static final Set<Material> EFFECTIVE_MATERIALS = ImmutableSet.of(
			// Pickaxe
			Material.ROCK, Material.IRON, Material.IRON, Material.GLASS, Material.PISTON, Material.ANVIL, Material.CIRCUITS,

			// Axe
			Material.WOOD, Material.GOURD, Material.PLANTS, Material.VINE,

			// Shovel
			Material.GRASS, Material.GROUND, Material.SAND, Material.SNOW, Material.CRAFTED_SNOW, Material.CLAY,
			
			//Sword
			Material.PLANTS, Material.VINE, Material.CORAL, Material.LEAVES, Material.GOURD
	);

	
	@Override
	public void registerItemModel(Item item) {
		MinersEyeMod.proxy.registerItemRenderer(this, 0, name);
	}
	
	@Override
	public MinersMultiTool setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	
	protected void func_185071_a(ItemStack stack, EntityPlayer player,
			World worldIn, BlockPos pos, IBlockState state) {
		worldIn.playSound(player,pos,SoundEvents.ITEM_HOE_TILL,
				SoundCategory.BLOCKS, 1.0F, 1.0F);
		if (!worldIn.isRemote) {
			worldIn.setBlockState(pos, state, 11);
			stack.damageItem(1, player);
		}
	}
	
	@SuppressWarnings("incomplete-switch")
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitx, float hity, float hitz) {
		//Makes it work like a hoe
		if (!playerIn.canPlayerEdit(pos.offset(facing), facing, stack)) {
			return EnumActionResult.FAIL;
		} else {
			int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos);
			if (hook != 0) return hook > 0 ? EnumActionResult.SUCCESS:EnumActionResult.FAIL;
			IBlockState iblockstate = worldIn.getBlockState(pos);
			Block block = iblockstate.getBlock();
			if (facing != EnumFacing.DOWN && worldIn.isAirBlock(pos.up())) {
				if (block == Blocks.GRASS || block == Blocks.GRASS_PATH) {
					this.func_185071_a(stack, playerIn, worldIn, pos,
							Blocks.FARMLAND.getDefaultState());
					return EnumActionResult.SUCCESS;
				}
				
				if (block == Blocks.DIRT) {
					switch ((BlockDirt.DirtType)
							iblockstate.getValue(BlockDirt.VARIANT)) {
					case DIRT:
						this.func_185071_a(stack, playerIn, worldIn, pos, Blocks.FARMLAND.getDefaultState());
						return EnumActionResult.SUCCESS;
						
					case COARSE_DIRT:
						this.func_185071_a(stack, playerIn, worldIn, pos, Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
						return EnumActionResult.SUCCESS;
					}
				}
			}
			return EnumActionResult.PASS;
		}
	}
		
	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
	    return efficiencyOnProperMaterial;
	}
	    
	@Override
	public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
	    if (!(state.getMaterial() == Material.AIR) && !(state.getMaterial() == Material.BARRIER)) {
	        return true;
	    } else {
	        return false;
	    }
	}
	 
	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) {
	    // Only take one damage like a sword instead of 2
	    itemStack.damageItem(1, attacker);
	    return true;
	}
	
	private static Set blocks = Sets.newHashSet( new Block[] {
			Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, 
			Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE,
			Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE,
			Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE,
			Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE,
			Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN,
			Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE, Blocks.CLAY, Blocks.DIRT,
			Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_LAYER,
			Blocks.SOUL_SAND, Blocks.GRASS_PATH
		}
	);
}