package me.dougclarknc.minecraftmods.minerseye.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;

public class ModItems {
	
	public static ItemBase ingotMinersEyengot;
	public static ItemBase minersMultitool;

	public static void init() {
		ingotMinersEyengot = register(new
				ItemBase("ingotMinersEyengot")
				.setCreativeTab(CreativeTabs.MATERIALS));
		
		minersMultitool = register(new
				ItemBase("minersMultitool")
				.setCreativeTab(CreativeTabs.MATERIALS));
	}
	
	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);
		
		if (item instanceof ItemModelProvider) {
			((ItemModelProvider)item).registerItemModel(item);
		}
		
		return item;
	}
}

