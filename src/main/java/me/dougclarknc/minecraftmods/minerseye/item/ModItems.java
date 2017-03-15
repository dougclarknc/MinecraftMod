package me.dougclarknc.minecraftmods.minerseye.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import me.dougclarknc.minecraftmods.minerseye.MinersEyeMod;
import net.minecraft.creativetab.CreativeTabs;

/**
 * 
 * @author dougc
 * @date Oct 2, 2016
 * @version
 */
public class ModItems {
	
	public static ItemBase ingotminerseyengot;
	public static MinersMultiTool minersmultitool;

	public static void init() {
		ingotminerseyengot = register(new
				ItemBase("ingotminerseyengot")
				.setCreativeTab(CreativeTabs.MATERIALS));
		
		minersmultitool = register(new MinersMultiTool(
				MinersEyeMod.minersEyeMaterial, "minersmultitool")
				.setCreativeTab(CreativeTabs.TOOLS));
	}
	
	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);
		
		if (item instanceof ItemModelProvider) {
			((ItemModelProvider)item).registerItemModel(item);
		}
		
		return item;
	}
}

