package me.dougclarknc.minecraftmods.minerseye.potion;

import net.minecraft.potion.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModPotions {
	/**
     * Potion brewing requires a bit of understanding regarding bits (see what I did there? XD) as PotionHelper uses it
     * to determine final brewing products
     *
     * For future ease of reference I will write the significant points down here
     * Bits 0-3 are used to determine which potion will be made
     * Bit 4 determines if it's an awkward potion (brewed using nether wart), always gets unset by effect ingredients
     *     such as ghast tear, golden carrot, etc
     * Bit 5 means the potion is Extended
     * Bit 6 means the potion is Level II (cannot be both Extended and Level II)
     * Bits 7-12 seem to do nothing, although bit 7 gets unset in both the glowstone and redstone potion effects
     * Bit 13 determines if it is drinkable, always gets set by effect ingredients
     * Bit 14 determines if it is splashable (cannot be both drinkable and splashable)
     *
     * +(x) set bit at position 'x' (makes it 1)
     * -(x) unset bit at position 'x' (makes it 0)
     *
     * & functions like the 'AND' condition. The previous bit must be how its listed 'AND' the following bit as well
     * ! functions like the 'NOT' condition. Checks if the following bit is unset.
     *
     * Detailed Example:
     * A water bottle in the brewery is considered to have all the bits unset (bits 0 through 14)
     * Per typical potion creation, the water bottle gets brewed with nether wart, setting bit 4, and creating an
     *     awkward potion. Right now the only bit set is bit 4; no others
     * Lets then continue and make a regeneration potion, adding a ghast tear as the next ingredient
     * In PotionHelper the ghast tear's effect is "+0-1-2-3&4-4+13", which means that when the potion is brewed bit 0 is
     *     set, and bits 1, 2, and 3 are unset. The next part is a bit tricky. What we have remaining is "&4-4+13". What
     *     basically happens is it asks if bit 4 is set. If so, unset it, making sure it is no longer considered an
     *     awkward potion. Then it proceeds as normal and sets bit 13, as by default the first level of potions are
     *     drinkable. Now the set bits are 0 and 13, while the unset bits are 1, 2, and 3
     * Since the regeneration potion's 'potionRequirements' is "0 & !1 & !2 & !3 & 0+6", the game recognizes we have
     *     brewed a basic regeneration potion with duration equal to 2 minutes. The "& 0+6" seems to serve no purpose.
     *     Although it looks as if it would set bit 6 (the Extended flag), it clearly doesn't. Also my effect bit
     *     strings don't include anything similar and yet work fine.
     * If you want your potion to be amplified (a.k.a. Level II) with glowstone you have to add it to PotionHelper's
     *     'potionAmplifiers' ArrayList.
     */
	
	private static final int NUM_NEW_POTIONS = 2;
	private static int potionOffset;
	
	public static final String antihungerEffect = "";
	
	public static int nextPotionID = 0;
	public static Potion minersEyebuprofin;
	
	@SuppressWarnings("unchecked")
	public static void init() {
		minersEyebuprofin = register()
	}
}
