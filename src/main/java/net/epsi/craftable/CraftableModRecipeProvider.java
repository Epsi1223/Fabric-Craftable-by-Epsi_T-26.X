/* Hi!
 *
 *
 * NOTE: The recipe categories may be confusing, and there may be typos especially in the IDs.
 * Also, as for now there's only one helper method,
 * because I want the code to be easier to read for people who are unfamiliar with Java.
 * If you are looking for a specific recipe, please use Ctrl+F / Cmd+F
 * to search for the item name.
 *
 * Thank you for checking out the source code!
 * Happy crafting!
 */


package net.epsi.craftable;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CraftableModRecipeProvider extends FabricRecipeProvider {
    public CraftableModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            //Helper Methods
            //Makers
            private void plusRecipeMaker(Item ingredient, Item middleIngredient, Item result, String recipeID) {
                shaped(RecipeCategory.MISC, result, 1)
                        .pattern(" X ")
                        .pattern("XYX")
                        .pattern(" X ")
                        .define('X', ingredient)
                        .define('Y', middleIngredient)
                        .unlockedBy(getHasName(ingredient), has(ingredient))
                        .unlockedBy(getHasName(middleIngredient), has(middleIngredient))
                        .save(output, recipeID);
            }
            //---End of Makers---
            //Actual Recipes:
            private void buildChainmailRecipes() {
                shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_HELMET, 1)
                        .pattern("CCC")
                        .pattern("C C")
                        .define('C', Items.IRON_CHAIN)
                        .unlockedBy(getHasName(Items.IRON_CHAIN), has(Items.IRON_CHAIN))
                        .save(output, "craftable_chainmail-helmet_from_iron-chain");
                shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_CHESTPLATE, 1)
                        .pattern("C C")
                        .pattern("CCC")
                        .pattern("CCC")
                        .define('C', Items.IRON_CHAIN)
                        .unlockedBy(getHasName(Items.IRON_CHAIN), has(Items.IRON_CHAIN))
                        .save(output, "craftable_chainmail-chestplate_from_iron-chain");
                shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_LEGGINGS, 1)
                        .pattern("CCC")
                        .pattern("C C")
                        .pattern("C C")
                        .define('C', Items.IRON_CHAIN)
                        .unlockedBy(getHasName(Items.IRON_CHAIN), has(Items.IRON_CHAIN))
                        .save(output, "craftable_chainmail-leggings_from_iron-chain");
                shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_BOOTS, 1)
                        .pattern("C C")
                        .pattern("C C")
                        .define('C', Items.IRON_CHAIN)
                        .unlockedBy(getHasName(Items.IRON_CHAIN), has(Items.IRON_CHAIN))
                        .save(output, "craftable_chainmail-boots_from_iron-chain");
            }
            private void buildFoodRecipes() {
                shaped(RecipeCategory.FOOD, Items.ENCHANTED_GOLDEN_APPLE, 1)
                        .pattern("GTG")
                        .pattern("GAG")
                        .pattern("GDG")
                        .define('G', Items.GOLD_BLOCK)
                        .define('A', Items.APPLE)
                        .define('T', Items.TOTEM_OF_UNDYING)
                        .define('D', Items.DRAGON_BREATH)
                        .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE))
                        .unlockedBy(getHasName(Items.GOLD_BLOCK), has(Items.GOLD_BLOCK))
                        .unlockedBy(getHasName(Items.TOTEM_OF_UNDYING), has(Items.TOTEM_OF_UNDYING))
                        .unlockedBy(getHasName(Items.DRAGON_BREATH), has(Items.DRAGON_BREATH))
                        .save(output, "craftable_enchanted-golden-apple_from_gold-blocks_totem-of-undying_dragon-breath_and_apple");
                shaped(RecipeCategory.FOOD, Items.POISONOUS_POTATO, 2)
                        .pattern("PFP")
                        .define('P', Items.POTATO)
                        .define('F', Items.FERMENTED_SPIDER_EYE)
                        .unlockedBy(getHasName(Items.POTATO), has(Items.POTATO))
                        .unlockedBy(getHasName(Items.FERMENTED_SPIDER_EYE), has(Items.FERMENTED_SPIDER_EYE))
                        .save(output, "craftable_poisonous-potato_from_potatoes_and_fermented-spider-eye");
                shapeless(RecipeCategory.FOOD, Items.GLOW_BERRIES, 1)
                        .requires(Items.SWEET_BERRIES)
                        .requires(Items.GLOWSTONE_DUST)
                        .unlockedBy(getHasName(Items.SWEET_BERRIES), has(Items.SWEET_BERRIES))
                        .unlockedBy(getHasName(Items.GLOWSTONE_DUST), has(Items.GLOWSTONE_DUST))
                        .save(output, "craftable_glow-berries_from_sweet-berries_and_glowstone-dust");
            }
            private void buildComponentRecipes() {
                shaped(RecipeCategory.MISC, Items.GUNPOWDER, 3)
                        .pattern("BSB")
                        .pattern("SMS")
                        .pattern("BSB")
                        .define('S', Items.SAND)
                        .define('M', Items.MAGMA_BLOCK)
                        .define('B', Items.BLAZE_ROD)
                        .unlockedBy(getHasName(Items.SAND), has(Items.SAND))
                        .unlockedBy(getHasName(Items.MAGMA_BLOCK), has(Items.MAGMA_BLOCK))
                        .unlockedBy(getHasName(Items.BLAZE_ROD), has(Items.BLAZE_ROD))
                        .save(output, "craftable_gunpowder_from_sand_blaze-rods_and_magma");
                shaped(RecipeCategory.MISC, Items.SHULKER_SHELL, 1)
                        .pattern("OCO")
                        .pattern("CDC")
                        .define('O', Items.OBSIDIAN)
                        .define('D', Items.DIAMOND)
                        .define('C', Items.CHORUS_FRUIT)
                        .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .unlockedBy(getHasName(Items.CHORUS_FRUIT), has(Items.CHORUS_FRUIT))
                        .save(output, "craftable_shulker-shell_from_obsidian_diamond_and_chorus-fruit");
                shaped(RecipeCategory.MISC, Items.ECHO_SHARD, 1)
                        .pattern("SAS")
                        .pattern("ADA")
                        .pattern("SAS")
                        .define('S', Items.SCULK)
                        .define('A', Items.AMETHYST_SHARD)
                        .define('D', Items.DRAGON_BREATH)
                        .unlockedBy(getHasName(Items.SCULK), has(Items.SCULK))
                        .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                        .unlockedBy(getHasName(Items.DRAGON_BREATH), has(Items.DRAGON_BREATH))
                        .save(output, "craftable_echo-shard_from_sculks_amethyst-shards_and_dragon-breath");
                shaped(RecipeCategory.MISC, Items.DRAGON_BREATH, 1)
                        .pattern("EPE")
                        .pattern("PGP")
                        .pattern("EPE")
                        .define('E', Items.ENDER_EYE)
                        .define('G', Items.GLASS_BOTTLE)
                        .define('P', Items.ENDER_PEARL)
                        .unlockedBy(getHasName(Items.ENDER_EYE), has(Items.ENDER_EYE))
                        .unlockedBy(getHasName(Items.GLASS_BOTTLE), has(Items.GLASS_BOTTLE))
                        .unlockedBy(getHasName(Items.ENDER_PEARL), has(Items.ENDER_PEARL))
                        .save(output, "craftable_dragon-breath_from_ender-eyes_ender-pearls_and_glass-bottle");
                shaped(RecipeCategory.MISC, Items.HEART_OF_THE_SEA, 1)
                        .pattern("PSP")
                        .pattern("SDS")
                        .pattern("PSP")
                        .define('S', Items.SEA_LANTERN)
                        .define('P', Items.PRISMARINE_BRICKS)
                        .define('D', Items.DIAMOND)
                        .unlockedBy(getHasName(Items.SEA_LANTERN), has(Items.SEA_LANTERN))
                        .unlockedBy(getHasName(Items.PRISMARINE_BRICKS), has(Items.PRISMARINE_BRICKS))
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output, "craftable_heart-of-the-sea_from_sea-lanterns_prismarine-bricks_and_diamond");
                shapeless(RecipeCategory.MISC, Items.GLOW_INK_SAC, 1)
                        .requires(Items.INK_SAC)
                        .requires(Items.GLOWSTONE_DUST)
                        .unlockedBy(getHasName(Items.INK_SAC), has(Items.INK_SAC))
                        .unlockedBy(getHasName(Items.GLOWSTONE_DUST), has(Items.GLOWSTONE_DUST))
                        .save(output, "craftable_glow-ink-sac_from_ink-sac_and_glowstone-dust");
                shapeless(RecipeCategory.MISC, Items.GLOWSTONE_DUST, 1)
                        .requires(Items.GLOW_BERRIES, 2)
                        .unlockedBy(getHasName(Items.GLOW_BERRIES), has(Items.GLOW_BERRIES))
                        .save(output, "craftable_glowstone-dust_from_glow-berries");
                shapeless(RecipeCategory.MISC, Items.STRING, 4)
                        .requires(Items.WHITE_WOOL)
                        .unlockedBy(getHasName(Items.WHITE_WOOL), has(Items.WHITE_WOOL))
                        .save(output, "craftable_strings_from_white-wool");
            }
            private void buildDecorativeBlockRecipes() {
                shaped(RecipeCategory.DECORATIONS, Items.COBWEB, 1)
                        .pattern("SSS")
                        .pattern("SSS")
                        .pattern("SSS")
                        .define('S', Items.STRING)
                        .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                        .save(output, "craftable_cobweb_from_strings");
                shaped(RecipeCategory.DECORATIONS, Items.BELL, 1)
                        .pattern("ASA")
                        .pattern(" G ")
                        .pattern("GGG")
                        .define('G', Items.GOLD_INGOT)
                        .define('A', Items.SMOOTH_STONE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .unlockedBy(getHasName(Items.SMOOTH_STONE), has(Items.SMOOTH_STONE))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .save(output, "craftable_bell_from_gold-ingots_smooth-stone_and_stick");
                shaped(RecipeCategory.DECORATIONS, Items.GRASS_BLOCK, 1)
                        .pattern("WWW")
                        .pattern("WDW")
                        .pattern("WWW")
                        .define('W', Items.WHEAT_SEEDS)
                        .define('D', Items.DIRT)
                        .unlockedBy(getHasName(Items.WHEAT_SEEDS), has(Items.WHEAT_SEEDS))
                        .unlockedBy(getHasName(Items.DIRT), has(Items.DIRT))
                        .save(output, "craftable_grass-block_from_wheat-seeds_and_dirt");
                shaped(RecipeCategory.DECORATIONS, Items.DIRT_PATH, 1)
                        .pattern("WWW")
                        .pattern("WDW")
                        .pattern("WWW")
                        .define('W', Items.WHEAT)
                        .define('D', Items.DIRT)
                        .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                        .unlockedBy(getHasName(Items.DIRT), has(Items.DIRT))
                        .save(output, "craftable_dirt-path_from_wheat_and_dirt");
                shaped(RecipeCategory.DECORATIONS, Items.SPONGE, 1)
                        .pattern("SSS")
                        .pattern("SWS")
                        .pattern("SSS")
                        .define('S', Items.SLIME_BALL)
                        .define('W', Items.YELLOW_WOOL)
                        .unlockedBy(getHasName(Items.SLIME_BALL), has(Items.SLIME_BALL))
                        .unlockedBy(getHasName(Items.YELLOW_WOOL), has(Items.YELLOW_WOOL))
                        .save(output, "craftable_sponge_from_slime-balls_and_yellow-wool");
                shaped(RecipeCategory.DECORATIONS, Items.CRYING_OBSIDIAN, 1)
                        .pattern(" G ")
                        .pattern("GOG")
                        .pattern(" G ")
                        .define('G', Items.GHAST_TEAR)
                        .define('O', Items.OBSIDIAN)
                        .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                        .unlockedBy(getHasName(Items.GHAST_TEAR), has(Items.GHAST_TEAR))
                        .save(output, "craftable_crying-obsidian_from_obsidian_and_ghast-tears");
                shaped(RecipeCategory.MISC, Items.TUFF, 8)
                        .pattern("CCC")
                        .pattern("CDC")
                        .pattern("CCC")
                        .define('C', Items.COBBLESTONE)
                        .define('D', Items.DEEPSLATE)
                        .unlockedBy(getHasName(Items.DEEPSLATE), has(Items.DEEPSLATE))
                        .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                        .save(output, "craftable_tuff_from_cobblestones_and_deepslate");
                shaped(RecipeCategory.MISC, Items.MAGMA_BLOCK, 8)
                        .pattern("NNN")
                        .pattern("NRN")
                        .pattern("NNN")
                        .define('R', Items.BLAZE_ROD)
                        .define('N', Items.NETHERRACK)
                        .unlockedBy(getHasName(Items.BLAZE_ROD), has(Items.BLAZE_ROD))
                        .unlockedBy(getHasName(Items.NETHERRACK), has(Items.NETHERRACK))
                        .save(output, "craftable_magma-block_from_blaze-rod_and_netherracks");
                shapeless(RecipeCategory.MISC, Items.GRAVEL, 1)
                        .requires(Items.COBBLESTONE)
                        .requires(Items.FLINT)
                        .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                        .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT))
                        .save(output, "craftable_gravel_from_cobblestone_and_flint");
                shapeless(RecipeCategory.MISC, Items.RED_SAND, 1)
                        .requires(Items.SAND)
                        .requires(Items.RED_DYE)
                        .unlockedBy(getHasName(Items.SAND), has(Items.SAND))
                        .unlockedBy(getHasName(Items.RED_DYE), has(Items.RED_DYE))
                        .save(output, "craftable_red-sand_from_sand_and_red-dye");
                shapeless(RecipeCategory.MISC, Items.ROOTED_DIRT, 1)
                        .requires(Items.GRASS_BLOCK)
                        .requires(Items.HANGING_ROOTS)
                        .unlockedBy(getHasName(Items.GRASS_BLOCK), has(Items.GRASS_BLOCK))
                        .unlockedBy(getHasName(Items.HANGING_ROOTS), has(Items.HANGING_ROOTS))
                        .save(output, "craftable_rooted-dirt_from_grass-block_and_hanging-roots");
                shapeless(RecipeCategory.DECORATIONS, Items.CALCITE, 1)
                        .requires(Items.DIORITE)
                        .requires(Items.BONE_MEAL)
                        .unlockedBy(getHasName(Items.DIORITE), has(Items.DIORITE))
                        .unlockedBy(getHasName(Items.BONE_MEAL), has(Items.BONE_MEAL))
                        .save(output, "craftable_calcite_from_diorite_and_bone-meal");
                shapeless(RecipeCategory.DECORATIONS, Items.WET_SPONGE, 1)
                        .requires(Items.SPONGE)
                        .requires(Items.WATER_BUCKET)
                        .unlockedBy(getHasName(Items.SPONGE), has(Items.SPONGE))
                        .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                        .save(output, "craftable_wet-sponge_from_sponge_and_water-bucket");
                shapeless(RecipeCategory.DECORATIONS, Items.GILDED_BLACKSTONE, 1)
                        .requires(Items.BLACKSTONE)
                        .requires(Items.GOLD_NUGGET)
                        .unlockedBy(getHasName(Items.BLACKSTONE), has(Items.BLACKSTONE))
                        .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                        .save(output, "craftable_gilded-blackstone_from_blackstone_and_gold-nugget");
                shapeless(RecipeCategory.DECORATIONS, Items.MYCELIUM, 1)
                        .requires(Items.GRASS_BLOCK)
                        .requires(CraftableTags.MUSHROOMS)
                        .unlockedBy(getHasName(Items.GRASS_BLOCK), has(Items.GRASS_BLOCK))
                        .save(output, "craftable_mycelium_from_grass-block_and_mushroom");
                shapeless(RecipeCategory.DECORATIONS, Items.PODZOL, 1)
                        .requires(Items.GRASS_BLOCK)
                        .requires(Items.DARK_OAK_SAPLING)
                        .unlockedBy(getHasName(Items.DARK_OAK_SAPLING), has(Items.DARK_OAK_SAPLING))
                        .unlockedBy(getHasName(Items.GRASS_BLOCK), has(Items.GRASS_BLOCK))
                        .save(output, "craftable_podzol_from_grass-block_and_dark-oak-sapling");
                shaped(RecipeCategory.DECORATIONS, Items.REINFORCED_DEEPSLATE, 1)
                        .pattern("SES")
                        .pattern("EDE")
                        .pattern("SES")
                        .define('S', Items.NETHERITE_SCRAP)
                        .define('D', Items.CHISELED_DEEPSLATE)
                        .define('E', Items.ECHO_SHARD)
                        .unlockedBy(getHasName(Items.NETHERITE_SCRAP), has(Items.NETHERITE_SCRAP))
                        .unlockedBy(getHasName(Items.CHISELED_DEEPSLATE), has(Items.CHISELED_DEEPSLATE))
                        .unlockedBy(getHasName(Items.ECHO_SHARD), has(Items.ECHO_SHARD))
                        .save(output, "craftable_reinforced-deepslate_from_netherite-scraps_echo-shards_and_chiseled-deepslate");
                shaped(RecipeCategory.DECORATIONS, Items.ICE, 8)
                        .pattern("SSS")
                        .pattern("SWS")
                        .pattern("SSS")
                        .define('S', Items.SNOW_BLOCK)
                        .define('W', Items.WATER_BUCKET)
                        .unlockedBy(getHasName(Items.SNOW_BLOCK), has(Items.SNOW_BLOCK))
                        .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                        .save(output, "craftable_ice_from_snow-blocks_and_water-bucket");
            }
            private void buildCombatRecipes() {
                shaped(RecipeCategory.COMBAT, Items.TRIDENT, 1)
                        .pattern(" SS")
                        .pattern(" RS")
                        .pattern("R  ")
                        .define('S', Items.PRISMARINE_SHARD)
                        .define('R', Items.BREEZE_ROD)
                        .unlockedBy(getHasName(Items.PRISMARINE_SHARD), has(Items.PRISMARINE_SHARD))
                        .unlockedBy(getHasName(Items.BREEZE_ROD), has(Items.BREEZE_ROD))
                        .save(output, "craftable_trident_from_prismarine-shards_and_breeze-rods");
                shaped(RecipeCategory.COMBAT, Items.TOTEM_OF_UNDYING, 1)
                        .pattern("GEG")
                        .pattern("ESE")
                        .pattern("GEG")
                        .define('G', Items.GOLD_BLOCK)
                        .define('E', Items.EMERALD)
                        .define('S', Items.NETHER_STAR)
                        .unlockedBy(getHasName(Items.GOLD_BLOCK), has(Items.GOLD_BLOCK))
                        .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD))
                        .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                        .save(output, "craftable_totem-of-undying_from_gold-blocks_emeralds_and_nether-star");
                shaped(RecipeCategory.MISC, Items.ELYTRA, 1)
                        .pattern("PEP")
                        .pattern("PRP")
                        .pattern("P P")
                        .define('R', Items.END_ROD)
                        .define('P', Items.PHANTOM_MEMBRANE)
                        .define('E', Items.END_CRYSTAL)
                        .unlockedBy(getHasName(Items.PHANTOM_MEMBRANE), has(Items.PHANTOM_MEMBRANE))
                        .unlockedBy(getHasName(Items.END_CRYSTAL), has(Items.END_CRYSTAL))
                        .unlockedBy(getHasName(Items.END_ROD), has(Items.END_ROD))
                        .save(output, "craftable_elytra_from_end-crystal_phantom-membranes_and_end-rod");
            }
            private void buildAmethystRecipes() {
                shaped(RecipeCategory.COMBAT, Items.BUDDING_AMETHYST, 1)
                        .pattern("AAA")
                        .pattern("ANA")
                        .pattern("AAA")
                        .define('A', Items.AMETHYST_BLOCK)
                        .define('N', Items.NETHER_STAR)
                        .unlockedBy(getHasName(Items.AMETHYST_BLOCK), has(Items.AMETHYST_BLOCK))
                        .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                        .save(output, "craftable_budding-amethyst_from_amethyst-block_and_nether-star");
            }
            private void buildCoralRecipes() {
                shaped(RecipeCategory.DECORATIONS, Items.BRAIN_CORAL_BLOCK, 1)
                        .pattern("CC")
                        .pattern("CC")
                        .define('C', Items.BRAIN_CORAL_FAN)
                        .unlockedBy(getHasName(Items.BRAIN_CORAL_FAN), has(Items.BRAIN_CORAL_FAN))
                        .save(output, "craftable_brain-coral-block_from_brain-coral-fan");
                shaped(RecipeCategory.DECORATIONS, Items.BUBBLE_CORAL_BLOCK, 1)
                        .pattern("CC")
                        .pattern("CC")
                        .define('C', Items.BUBBLE_CORAL_FAN)
                        .unlockedBy(getHasName(Items.BUBBLE_CORAL_FAN), has(Items.BUBBLE_CORAL_FAN))
                        .save(output, "craftable_bubble-coral-block_from_bubble-coral-fan");
                shaped(RecipeCategory.DECORATIONS, Items.FIRE_CORAL_BLOCK, 1)
                        .pattern("CC")
                        .pattern("CC")
                        .define('C', Items.FIRE_CORAL_FAN)
                        .unlockedBy(getHasName(Items.FIRE_CORAL_FAN), has(Items.FIRE_CORAL_FAN))
                        .save(output, "craftable_fire-coral-block_from_fire-coral-fan");
                shaped(RecipeCategory.DECORATIONS, Items.TUBE_CORAL_BLOCK, 1)
                        .pattern("CC")
                        .pattern("CC")
                        .define('C', Items.TUBE_CORAL_FAN)
                        .unlockedBy(getHasName(Items.TUBE_CORAL_FAN), has(Items.TUBE_CORAL_FAN))
                        .save(output, "craftable_tube-coral-block_from_tube-coral-fan");
                shaped(RecipeCategory.DECORATIONS, Items.HORN_CORAL_BLOCK, 1)
                        .pattern("CC")
                        .pattern("CC")
                        .define('C', Items.HORN_CORAL_FAN)
                        .unlockedBy(getHasName(Items.HORN_CORAL_FAN), has(Items.HORN_CORAL_FAN))
                        .save(output, "craftable_horn-coral-block_from_horn-coral-fan");
                shaped(RecipeCategory.DECORATIONS, Items.DEAD_BRAIN_CORAL_BLOCK, 1)
                        .pattern("CC")
                        .pattern("CC")
                        .define('C', Items.DEAD_BRAIN_CORAL_FAN)
                        .unlockedBy(getHasName(Items.DEAD_BRAIN_CORAL_FAN), has(Items.DEAD_BRAIN_CORAL_FAN))
                        .save(output, "craftable_dead-brain-coral-block_from_dead-brain-coral-fan");
                shaped(RecipeCategory.DECORATIONS, Items.DEAD_BUBBLE_CORAL_BLOCK, 1)
                        .pattern("CC")
                        .pattern("CC")
                        .define('C', Items.DEAD_BUBBLE_CORAL_FAN)
                        .unlockedBy(getHasName(Items.DEAD_BUBBLE_CORAL_FAN), has(Items.DEAD_BUBBLE_CORAL_FAN))
                        .save(output, "craftable_dead-bubble-coral-block_from_dead-bubble-coral-fan");
                shaped(RecipeCategory.DECORATIONS, Items.DEAD_FIRE_CORAL_BLOCK, 1)
                        .pattern("CC")
                        .pattern("CC")
                        .define('C', Items.DEAD_FIRE_CORAL_FAN)
                        .unlockedBy(getHasName(Items.DEAD_FIRE_CORAL_FAN), has(Items.DEAD_FIRE_CORAL_FAN))
                        .save(output, "craftable_dead-fire-coral-block_from_dead-fire-coral-fan");
                shaped(RecipeCategory.DECORATIONS, Items.DEAD_HORN_CORAL_BLOCK, 1)
                        .pattern("CC")
                        .pattern("CC")
                        .define('C', Items.DEAD_HORN_CORAL_FAN)
                        .unlockedBy(getHasName(Items.DEAD_HORN_CORAL_FAN), has(Items.DEAD_HORN_CORAL_FAN))
                        .save(output, "craftable_dead-horn-coral-block_from_dead-horn-coral-fan");
                shaped(RecipeCategory.DECORATIONS, Items.DEAD_TUBE_CORAL_BLOCK, 1)
                        .pattern("CC")
                        .pattern("CC")
                        .define('C', Items.DEAD_TUBE_CORAL_FAN)
                        .unlockedBy(getHasName(Items.DEAD_TUBE_CORAL_FAN), has(Items.DEAD_TUBE_CORAL_FAN))
                        .save(output, "craftable_dead-tube-coral-block_from_dead-tube-coral-fan");
            }
            private void buildFroglightRecipes() {
                shaped(RecipeCategory.DECORATIONS, Items.OCHRE_FROGLIGHT, 1)
                        .pattern("DGD")
                        .pattern("GMG")
                        .pattern("DGD")
                        .define('G', Items.GLOWSTONE_DUST)
                        .define('D', Items.YELLOW_DYE)
                        .define('M', Items.MAGMA_BLOCK)
                        .unlockedBy(getHasName(Items.GLOWSTONE_DUST), has(Items.GLOWSTONE_DUST))
                        .unlockedBy(getHasName(Items.YELLOW_DYE), has(Items.YELLOW_DYE))
                        .unlockedBy(getHasName(Items.MAGMA_BLOCK), has(Items.MAGMA_BLOCK))
                        .save(output, "craftable_ochre-froglight_from_glowstone-dust_yellow-dyes_and_magma-block");
                shaped(RecipeCategory.DECORATIONS, Items.VERDANT_FROGLIGHT, 1)
                        .pattern("DGD")
                        .pattern("GMG")
                        .pattern("DGD")
                        .define('G', Items.GLOWSTONE_DUST)
                        .define('D', Items.GREEN_DYE)
                        .define('M', Items.MAGMA_BLOCK)
                        .unlockedBy(getHasName(Items.GLOWSTONE_DUST), has(Items.GLOWSTONE_DUST))
                        .unlockedBy(getHasName(Items.GREEN_DYE), has(Items.GREEN_DYE))
                        .unlockedBy(getHasName(Items.MAGMA_BLOCK), has(Items.MAGMA_BLOCK))
                        .save(output, "craftable_verdant-froglight_from_glowstone-dust_green-dyes_and_magma-block");
                shaped(RecipeCategory.DECORATIONS, Items.PEARLESCENT_FROGLIGHT, 1)
                        .pattern("DGD")
                        .pattern("GMG")
                        .pattern("DGD")
                        .define('G', Items.GLOWSTONE_DUST)
                        .define('D', Items.PURPLE_DYE)
                        .define('M', Items.MAGMA_BLOCK)
                        .unlockedBy(getHasName(Items.GLOWSTONE_DUST), has(Items.GLOWSTONE_DUST))
                        .unlockedBy(getHasName(Items.PURPLE_DYE), has(Items.PURPLE_DYE))
                        .unlockedBy(getHasName(Items.MAGMA_BLOCK), has(Items.MAGMA_BLOCK))
                        .save(output, "craftable_pearlescent-froglight_from_glowstone-dust_purple-dyes_and_magma-block");
            }
            private void buildMusicDiscs() {
                plusRecipeMaker(Items.BONE, Items.NOTE_BLOCK, Items.MUSIC_DISC_13, "craftable_disc-13_from_bones_and_note-block");
                plusRecipeMaker(Items.COD, Items.NOTE_BLOCK, Items.MUSIC_DISC_CAT, "craftable_disc-cat_from_cods_and_note-block");
                plusRecipeMaker(Items.SMOOTH_STONE, Items.NOTE_BLOCK, Items.MUSIC_DISC_BLOCKS, "craftable_disc-blocks_from_smooth-stones_and_note-block");
                plusRecipeMaker(Items.BRICK, Items.NOTE_BLOCK, Items.MUSIC_DISC_CHIRP, "craftable_disc-chirp_from_bricks_and_note-block");
                plusRecipeMaker(Items.CHORUS_FRUIT, Items.NOTE_BLOCK, Items.MUSIC_DISC_FAR, "craftable_disc-far_from_chorus-fruits_and_note-block");
                plusRecipeMaker(Items.EMERALD, Items.NOTE_BLOCK, Items.MUSIC_DISC_MALL, "craftable_disc-mall_from_emeralds_and_note-block");
                plusRecipeMaker(Items.CLOCK, Items.NOTE_BLOCK, Items.MUSIC_DISC_MELLOHI, "craftable_disc-mellohi_from_clocks_and_note-block");
                plusRecipeMaker(Items.BONE_MEAL, Items.NOTE_BLOCK, Items.MUSIC_DISC_STAL, "craftable_disc-stal_from_bone-meals_and_note-block");
                plusRecipeMaker(Items.SAND, Items.NOTE_BLOCK, Items.MUSIC_DISC_STRAD, "craftable_disc-strad_from_sand_and_note-block");
                plusRecipeMaker(Items.IRON_INGOT, Items.NOTE_BLOCK, Items.MUSIC_DISC_WARD, "craftable_disc-ward_from_iron-ingots_and_note-block");
                plusRecipeMaker(Items.CRACKED_STONE_BRICKS, Items.NOTE_BLOCK, Items.MUSIC_DISC_11, "craftable_disc-11_from_cracked-stone-bricks_and_note-block");
                plusRecipeMaker(Items.WATER_BUCKET, Items.NOTE_BLOCK, Items.MUSIC_DISC_WAIT, "craftable_disc-wait_from_water-buckets_and_note-block");
                plusRecipeMaker(Items.AMETHYST_SHARD, Items.NOTE_BLOCK, Items.MUSIC_DISC_OTHERSIDE, "craftable_disc-otherside_from_amethyst-shards_and_note-block");
                plusRecipeMaker(Items.NETHERITE_SCRAP, Items.NOTE_BLOCK, Items.MUSIC_DISC_PIGSTEP, "craftable_disc-pigstep_from_netherite-scrap_and_note-block");
                plusRecipeMaker(Items.DIAMOND, Items.NOTE_BLOCK, Items.MUSIC_DISC_RELIC, "craftable_disc-relic_from_diamonds_and_note-block");
                plusRecipeMaker(Items.COPPER_INGOT, Items.NOTE_BLOCK, Items.MUSIC_DISC_CREATOR, "craftable_disc-creator_from_copper-ingots_and_note-block");
                plusRecipeMaker(Items.COPPER_NUGGET, Items.NOTE_BLOCK, Items.MUSIC_DISC_CREATOR_MUSIC_BOX, "craftable_disc-creator-music-box_from_copper-nuggets_and_note-block");
                plusRecipeMaker(Items.COPPER_BLOCK, Items.NOTE_BLOCK, Items.MUSIC_DISC_PRECIPICE, "craftable_disc-precipice_from_copper-blocks_and_note-block");
                plusRecipeMaker(Items.GHAST_TEAR, Items.NOTE_BLOCK, Items.MUSIC_DISC_TEARS, "craftable_disc-tears_from_ghast-tears_and_note-block");
                plusRecipeMaker(Items.COOKED_CHICKEN, Items.NOTE_BLOCK, Items.MUSIC_DISC_LAVA_CHICKEN, "craftable_disc-lava-chicken_from_cooked_chicken_and_note-block");

            }
            private void buildHeadRecipes() {
                shaped(RecipeCategory.DECORATIONS, Items.SKELETON_SKULL, 1)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .define('B', Items.BONE)
                        .define('P', Items.CARVED_PUMPKIN)
                        .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
                        .unlockedBy(getHasName(Items.BONE), has(Items.BONE))
                        .save(output, "craftable_skeleton-skull_from_bones_and_carved-pumpkin");
                shaped(RecipeCategory.DECORATIONS, Items.WITHER_SKELETON_SKULL, 1)
                        .pattern("RRR")
                        .pattern("RPR")
                        .pattern("RRR")
                        .define('R', Items.WITHER_ROSE)
                        .define('P', Items.CARVED_PUMPKIN)
                        .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
                        .unlockedBy(getHasName(Items.WITHER_ROSE), has(Items.WITHER_ROSE))
                        .save(output, "craftable_wither-skeleton-skull_from_wither-roses_and_carved-pumpkin");
                shaped(RecipeCategory.DECORATIONS, Items.ZOMBIE_HEAD, 1)
                        .pattern("RRR")
                        .pattern("RPR")
                        .pattern("RRR")
                        .define('R', Items.ROTTEN_FLESH)
                        .define('P', Items.CARVED_PUMPKIN)
                        .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
                        .unlockedBy(getHasName(Items.ROTTEN_FLESH), has(Items.ROTTEN_FLESH))
                        .save(output, "craftable_zombie-head_from_rotten-flesh_and_carved-pumpkin");
                shaped(RecipeCategory.DECORATIONS, Items.CREEPER_HEAD, 1)
                        .pattern("GGG")
                        .pattern("GPG")
                        .pattern("GGG")
                        .define('G', Items.GUNPOWDER)
                        .define('P', Items.CARVED_PUMPKIN)
                        .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
                        .unlockedBy(getHasName(Items.GUNPOWDER), has(Items.GUNPOWDER))
                        .save(output, "craftable_creeper-head_from_gunpowder_and_carved-pumpkin");
                shaped(RecipeCategory.DECORATIONS, Items.PIGLIN_HEAD, 1)
                        .pattern("GGG")
                        .pattern("GPG")
                        .pattern("GGG")
                        .define('G', Items.GOLD_INGOT)
                        .define('P', Items.CARVED_PUMPKIN)
                        .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output, "craftable_piglin-head_from_gold-ingots_and_carved-pumpkin");
                shaped(RecipeCategory.DECORATIONS, Items.DRAGON_HEAD, 1)
                        .pattern("CDC")
                        .pattern("DPD")
                        .pattern("CDC")
                        .define('C', Items.END_CRYSTAL)
                        .define('D', Items.DRAGON_BREATH)
                        .define('P', Items.CARVED_PUMPKIN)
                        .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
                        .unlockedBy(getHasName(Items.END_CRYSTAL), has(Items.END_CRYSTAL))
                        .unlockedBy(getHasName(Items.DRAGON_BREATH), has(Items.DRAGON_BREATH))
                        .save(output, "craftable_dragon-head_from_end-crystals_dragon-breath_and_carved-pumpkin");
                shapeless(RecipeCategory.DECORATIONS, Items.PLAYER_HEAD, 1)
                        .requires(Items.NETHER_STAR)
                        .requires(Items.CARVED_PUMPKIN)
                        .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
                        .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                        .save(output, "craftable_player-head_from_nether-star_and_carved-pumpkin");
            }
            private void buildSherdRecipes() {
                shaped(RecipeCategory.MISC, Items.ANGLER_POTTERY_SHERD, 1)
                        .pattern(" C ")
                        .pattern("CBC")
                        .pattern(" C ")
                        .define('C', Items.COD)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.COD), has(Items.COD))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_angler-pottery-sherd_from_cods_and_brick");
                shaped(RecipeCategory.MISC, Items.ARMS_UP_POTTERY_SHERD, 1)
                        .pattern(" S ")
                        .pattern("SBS")
                        .pattern(" S ")
                        .define('S', Items.STICK)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_arms-up-pottery-sherd_from_sticks_and_brick");
                shaped(RecipeCategory.MISC, Items.ARCHER_POTTERY_SHERD, 1)
                        .pattern(" A ")
                        .pattern("ABA")
                        .pattern(" A ")
                        .define('A', Items.ARROW)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.ARROW), has(Items.ARROW))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_archer-pottery-sherd_from_arrows_and_brick");
                shaped(RecipeCategory.MISC, Items.BLADE_POTTERY_SHERD, 1)
                        .pattern(" F ")
                        .pattern("FBF")
                        .pattern(" F ")
                        .define('F', Items.FLINT)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_blade-pottery-sherd_from_flints_and_brick");
                shaped(RecipeCategory.MISC, Items.BREWER_POTTERY_SHERD, 1)
                        .pattern(" P ")
                        .pattern("PBP")
                        .pattern(" P ")
                        .define('P', Items.BLAZE_POWDER)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.BLAZE_POWDER), has(Items.BLAZE_POWDER))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_brewer-pottery-sherd_from_blaze-powders_and_brick");
                shaped(RecipeCategory.MISC, Items.BURN_POTTERY_SHERD, 1)
                        .pattern(" F ")
                        .pattern("FBF")
                        .pattern(" F ")
                        .define('F', Items.FLINT_AND_STEEL)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.FLINT_AND_STEEL), has(Items.FLINT_AND_STEEL))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_burn-pottery-sherd_from_flint-and-steel_and_brick");
                shaped(RecipeCategory.MISC, Items.DANGER_POTTERY_SHERD, 1)
                        .pattern(" G ")
                        .pattern("GBG")
                        .pattern(" G ")
                        .define('G', Items.GUNPOWDER)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.GUNPOWDER), has(Items.GUNPOWDER))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_danger-pottery-sherd_from_gunpowder_and_brick");
                shaped(RecipeCategory.MISC, Items.EXPLORER_POTTERY_SHERD, 1)
                        .pattern(" C ")
                        .pattern("CBC")
                        .pattern(" C ")
                        .define('C', Items.COMPASS)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.COMPASS), has(Items.COMPASS))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_explorer-pottery-sherd_from_compasses_and_brick");
                shaped(RecipeCategory.MISC, Items.FLOW_POTTERY_SHERD, 1)
                        .pattern(" D ")
                        .pattern("DBD")
                        .pattern(" D ")
                        .define('D', Items.BLUE_DYE)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.BLUE_DYE), has(Items.BLUE_DYE))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_flow-pottery-sherd_from_blue-dyes_and_brick");
                shaped(RecipeCategory.MISC, Items.FRIEND_POTTERY_SHERD, 1)
                        .pattern(" P ")
                        .pattern("PBP")
                        .pattern(" P ")
                        .define('P', Items.POPPY)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.POPPY), has(Items.POPPY))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_friend-pottery-sherd_from_poppies_and_brick");
                shaped(RecipeCategory.MISC, Items.GUSTER_POTTERY_SHERD, 1)
                        .pattern(" W ")
                        .pattern("WBW")
                        .pattern(" W ")
                        .define('W', Items.WIND_CHARGE)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.WIND_CHARGE), has(Items.WIND_CHARGE))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_guster-pottery-sherd_from_wind-charges_and_brick");
                shaped(RecipeCategory.MISC, Items.HEART_POTTERY_SHERD, 1)
                        .pattern(" R ")
                        .pattern("RBR")
                        .pattern(" R ")
                        .define('R', Items.RED_DYE)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.RED_DYE), has(Items.RED_DYE))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_heart-pottery-sherd_from_red-dyes_and_brick");
                shaped(RecipeCategory.MISC, Items.HEARTBREAK_POTTERY_SHERD, 1)
                        .pattern(" E ")
                        .pattern("EBE")
                        .pattern(" E ")
                        .define('E', Items.FERMENTED_SPIDER_EYE)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.FERMENTED_SPIDER_EYE), has(Items.FERMENTED_SPIDER_EYE))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_heartbreak-pottery-sherd_from_fermented-eyes_and_brick");
                shaped(RecipeCategory.MISC, Items.HOWL_POTTERY_SHERD, 1)
                        .pattern(" A ")
                        .pattern("ABA")
                        .pattern(" A ")
                        .define('A', Items.BONE)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.BONE), has(Items.BONE))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_howl-pottery-sherd_from_bones_and_brick");
                shaped(RecipeCategory.MISC, Items.MINER_POTTERY_SHERD, 1)
                        .pattern(" C ")
                        .pattern("CBC")
                        .pattern(" C ")
                        .define('C', Items.COAL)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.COAL), has(Items.COAL))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_miner-pottery-sherd_from_coals_and_brick");
                shaped(RecipeCategory.MISC, Items.MOURNER_POTTERY_SHERD, 1)
                        .pattern(" S ")
                        .pattern("SBS")
                        .pattern(" S ")
                        .define('S', Items.SCULK)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.SCULK), has(Items.SCULK))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_mourner-pottery-sherd_from_sculks_and_brick");
                shaped(RecipeCategory.MISC, Items.PLENTY_POTTERY_SHERD, 1)
                        .pattern(" W ")
                        .pattern("WBW")
                        .pattern(" W ")
                        .define('W', Items.WHEAT)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_plenty-pottery-sherd_from_wheats_and_brick");
                shaped(RecipeCategory.MISC, Items.PRIZE_POTTERY_SHERD, 1)
                        .pattern(" G ")
                        .pattern("GBG")
                        .pattern(" G ")
                        .define('G', Items.GOLD_INGOT)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_prize-pottery-sherd_from_gold-ingots_and_brick");
                shaped(RecipeCategory.MISC, Items.SHELTER_POTTERY_SHERD, 1)
                        .pattern(" O ")
                        .pattern("OBO")
                        .pattern(" O ")
                        .define('O', Items.OAK_PLANKS)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_shelter-pottery-sherd_from_oak-planks_and_brick");
                shaped(RecipeCategory.MISC, Items.SKULL_POTTERY_SHERD, 1)
                        .pattern(" A ")
                        .pattern("ABA")
                        .pattern(" A ")
                        .define('A', Items.BONE_MEAL)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.BONE_MEAL), has(Items.BONE_MEAL))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_skull-pottery-sherd_from_bone-meals_and_brick");
                shaped(RecipeCategory.MISC, Items.SCRAPE_POTTERY_SHERD, 1)
                        .pattern(" A ")
                        .pattern("ABA")
                        .pattern(" A ")
                        .define('A', Items.COPPER_AXE)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.COPPER_AXE), has(Items.COPPER_AXE))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_scrape-pottery-sherd_from_copper-axes_and_brick");
                shaped(RecipeCategory.MISC, Items.SNORT_POTTERY_SHERD, 1)
                        .pattern(" T ")
                        .pattern("TBT")
                        .pattern(" T ")
                        .define('T', Items.TORCHFLOWER_SEEDS)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.TORCHFLOWER_SEEDS), has(Items.TORCHFLOWER_SEEDS))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_snort-pottery-sherd_from_torch-flower-seeds_and_brick");
                shaped(RecipeCategory.MISC, Items.SHEAF_POTTERY_SHERD, 1)
                        .pattern(" H ")
                        .pattern("HBH")
                        .pattern(" H ")
                        .define('H', Items.HAY_BLOCK)
                        .define('B', Items.BRICK)
                        .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                        .unlockedBy(getHasName(Items.HAY_BLOCK), has(Items.HAY_BLOCK))
                        .unlockedBy(getHasName(Items.DECORATED_POT), has(Items.DECORATED_POT))
                        .save(output, "craftable_sheaf-pottery-sherd_from_hay-blocks_and_brick");
            }
            private void buildHorseArmorRecipes() {
                shaped(RecipeCategory.COMBAT, Items.COPPER_HORSE_ARMOR, 1)
                        .pattern("  C")
                        .pattern("CCC")
                        .pattern("C C")
                        .define('C', Items.COPPER_INGOT)
                        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(output, "craftable_copper-horse-armor_from_copper-ingots");
                shaped(RecipeCategory.COMBAT, Items.IRON_HORSE_ARMOR, 1)
                        .pattern("  I")
                        .pattern("III")
                        .pattern("I I")
                        .define('I', Items.IRON_INGOT)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output, "craftable_iron-horse-armor_from_iron-ingots");
                shaped(RecipeCategory.COMBAT, Items.GOLDEN_HORSE_ARMOR, 1)
                        .pattern("  G")
                        .pattern("GGG")
                        .pattern("G G")
                        .define('G', Items.GOLD_INGOT)
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output, "craftable_gold-horse-armor_from_gold-ingots");
                shaped(RecipeCategory.COMBAT, Items.DIAMOND_HORSE_ARMOR, 1)
                        .pattern("  D")
                        .pattern("DDD")
                        .pattern("D D")
                        .define('D', Items.DIAMOND)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output, "craftable_diamond-horse-armor_from_diamonds");
            }
            private void buildCopperItemRecipes() {
                //Exposed:
                plusRecipeMaker(Items.MUD, Items.COPPER_BLOCK, Items.EXPOSED_COPPER, "craftable_exposed-copper-block_from_mud_and_copper-block");
                plusRecipeMaker(Items.MUD, Items.COPPER_BULB, Items.EXPOSED_COPPER_BULB, "craftable_exposed-copper-bulb_from_mud_and_copper-bulb");
                plusRecipeMaker(Items.MUD, Items.COPPER_CHEST, Items.EXPOSED_COPPER_CHEST, "craftable_exposed-copper-chest_from_mud_and_copper-chest");
                plusRecipeMaker(Items.MUD, Items.COPPER_DOOR, Items.EXPOSED_COPPER_DOOR, "craftable_exposed-copper-door_from_mud_and_copper-door");
                plusRecipeMaker(Items.MUD, Items.COPPER_GRATE, Items.EXPOSED_COPPER_GRATE, "craftable_exposed-copper-grate_from_mud_and_copper-grate");
                plusRecipeMaker(Items.MUD, Items.COPPER_GOLEM_STATUE, Items.EXPOSED_COPPER_GOLEM_STATUE, "craftable_exposed-copper-golem-statue_from_mud_and_copper-golem-statue");
                plusRecipeMaker(Items.MUD, Items.COPPER_TRAPDOOR, Items.EXPOSED_COPPER_TRAPDOOR, "craftable_exposed-copper-trapdoor_from_mud_and_copper-trapdoor");
                plusRecipeMaker(Items.MUD, Items.CUT_COPPER_SLAB, Items.EXPOSED_CUT_COPPER_SLAB, "craftable_exposed-cut-copper-slab_from_mud_and_cut-copper-slab");
                plusRecipeMaker(Items.MUD, Items.CUT_COPPER_STAIRS, Items.EXPOSED_CUT_COPPER_STAIRS, "craftable_exposed-cut-copper-stairs_from_mud_and_cut-copper-stairs");
                plusRecipeMaker(Items.MUD, Items.CHISELED_COPPER, Items.EXPOSED_CHISELED_COPPER, "craftable_exposed-chiseled-copper_from_mud_and_chiseled-copper");
                plusRecipeMaker(Items.MUD, Items.LIGHTNING_ROD, Items.EXPOSED_LIGHTNING_ROD, "craftable_exposed-lightning-rod_from_mud_and_lightning-rod");
                plusRecipeMaker(Items.MUD, Items.CUT_COPPER, Items.EXPOSED_CUT_COPPER, "craftable_exposed-cut-copper_from_mud_and_cut-copper");
                //Weathered:
                plusRecipeMaker(Items.VINE, Items.EXPOSED_COPPER, Items.WEATHERED_COPPER, "craftable_weathered-copper-block_from_vines_and_exposed-copper-block");
                plusRecipeMaker(Items.VINE, Items.EXPOSED_COPPER_BULB, Items.WEATHERED_COPPER_BULB, "craftable_weathered-copper-bulb_from_vines_and_exposed-copper-bulb");
                plusRecipeMaker(Items.VINE, Items.EXPOSED_COPPER_CHEST, Items.WEATHERED_COPPER_CHEST, "craftable_weathered-copper-chest_from_vines_and_exposed-copper-chest");
                plusRecipeMaker(Items.VINE, Items.EXPOSED_COPPER_DOOR, Items.WEATHERED_COPPER_DOOR, "craftable_weathered-copper-door_from_vines_and_exposed-copper-door");
                plusRecipeMaker(Items.VINE, Items.EXPOSED_COPPER_GRATE, Items.WEATHERED_COPPER_GRATE, "craftable_weathered-copper-grate_from_vines_and_exposed-copper-grate");
                plusRecipeMaker(Items.VINE, Items.EXPOSED_COPPER_GOLEM_STATUE, Items.WEATHERED_COPPER_GOLEM_STATUE, "craftable_weathered-copper-golem-statue_from_vines_and_exposed-copper-golem-statue");
                plusRecipeMaker(Items.VINE, Items.EXPOSED_COPPER_TRAPDOOR, Items.WEATHERED_COPPER_TRAPDOOR, "craftable_weathered-copper-trapdoor_from_vines_and_exposed-copper-trapdoor");
                plusRecipeMaker(Items.VINE, Items.EXPOSED_CUT_COPPER_SLAB, Items.WEATHERED_CUT_COPPER_SLAB, "craftable_weathered-cut-copper-slab_from_vines_and_exposed-cut-copper-slab");
                plusRecipeMaker(Items.VINE, Items.EXPOSED_CUT_COPPER_STAIRS, Items.WEATHERED_CUT_COPPER_STAIRS, "craftable_weathered-cut-copper-stairs_from_vines_and_exposed-cut-copper-stairs");
                plusRecipeMaker(Items.VINE, Items.EXPOSED_CHISELED_COPPER, Items.WEATHERED_CHISELED_COPPER, "craftable_weathered-chiseled-copper_from_vines_and_exposed-chiseled-copper");
                plusRecipeMaker(Items.VINE, Items.EXPOSED_LIGHTNING_ROD, Items.WEATHERED_LIGHTNING_ROD, "craftable_weathered-lightning-rod_from_vines_and_exposed-lightning-rod");
                plusRecipeMaker(Items.VINE, Items.EXPOSED_CUT_COPPER, Items.WEATHERED_CUT_COPPER, "craftable_weathered-cut-copper_from_vines_and_exposed-cut-copper");
                //Oxidized:
                plusRecipeMaker(Items.MOSS_BLOCK, Items.WEATHERED_COPPER, Items.OXIDIZED_COPPER, "craftable_oxidized-copper-block_from_moss-blocks_and_weathered-copper-block");
                plusRecipeMaker(Items.MOSS_BLOCK, Items.WEATHERED_COPPER_BULB, Items.OXIDIZED_COPPER_BULB, "craftable_oxidized-copper-bulb_from_moss-blocks_and_weathered-copper-bulb");
                plusRecipeMaker(Items.MOSS_BLOCK, Items.WEATHERED_COPPER_CHEST, Items.OXIDIZED_COPPER_CHEST, "craftable_oxidized-copper-chest_from_moss-blocks_and_weathered-copper-chest");
                plusRecipeMaker(Items.MOSS_BLOCK, Items.WEATHERED_COPPER_DOOR, Items.OXIDIZED_COPPER_DOOR, "craftable_oxidized-copper-door_from_moss-blocks_and_weathered-copper-door");
                plusRecipeMaker(Items.MOSS_BLOCK, Items.WEATHERED_COPPER_GRATE, Items.OXIDIZED_COPPER_GRATE, "craftable_oxidized-copper-grate_from_moss-blocks_and_weathered-copper-grate");
                plusRecipeMaker(Items.MOSS_BLOCK, Items.WEATHERED_COPPER_GOLEM_STATUE, Items.OXIDIZED_COPPER_GOLEM_STATUE, "craftable_oxidized-copper-golem-statue_from_moss-blocks_and_weathered-copper-golem-statue");
                plusRecipeMaker(Items.MOSS_BLOCK, Items.WEATHERED_COPPER_TRAPDOOR, Items.OXIDIZED_COPPER_TRAPDOOR, "craftable_oxidized-copper-trapdoor_from_moss-blocks_and_weathered-copper-trapdoor");
                plusRecipeMaker(Items.MOSS_BLOCK, Items.WEATHERED_CUT_COPPER_SLAB, Items.OXIDIZED_CUT_COPPER_SLAB, "craftable_oxidized-cut-copper-slab_from_moss-blocks_and_weathered-cut-copper-slab");
                plusRecipeMaker(Items.MOSS_BLOCK, Items.WEATHERED_CUT_COPPER_STAIRS, Items.OXIDIZED_CUT_COPPER_STAIRS, "craftable_oxidized-cut-copper-stairs_from_moss-blocks_and_weathered-cut-copper-stairs");
                plusRecipeMaker(Items.MOSS_BLOCK, Items.WEATHERED_CHISELED_COPPER, Items.OXIDIZED_CHISELED_COPPER, "craftable_oxidized-chiseled-copper_from_moss-blocks_and_weathered-chiseled-copper");
                plusRecipeMaker(Items.MOSS_BLOCK, Items.WEATHERED_LIGHTNING_ROD, Items.OXIDIZED_LIGHTNING_ROD, "craftable_oxidized-lightning-rod_from_moss-blocks_and_weathered-lightning-rod");
                plusRecipeMaker(Items.MOSS_BLOCK, Items.WEATHERED_CUT_COPPER, Items.OXIDIZED_CUT_COPPER, "craftable_oxidized-cut-copper_from_moss-blocks_and_weathered-cut-copper");
            }
            private void buildMushroomItemRecipes() {
                shaped(RecipeCategory.DECORATIONS, Items.BROWN_MUSHROOM_BLOCK, 1)
                        .pattern("BB")
                        .pattern("BB")
                        .define('B', Items.BROWN_MUSHROOM)
                        .unlockedBy(getHasName(Items.BROWN_MUSHROOM), has(Items.BROWN_MUSHROOM))
                        .save(output, "craftable_brown-mushroom-block_from_brown-mushrooms");
                shaped(RecipeCategory.DECORATIONS, Items.RED_MUSHROOM_BLOCK, 1)
                        .pattern("RR")
                        .pattern("RR")
                        .define('R', Items.RED_MUSHROOM)
                        .unlockedBy(getHasName(Items.RED_MUSHROOM), has(Items.RED_MUSHROOM))
                        .save(output, "craftable_red-mushroom-block_from_red-mushrooms");
                shaped(RecipeCategory.DECORATIONS, Items.MUSHROOM_STEM, 1)
                        .pattern("BRB")
                        .pattern("R R")
                        .pattern("BRB")
                        .define('B', Items.BROWN_MUSHROOM)
                        .define('R', Items.RED_MUSHROOM)
                        .unlockedBy(getHasName(Items.BROWN_MUSHROOM), has(Items.BROWN_MUSHROOM))
                        .unlockedBy(getHasName(Items.RED_MUSHROOM), has(Items.RED_MUSHROOM))
                        .save(output, "craftable_mushroom-stem_from_brown-mushrooms_and_red-mushrooms");
                shaped(RecipeCategory.DECORATIONS, Items.SHROOMLIGHT, 1)
                        .pattern(" G ")
                        .pattern("GSG")
                        .pattern(" G ")
                        .define('G', Items.GLOWSTONE_DUST)
                        .define('S', Items.MUSHROOM_STEM)
                        .unlockedBy(getHasName(Items.GLOWSTONE_DUST), has(Items.GLOWSTONE_DUST))
                        .unlockedBy(getHasName(Items.MUSHROOM_STEM), has(Items.MUSHROOM_STEM))
                        .save(output, "craftable_shroomlight_from_glowstone-dust_and_mushroom-stem");
            }
            private void buildSmallDecorativeItemRecipes() { //By "Small Decorative Item" I mean "blocks" (because technically they aren't blocks) that are smaller than a regular block (don't fully cover the given space), and some of them can be placed multiple times in the same place.
                shapeless(RecipeCategory.DECORATIONS, Items.DEAD_BUSH, 1)
                        .requires(CraftableTags.SAPLINGS)
                        .requires(Items.SAND)
                        .unlockedBy(getHasName(Items.SAND), has(Items.SAND))
                        .save(output, "craftable_dead-bush_from_sand_and_sapling");
                shapeless(RecipeCategory.DECORATIONS, Items.SEA_PICKLE, 2)
                        .requires(Items.CACTUS)
                        .requires(Items.GLOW_INK_SAC)
                        .unlockedBy(getHasName(Items.CACTUS), has(Items.CACTUS))
                        .unlockedBy(getHasName(Items.GLOW_INK_SAC), has(Items.GLOW_INK_SAC))
                        .save(output, "craftable_sea-pickle_from_cactus_and_glow-ink-sac");
                shapeless(RecipeCategory.DECORATIONS, Items.SMALL_DRIPLEAF, 2)
                        .requires(Items.BIG_DRIPLEAF)
                        .requires(Items.SHEARS)
                        .unlockedBy(getHasName(Items.BIG_DRIPLEAF), has(Items.BIG_DRIPLEAF))
                        .unlockedBy(getHasName(Items.SHEARS), has(Items.SHEARS))
                        .save(output, "craftable_small-dripleaf_from_big-dripleaf_and_shears");
                shapeless(RecipeCategory.DECORATIONS, Items.BIG_DRIPLEAF, 1)
                        .requires(Items.SMALL_DRIPLEAF, 2)
                        .unlockedBy(getHasName(Items.SMALL_DRIPLEAF), has(Items.SMALL_DRIPLEAF))
                        .save(output, "craftable_big-dripleaf_from_small-dripleafs");
                shapeless(RecipeCategory.DECORATIONS, Items.LARGE_FERN, 1)
                        .requires(Items.FERN, 2)
                        .unlockedBy(getHasName(Items.FERN), has(Items.FERN))
                        .save(output, "craftable_large-fern_from_ferns");
                shapeless(RecipeCategory.DECORATIONS, Items.FERN, 2)
                        .requires(Items.LARGE_FERN)
                        .unlockedBy(getHasName(Items.LARGE_FERN), has(Items.LARGE_FERN))
                        .save(output, "craftable_fern_from_large-fern");
                shapeless(RecipeCategory.DECORATIONS, Items.TALL_GRASS, 1)
                        .requires(Items.SHORT_GRASS, 2)
                        .unlockedBy(getHasName(Items.SHORT_GRASS), has(Items.SHORT_GRASS))
                        .save(output, "craftable_tall-grass_from_short-grass");
                shapeless(RecipeCategory.DECORATIONS, Items.SHORT_GRASS, 2)
                        .requires(Items.TALL_GRASS, 1)
                        .unlockedBy(getHasName(Items.TALL_GRASS), has(Items.TALL_GRASS))
                        .save(output, "craftable_short-grass_from_tall-grass");
                shapeless(RecipeCategory.DECORATIONS, Items.DRY_TALL_GRASS, 1)
                        .requires(Items.DRY_SHORT_GRASS, 2)
                        .unlockedBy(getHasName(Items.DRY_SHORT_GRASS), has(Items.DRY_SHORT_GRASS))
                        .save(output, "craftable_dry-tall-grass_from_dry-short-grass");
                shapeless(RecipeCategory.DECORATIONS, Items.DRY_SHORT_GRASS, 1)
                        .requires(Items.DRY_TALL_GRASS, 2)
                        .unlockedBy(getHasName(Items.DRY_TALL_GRASS), has(Items.DRY_TALL_GRASS))
                        .save(output, "craftable_dry-short-grass_from_dry-tall-grass");
                shapeless(RecipeCategory.MISC, Items.FROGSPAWN, 1)
                        .requires(Items.SLIME_BALL)
                        .requires(Items.LILY_PAD)
                        .requires(Items.WATER_BUCKET)
                        .unlockedBy(getHasName(Items.SLIME_BALL), has(Items.SLIME_BALL))
                        .unlockedBy(getHasName(Items.LILY_PAD), has(Items.LILY_PAD))
                        .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                        .save(output, "craftable_frogspawn_from_slime-ball_lily-pad_and_water-bucket");
                shaped(RecipeCategory.DECORATIONS, Items.SPORE_BLOSSOM, 2)
                        .pattern("PMP")
                        .pattern("MGM")
                        .pattern("PMP")
                        .define('P', Items.PINK_TULIP)
                        .define('M', Items.MOSS_BLOCK)
                        .define('G', Items.GLOW_BERRIES)
                        .unlockedBy(getHasName(Items.PINK_TULIP), has(Items.PINK_TULIP))
                        .unlockedBy(getHasName(Items.MOSS_BLOCK), has(Items.MOSS_BLOCK))
                        .unlockedBy(getHasName(Items.GLOW_BERRIES), has(Items.GLOW_BERRIES))
                        .save(output, "craftable_spore-blossom_from_glow-berries_pink_tulips_and_moss-blocks");
            }
            private void buildTulipRecipes() {
                shapeless(RecipeCategory.DECORATIONS, Items.WHITE_TULIP, 1)
                        .requires(CraftableTags.WHITE_TULIP_BASE)
                        .requires(Items.WHITE_DYE)
                        .unlockedBy(getHasName(Items.RED_TULIP), has(Items.RED_TULIP))
                        .unlockedBy(getHasName(Items.PINK_TULIP), has(Items.PINK_TULIP))
                        .unlockedBy(getHasName(Items.ORANGE_TULIP), has(Items.ORANGE_TULIP))
                        .unlockedBy(getHasName(Items.WHITE_DYE), has(Items.WHITE_DYE))
                        .save(output, "craftable_white-tulip_from_white-dye_and_tulip");
                shapeless(RecipeCategory.DECORATIONS, Items.ORANGE_TULIP, 1)
                        .requires(CraftableTags.ORANGE_TULIP_BASE)
                        .requires(Items.ORANGE_DYE)
                        .unlockedBy(getHasName(Items.WHITE_TULIP), has(Items.WHITE_TULIP))
                        .unlockedBy(getHasName(Items.RED_TULIP), has(Items.RED_TULIP))
                        .unlockedBy(getHasName(Items.PINK_TULIP), has(Items.PINK_TULIP))
                        .unlockedBy(getHasName(Items.ORANGE_DYE), has(Items.ORANGE_DYE))
                        .save(output, "craftable_orange-tulip_from_orange-dye_and_tulip");
                shapeless(RecipeCategory.DECORATIONS, Items.PINK_TULIP, 1)
                        .requires(CraftableTags.PINK_TULIP_BASE)
                        .requires(Items.PINK_DYE)
                        .unlockedBy(getHasName(Items.WHITE_TULIP), has(Items.WHITE_TULIP))
                        .unlockedBy(getHasName(Items.RED_TULIP), has(Items.RED_TULIP))
                        .unlockedBy(getHasName(Items.ORANGE_TULIP), has(Items.ORANGE_TULIP))
                        .unlockedBy(getHasName(Items.PINK_DYE), has(Items.PINK_DYE))
                        .save(output, "craftable_pink-tulip_from_pink-dye_and_tulip");
                shapeless(RecipeCategory.DECORATIONS, Items.RED_TULIP, 1)
                        .requires(CraftableTags.RED_TULIP_BASE)
                        .requires(Items.RED_DYE)
                        .unlockedBy(getHasName(Items.WHITE_TULIP), has(Items.WHITE_TULIP))
                        .unlockedBy(getHasName(Items.ORANGE_TULIP), has(Items.ORANGE_TULIP))
                        .unlockedBy(getHasName(Items.PINK_TULIP), has(Items.PINK_TULIP))
                        .unlockedBy(getHasName(Items.RED_DYE), has(Items.RED_DYE))
                        .save(output, "craftable_red-tulip_from_red-dye_and_tulip");
            }
            private void buildThrowableItemRecipes() {
                shapeless(RecipeCategory.MISC, Items.EXPERIENCE_BOTTLE, 1)
                        .requires(Items.SPLASH_POTION)
                        .requires(Items.DRAGON_BREATH)
                        .unlockedBy(getHasName(Items.SPLASH_POTION), has(Items.SPLASH_POTION))
                        .unlockedBy(getHasName(Items.DRAGON_BREATH), has(Items.DRAGON_BREATH))
                        .save(output, "craftable_experience-bottle_from_splash-potion_and_dragon-breath");
            }
            private void buildInfestedBlockRecipes() {
                shapeless(RecipeCategory.DECORATIONS, Items.INFESTED_STONE, 1)
                        .requires(Items.STONE)
                        .requires(Items.SPIDER_EYE)
                        .unlockedBy(getHasName(Items.STONE), has(Items.STONE))
                        .unlockedBy(getHasName(Items.SPIDER_EYE), has(Items.SPIDER_EYE))
                        .save(output, "craftable_infested-stone_from_stone_and_spider-eye");
                shapeless(RecipeCategory.DECORATIONS, Items.INFESTED_COBBLESTONE, 1)
                        .requires(Items.COBBLESTONE)
                        .requires(Items.SPIDER_EYE)
                        .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                        .unlockedBy(getHasName(Items.SPIDER_EYE), has(Items.SPIDER_EYE))
                        .save(output, "craftable_infested-cobblestone_from_cobblestone_and_spider-eye");
                shapeless(RecipeCategory.DECORATIONS, Items.INFESTED_STONE_BRICKS, 1)
                        .requires(Items.STONE_BRICKS)
                        .requires(Items.SPIDER_EYE)
                        .unlockedBy(getHasName(Items.STONE_BRICKS), has(Items.STONE_BRICKS))
                        .unlockedBy(getHasName(Items.SPIDER_EYE), has(Items.SPIDER_EYE))
                        .save(output, "craftable_infested-stone-bricks_from_stone-bricks_and_spider-eye");
                shapeless(RecipeCategory.DECORATIONS, Items.INFESTED_MOSSY_STONE_BRICKS, 1)
                        .requires(Items.MOSSY_STONE_BRICKS)
                        .requires(Items.SPIDER_EYE)
                        .unlockedBy(getHasName(Items.MOSSY_STONE_BRICKS), has(Items.MOSSY_STONE_BRICKS))
                        .unlockedBy(getHasName(Items.SPIDER_EYE), has(Items.SPIDER_EYE))
                        .save(output, "craftable_infested-mossy-stone-bricks_from_mossy-stone-bricks_and_spider-eye");
                shapeless(RecipeCategory.DECORATIONS, Items.INFESTED_CRACKED_STONE_BRICKS, 1)
                        .requires(Items.CRACKED_STONE_BRICKS)
                        .requires(Items.SPIDER_EYE)
                        .unlockedBy(getHasName(Items.CRACKED_STONE_BRICKS), has(Items.CRACKED_STONE_BRICKS))
                        .unlockedBy(getHasName(Items.SPIDER_EYE), has(Items.SPIDER_EYE))
                        .save(output, "craftable_infested-cracked-stone-bricks_from_cracked-stone-bricks_and_spider-eye");
                shapeless(RecipeCategory.DECORATIONS, Items.INFESTED_CHISELED_STONE_BRICKS, 1)
                        .requires(Items.CHISELED_STONE_BRICKS)
                        .requires(Items.SPIDER_EYE)
                        .unlockedBy(getHasName(Items.CHISELED_STONE_BRICKS), has(Items.CHISELED_STONE_BRICKS))
                        .unlockedBy(getHasName(Items.SPIDER_EYE), has(Items.SPIDER_EYE))
                        .save(output, "craftable_infested-chiseled-stone-bricks_from_chiseled-stone-bricks_and_spider-eye");
                shapeless(RecipeCategory.DECORATIONS, Items.INFESTED_DEEPSLATE, 1)
                        .requires(Items.DEEPSLATE)
                        .requires(Items.SPIDER_EYE)
                        .unlockedBy(getHasName(Items.DEEPSLATE), has(Items.DEEPSLATE))
                        .unlockedBy(getHasName(Items.SPIDER_EYE), has(Items.SPIDER_EYE))
                        .save(output, "craftable_infested-deepslate_from_deepslate_and_spider-eye");
            }
            private void buildRawBlockRecipes() {
                List<ItemLike> COPPER_BLOCK_SMELTABLES = List.of(Items.RAW_COPPER_BLOCK);
                List<ItemLike> IRON_BLOCK_SMELTABLES = List.of(Items.RAW_IRON_BLOCK, Items.ANVIL, Items.CHIPPED_ANVIL, Items.DAMAGED_ANVIL);
                List<ItemLike> GOLD_BLOCK_SMELTABLES = List.of(Items.RAW_GOLD_BLOCK);
                oreSmelting(COPPER_BLOCK_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Items.COPPER_BLOCK, 0.25f, 200, "copper_ingot");
                oreBlasting(COPPER_BLOCK_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Items.COPPER_BLOCK, 0.25f, 100, "copper_ingot");
                oreSmelting(IRON_BLOCK_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Items.IRON_BLOCK, 0.25f, 200, "iron_ingot");
                oreBlasting(IRON_BLOCK_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Items.IRON_BLOCK, 0.25f, 100, "iron_ingot");
                oreSmelting(GOLD_BLOCK_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Items.GOLD_BLOCK, 0.25f, 200, "gold_ingot");
                oreBlasting(GOLD_BLOCK_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Items.GOLD_BLOCK, 0.25f, 100, "gold_ingot");
            }
            private void buildOtherSmeltableRecipes() {
                List<ItemLike> LEATHER_SMELTABLES = List.of(Items.ROTTEN_FLESH);
                oreSmelting(LEATHER_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, Items.LEATHER, 0.25f, 200, "leather");
                oreBlasting(LEATHER_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, Items.LEATHER, 0.25f, 100, "leather");
            }
            private void buildNautilusArmorRecipes() {
                shaped(RecipeCategory.COMBAT, Items.COPPER_NAUTILUS_ARMOR, 1)
                        .pattern("CCC")
                        .pattern("CNC")
                        .pattern("CCC")
                        .define('C', Items.COPPER_BLOCK)
                        .define('N', Items.NAUTILUS_SHELL)
                        .unlockedBy(getHasName(Items.COPPER_BLOCK), has(Items.COPPER_BLOCK))
                        .unlockedBy(getHasName(Items.NAUTILUS_SHELL), has(Items.NAUTILUS_SHELL))
                        .save(output, "craftable_copper-nautilus-armor_from_nautilus-shell_and_copper-blocks");
                shaped(RecipeCategory.COMBAT, Items.IRON_NAUTILUS_ARMOR, 1)
                        .pattern("III")
                        .pattern("INI")
                        .pattern("III")
                        .define('I', Items.IRON_BLOCK)
                        .define('N', Items.COPPER_NAUTILUS_ARMOR)
                        .unlockedBy(getHasName(Items.IRON_BLOCK), has(Items.IRON_BLOCK))
                        .unlockedBy(getHasName(Items.COPPER_NAUTILUS_ARMOR), has(Items.COPPER_NAUTILUS_ARMOR))
                        .save(output, "craftable_iron-nautilus-armor_from_copper-nautilus-armor_and_iron-blocks");
                shaped(RecipeCategory.COMBAT, Items.GOLDEN_NAUTILUS_ARMOR, 1)
                        .pattern("GGG")
                        .pattern("GNG")
                        .pattern("GGG")
                        .define('G', Items.GOLD_BLOCK)
                        .define('N', Items.IRON_NAUTILUS_ARMOR)
                        .unlockedBy(getHasName(Items.GOLD_BLOCK), has(Items.GOLD_BLOCK))
                        .unlockedBy(getHasName(Items.IRON_NAUTILUS_ARMOR), has(Items.IRON_NAUTILUS_ARMOR))
                        .save(output, "craftable_golden-nautilus-armor_from_iron-nautilus-armor_and_gold-blocks");
                shaped(RecipeCategory.COMBAT, Items.DIAMOND_NAUTILUS_ARMOR, 1)
                        .pattern("DDD")
                        .pattern("DND")
                        .pattern("DDD")
                        .define('D', Items.DIAMOND_BLOCK)
                        .define('N', Items.GOLDEN_NAUTILUS_ARMOR)
                        .unlockedBy(getHasName(Items.DIAMOND_BLOCK), has(Items.DIAMOND_BLOCK))
                        .unlockedBy(getHasName(Items.GOLDEN_NAUTILUS_ARMOR), has(Items.GOLDEN_NAUTILUS_ARMOR))
                        .save(output, "craftable_diamond-nautilus-armor_from_golden-nautilus-armor_and_diamond-blocks");
            }

            @Override
            public void buildRecipes() {
                buildChainmailRecipes();
                buildFoodRecipes();
                buildComponentRecipes();
                buildDecorativeBlockRecipes();
                buildCombatRecipes();
                buildAmethystRecipes();
                buildCoralRecipes();
                buildFroglightRecipes();
                buildMusicDiscs();
                buildHeadRecipes();
                buildSherdRecipes();
                buildHorseArmorRecipes();
                buildCopperItemRecipes();
                buildMushroomItemRecipes();
                buildSmallDecorativeItemRecipes();
                buildTulipRecipes();
                buildThrowableItemRecipes();
                buildInfestedBlockRecipes();
                buildRawBlockRecipes();
                buildOtherSmeltableRecipes();
                buildNautilusArmorRecipes();
            }
        };
    }
    @Override
    public String getName() {
        return "Craftable: Recipes"; //it should be unique
    }
}
