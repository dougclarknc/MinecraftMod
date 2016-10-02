package me.dougclarknc.minecraftmods.minerseye;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import me.dougclarknc.minecraftmods.minerseye.proxy.CommonProxy;
import me.dougclarknc.minecraftmods.minerseye.block.ModBlocks;
import me.dougclarknc.minecraftmods.minerseye.crafting.ModRecipes;
import me.dougclarknc.minecraftmods.minerseye.item.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MinersEyeMod.MODID, name = MinersEyeMod.NAME,
version = MinersEyeMod.VERSION, acceptedMinecraftVersions = "[1.10.2]")
public class MinersEyeMod {
	public static final String MODID = "minerseyemod";
	public static final String NAME = "Miners Eye Mod";
	public static final String VERSION = "0.1";

	@SidedProxy(serverSide = "me.dougclarknc.minecraftmods.minerseye.proxy.CommonProxy",
				clientSide = "me.dougclarknc.minecraftmods.minerseye.proxy.ClientProxy")
		public static CommonProxy proxy;
	
	@Mod.Instance(MODID)
	public static MinersEyeMod instance;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(NAME + " is loading");
		ModItems.init();
		ModBlocks.init();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		ModRecipes.addRecipes();
	}
	
	@Mod.EventHandler
	public void PostInit(FMLPostInitializationEvent event) {
	}
}