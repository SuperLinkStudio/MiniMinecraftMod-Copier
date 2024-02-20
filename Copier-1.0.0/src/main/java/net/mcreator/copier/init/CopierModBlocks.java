
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.copier.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.copier.block.CopierBlock;
import net.mcreator.copier.CopierMod;

public class CopierModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, CopierMod.MODID);
	public static final RegistryObject<Block> COPIER = REGISTRY.register("copier", () -> new CopierBlock());
}
