package me.dougclarknc.minecraftmods.minerseye.potion;

import me.dougclarknc.minecraftmods.minerseye.MinersEyeMod;
import me.dougclarknc.minecraftmods.minerseye.item.ItemModelProvider;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;

public class MinersEyebuprofin extends Potion implements ItemModelProvider{
	
	private static final int liquidColor = 0;
	private static final String name = "Miners Eyebuprofin";
	private static final boolean isBadEffect = false;
	
	protected MinersEyebuprofin(boolean isBadEffectIn, int liquidColorIn) {
		super(isBadEffectIn, liquidColorIn);
		
	}

	@Override
	public void registerItemModel(Item item) {
		MinersEyeMod.proxy.registerItemRenderer(this, 0, name);
		
	}
}
