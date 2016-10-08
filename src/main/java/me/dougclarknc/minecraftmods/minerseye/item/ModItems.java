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
	
	public static ItemBase ingotMinersEyengot;
	public static MinersMultiTool minersMultiTool;

	public static void init() {
		ingotMinersEyengot = register(new
				ItemBase("ingotMinersEyengot")
				.setCreativeTab(CreativeTabs.MATERIALS));
		
		minersMultiTool = register(new MinersMultiTool(
				MinersEyeMod.minersEyeMaterial, "minersMultiTool")
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

