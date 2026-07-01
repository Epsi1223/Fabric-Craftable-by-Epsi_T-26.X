package net.epsi.craftable;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {

    public ItemTagsProvider(
            FabricPackOutput output,
            CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider provider) {
        valueLookupBuilder(CraftableTags.WHITE_TULIP_BASE)
                .add(Items.RED_TULIP)
                .add(Items.ORANGE_TULIP)
                .add(Items.PINK_TULIP);
        valueLookupBuilder(CraftableTags.ORANGE_TULIP_BASE)
                .add(Items.WHITE_TULIP)
                .add(Items.RED_TULIP)
                .add(Items.PINK_TULIP);
        valueLookupBuilder(CraftableTags.PINK_TULIP_BASE)
                .add(Items.WHITE_TULIP)
                .add(Items.ORANGE_TULIP)
                .add(Items.RED_TULIP);
        valueLookupBuilder(CraftableTags.RED_TULIP_BASE)
                .add(Items.WHITE_TULIP)
                .add(Items.ORANGE_TULIP)
                .add(Items.PINK_TULIP);
        valueLookupBuilder(CraftableTags.SAPLINGS)
                .add(Items.OAK_SAPLING)
                .add(Items.SPRUCE_SAPLING)
                .add(Items.BIRCH_SAPLING)
                .add(Items.JUNGLE_SAPLING)
                .add(Items.ACACIA_SAPLING)
                .add(Items.DARK_OAK_SAPLING)
                .add(Items.CHERRY_SAPLING)
                .add(Items.PALE_OAK_SAPLING);
        valueLookupBuilder(CraftableTags.MUSHROOMS)
                .add(Items.BROWN_MUSHROOM)
                .add(Items.RED_MUSHROOM);
    }
}