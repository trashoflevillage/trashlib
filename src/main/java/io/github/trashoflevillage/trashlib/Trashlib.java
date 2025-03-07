package io.github.trashoflevillage.trashlib;

import io.github.trashoflevillage.trashlib.worldgen.features.TrashlibFeatures;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Colors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Trashlib implements ModInitializer {
	public static final String MOD_ID = "trashlib";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		TrashlibFeatures.registerAll();
		if (FabricLoader.getInstance().isDevelopmentEnvironment()) TrashlibCommands.registerAll();
	}
}