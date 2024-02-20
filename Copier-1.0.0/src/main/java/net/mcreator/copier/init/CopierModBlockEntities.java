
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.copier.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.copier.block.entity.CopierBlockEntity;
import net.mcreator.copier.CopierMod;

public class CopierModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CopierMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> COPIER = register("copier", CopierModBlocks.COPIER, CopierBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
