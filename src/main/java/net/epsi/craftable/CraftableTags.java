package net.epsi.craftable;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CraftableTags {
    public static final TagKey<Item> WHITE_TULIP_BASE = TagKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath("craftable", "white_tulip_base")
    );
    public static final TagKey<Item> ORANGE_TULIP_BASE = TagKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath("craftable", "orange_tulip_base")
    );
    public static final TagKey<Item> PINK_TULIP_BASE = TagKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath("craftable", "pink_tulip_base")
    );
    public static final TagKey<Item> RED_TULIP_BASE = TagKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath("craftable", "red_tulip_base")
    );
    public static final TagKey<Item> SAPLINGS = TagKey.create(
           Registries.ITEM,
           Identifier.fromNamespaceAndPath("craftable", "saplings")
    );
    public static final TagKey<Item> MUSHROOMS = TagKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath("craftable", "mushrooms")
    );
}