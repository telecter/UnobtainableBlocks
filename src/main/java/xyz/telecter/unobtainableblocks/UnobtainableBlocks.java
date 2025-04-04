package xyz.telecter.unobtainableblocks;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnobtainableBlocks implements ModInitializer {
	public static final String MOD_ID = "unobtainableblocks";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
	}
}