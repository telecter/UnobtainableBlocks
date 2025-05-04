package xyz.telecter.unobtainableblocks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR)
                .register((itemGroup) -> {
                    itemGroup.add(NETHER_PORTAL_ITEM);
                    itemGroup.add(END_PORTAL_ITEM);
                    itemGroup.add(WATER_ITEM);
                    itemGroup.add(FIRE_ITEM);
                    itemGroup.add(LAVA_ITEM);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                        itemGroup.add(Items.PETRIFIED_OAK_SLAB);
                });
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(UnobtainableBlocks.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    public static final Item NETHER_PORTAL_ITEM = register("nether_portal", (settings) -> new BlockItem(Blocks.NETHER_PORTAL, settings), new Item.Settings()
            .rarity(Rarity.EPIC));
    public static final Item END_PORTAL_ITEM = register("end_portal", (settings) -> new BlockItem(Blocks.END_PORTAL, settings), new Item.Settings()
            .rarity(Rarity.EPIC));
    public static final Item FIRE_ITEM = register("fire", (settings) -> new BlockItem(Blocks.FIRE, settings), new Item.Settings()
            .rarity(Rarity.EPIC));
    public static final Item WATER_ITEM = register("water", (settings) -> new BlockItem(Blocks.WATER, settings), new Item.Settings()
            .rarity(Rarity.EPIC));
    public static final Item LAVA_ITEM = register("lava", (settings) -> new BlockItem(Blocks.LAVA, settings), new Item.Settings()
            .rarity(Rarity.EPIC));
}