package kovukore.asm.overriddenclasses;

import javax.xml.ws.soap.Addressing;

import kovukore.asm.transformer.ASMAddField;
import kovukore.asm.transformer.ASMAddMethod;
import kovukore.asm.transformer.ASMReplaceField;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowing;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;

public class Lights_Block extends Block
{
	private Lights_Block()
	{
		super(10000, Material.air);
	}
	
	@ASMAddField
    public final static Float[] l = {0F, 1F/15, 2F/15, 3F/15, 4F/15, 5F/15, 6F/15, 7F/15, 8F/15, 9F/15, 10F/15, 11F/15, 12F/15, 13F/15, 14F/15, 1F};
	
	@ASMReplaceField
    public static final Block lavaStill = (new BlockStationary(11, Material.lava)).setHardness(100.0F).setLightValue(1.0F).setUnlocalizedName("lava").disableStats().setTextureName("lava_still").addColorLightValue(l[15], l[12], l[10]);

	@ASMAddMethod
	public Block setLightValue(float par1)
    {
        lightValue[this.blockID] = (int)(15.0F * par1);
        return this.addColorLightValue(par1, par1, par1);
    }
	
	@ASMAddMethod
    public Block setLightValue(int par1)
    {
        lightValue[this.blockID] = par1;
        return this.addColorLightValue(l[par1], l[par1], l[par1]);
    }

	@ASMAddMethod
    public Block addColorLightValue(float r, float g, float b) {
    	//Erase Current Color (a default of white will exist)
    	lightValue[this.blockID] &= 15;
    	//Add the Light
    	lightValue[this.blockID] |= ((((int)(15.0F * b))<<15) + (((int)(15.0F * g))<<10) + (((int)(15.0F * r))<<5));
        return this;
    }
}