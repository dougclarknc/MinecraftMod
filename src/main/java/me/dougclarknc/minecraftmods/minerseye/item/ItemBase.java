package me.dougclarknc.minecraftmods.minerseye.item;

import me.dougclarknc.minecraftmods.minerseye.MinersEyeMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements ItemModelProvider {

	protected String name;
	
	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		//setCreateTab(MinersEyeMod.creativeTab);
	}
	
	@Override
	public void registerItemModel(Item item) {
		MinersEyeMod.proxy.registerItemRenderer(this, 0, name);
	}
	
	 @Override
	 public ItemBase setCreativeTab(CreativeTabs tab) {
		 super.setCreativeTab(tab);
		 return this;
	 }

}
