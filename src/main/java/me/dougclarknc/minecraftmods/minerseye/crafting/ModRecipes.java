package me.dougclarknc.minecraftmods.minerseye.crafting;

import me.dougclarknc.minecraftmods.minerseye.MinersEyeMod;
import me.dougclarknc.minecraftmods.minerseye.block.ModBlocks;
import me.dougclarknc.minecraftmods.minerseye.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * 
 * @author dougc
 * @date Oct 2, 2016
 * @version
 */
public class ModRecipes {
	public static void addRecipes() {
		//MinersEyeOre recipe
		GameRegistry.addRecipe(new ItemStack(ModBlocks.oreMinersEye),
			"AA ",
			"A A",
			"AA ",
			'A', Blocks.COBBLESTONE
		);
		
		//MinersMultitool recipe
		GameRegistry.addRecipe(new ItemStack(ModItems.minersMultiTool),
				"AAA",
				" B ",
				" B ",
				'A', ModItems.ingotMinersEyengot, 'B', Items.STICK
			);		
	
		//MinersEyengot recipe
		GameRegistry.addSmelting(ModBlocks.oreMinersEye, new ItemStack(ModItems.ingotMinersEyengot), 20F);

	}
}
