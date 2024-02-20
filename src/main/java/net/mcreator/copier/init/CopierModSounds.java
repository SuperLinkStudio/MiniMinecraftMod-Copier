
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.copier.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.copier.CopierMod;

public class CopierModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CopierMod.MODID);
	public static final RegistryObject<SoundEvent> COPIER_PRINT = REGISTRY.register("copier_print", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("copier", "copier_print")));
}
