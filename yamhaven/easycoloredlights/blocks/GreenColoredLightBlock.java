package yamhaven.easycoloredlights.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import yamhaven.easycoloredlights.lib.BlockInfo;
import yamhaven.easycoloredlights.lib.ModInfo;
  
public class GreenColoredLightBlock extends BlockColoredLight {
	public GreenColoredLightBlock(int id, boolean isPowered) {
		super(id, isPowered);
		setUnlocalizedName(BlockInfo.greenColoredLightBlock_unlocalizedName);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":" + BlockInfo.greenColoredLightBlock_unlocalizedName + (powered?"On":""));
	}
	
	@Override
	protected void turnLightsOn() {
		setLightValue(1.0F);
		try {
			addColorLightValue(0.0F, 1.0F, 0.0F);
		} catch (Exception e) {
			System.out.println("The Colored Light Core appears to be missing, or broken"); 
		}
	}
}
