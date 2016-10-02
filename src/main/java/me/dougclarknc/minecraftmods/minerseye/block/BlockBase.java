package me.dougclarknc.minecraftmods.minerseye.block;

import me.dougclarknc.minecraftmods.minerseye.item.ItemModelProvider;
import me.dougclarknc.minecraftmods.minerseye.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements ItemModelProvider {
	
	protected String name;
	
	public BlockBase (Material materialIn, String name) {
		super(materialIn);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		//setCreativeTab(MinersEyeMod.creativeTab); //not implemented yet
	}
	
	@Override
	public void registerItemModel(Item itemBlock) {
		MinersEyeMod.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	@Override
	public BlockBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
}
