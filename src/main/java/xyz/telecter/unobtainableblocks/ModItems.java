package xyz.telecter.unobtainableblocks;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Function;

public class ModItems {
        public static void initialize() {
                CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.OP_BLOCKS)
                                .register((itemGroup) -> {
                                        itemGroup.accept(NETHER_PORTAL_ITEM);
                                        itemGroup.accept(END_PORTAL_ITEM);
                                        itemGroup.accept(END_GATEWAY_ITEM);
                                        itemGroup.accept(WATER_ITEM);
                                        itemGroup.accept(FIRE_ITEM);
                                        itemGroup.accept(SOUL_FIRE_ITEM);
                                        itemGroup.accept(LAVA_ITEM);
                                });
                CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
                                .register((itemGroup) -> {
                                        itemGroup.accept(Items.PETRIFIED_OAK_SLAB);
                                });
        }

        public static Item register(String name, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
                ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM,
                                Identifier.fromNamespaceAndPath(UnobtainableBlocks.MOD_ID, name));
                Item item = itemFactory.apply(settings.setId(itemKey));
                Registry.register(BuiltInRegistries.ITEM, itemKey, item);
                return item;
        }

        public static final Item NETHER_PORTAL_ITEM = register("nether_portal",
                        (settings) -> new BlockItem(Blocks.NETHER_PORTAL, settings), new Item.Properties()
                                        .rarity(Rarity.EPIC));
        public static final Item END_PORTAL_ITEM = register("end_portal",
                        (settings) -> new BlockItem(Blocks.END_PORTAL, settings), new Item.Properties()
                                        .rarity(Rarity.EPIC));
        public static final Item END_GATEWAY_ITEM = register("end_gateway",
                        (settings) -> new BlockItem(Blocks.END_GATEWAY, settings), new Item.Properties()
                                        .rarity(Rarity.EPIC));
        public static final Item FIRE_ITEM = register("fire", (settings) -> new BlockItem(Blocks.FIRE, settings),
                        new Item.Properties()
                                        .rarity(Rarity.EPIC));
        public static final Item SOUL_FIRE_ITEM = register("soul_fire",
                        (settings) -> new BlockItem(Blocks.SOUL_FIRE, settings), new Item.Properties()
                                        .rarity(Rarity.EPIC));
        public static final Item WATER_ITEM = register("water", (settings) -> new BlockItem(Blocks.WATER, settings),
                        new Item.Properties()
                                        .rarity(Rarity.EPIC));
        public static final Item LAVA_ITEM = register("lava", (settings) -> new BlockItem(Blocks.LAVA, settings),
                        new Item.Properties()
                                        .rarity(Rarity.EPIC));
}