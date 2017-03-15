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
		GameRegistry.addRecipe(new ItemStack(ModBlocks.oreminerseye),
			"AA ",
			"A A",
			"AA ",
			'A', Blocks.COBBLESTONE
		);
		
		//MinersMultitool recipe
		GameRegistry.addRecipe(new ItemStack(ModItems.minersmultitool),
				"AAA",
				" B ",
				" B ",
				'A', ModItems.ingotminerseyengot, 'B', Items.STICK
			);		
	
		//MinersEyengot recipe
		GameRegistry.addSmelting(ModBlocks.oreminerseye, new ItemStack(ModItems.ingotminerseyengot), 10.0F);

	}
}
