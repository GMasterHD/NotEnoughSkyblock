package de.dragonsroar.nes;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Comparator;

@Getter @Setter
public class Config extends Vigilant {
    @Getter
    private static Config instance = new Config();

    public static final String SUBCATEGORY_MINING_DISPLAY = "Mining Display";
    public static final String SUBCATEGORY_FORGE = "Forge";
    public static final String SUBCATEGORY_HOTM = "Heart Of The Mountain";
    public static final String SUBCATEGORY_CH_TC = "Crystal Hollows - Treasure Chests";
    public static final String SUBCATEGORY_CH_G = "Crystal Hollows - Gemstones";

    public static final String SUBCATEGORY_API = "API";

    public static final String SUBCATEGORY_SKILL = "Skill Tracker";
    public static final String SUBCATEGORY_SKILL_GAINED = "Skill XP Gained";
    public static final String SUBCATEGORY_PET = "Pets";

    @Property(type = PropertyType.TEXT, name = "API Key", description = "Set/view your api key (Run /api new to get a new key)",
            category = "General", subcategory = SUBCATEGORY_API)
    private String apikey;

    @Property(type = PropertyType.BUTTON, name = "Open GUI Editor", description = "Opens the gui editor",
            category = "General", subcategory = SUBCATEGORY_API)
    private void editGUI() {
    }

    @Property(type = PropertyType.BUTTON, name = "Fetch API", description = "Refetch your local stats from your api",
            category = "General", subcategory = SUBCATEGORY_API)
    private void fetchAPI() {
    }

    @Property(type = PropertyType.SWITCH, name = "Better XP Gained Display", description = "Replaces the default Skill XP gained actionbar",
            category = "Trackers", subcategory = SUBCATEGORY_SKILL_GAINED)
    private boolean trackers_xpgained;

    @Property(type = PropertyType.CHECKBOX, name = "Actions Left", description = "Show actions left til level up",
            category = "Trackers", subcategory = SUBCATEGORY_SKILL_GAINED)
    private boolean trackers_actions;

    @Property(type = PropertyType.SELECTOR, name = "Show XP as", description = "Change the way the xp are shown", options = {
                "XP", "Percentage"
            }, category = "Trackers", subcategory = SUBCATEGORY_SKILL_GAINED)
    private int trackers_showXpAs;

    @Property(type = PropertyType.CHECKBOX, name = "Show Level", description = "Show your current Level",
            category = "Trackers", subcategory = SUBCATEGORY_SKILL_GAINED)
    private boolean trackers_showLevel;


    @Property(type = PropertyType.SWITCH, name = "Show Skill Display", description = "Shows an advanced skill display",
            category = "Trackers", subcategory = SUBCATEGORY_SKILL)
    private boolean trackers_showAdvancedSkill;

    @Property(type = PropertyType.CHECKBOX, name = "Show XP / hour", description = "Shows your gained skill / time",
            category = "Trackers", subcategory = SUBCATEGORY_SKILL)
    private boolean trackers_xpPerHour;

    @Property(type = PropertyType.SELECTOR, name = "Show skill type", description = "Forces a specific skill type", options = {
                "Foraging", "Mining", "Combat", "Farming", "Enchanting", "Alchemy", "Fishing", "Taming", "Auto"
            }, category = "Trackers", subcategory = SUBCATEGORY_SKILL)
    private int trackers_skillType;

    @Property(type = PropertyType.CHECKBOX, name = "Show XP Gained", description = "Shows how many xp you gained since the start of this session",
            category = "Trackers", subcategory = SUBCATEGORY_SKILL)
    private boolean trackers_skillGained;

    @Property(type = PropertyType.CHECKBOX, name = "Show Time Left", description = "Show time you would need to max out skill",
            category = "Trackers", subcategory = SUBCATEGORY_SKILL)
    private boolean trackers_timeLeft;

    @Property(type = PropertyType.CHECKBOX, name = "Show Percentage Max", description = "Show current percentage of max level",
            category = "Trackers", subcategory = SUBCATEGORY_SKILL)
    private boolean trackers_percentageMax;

    @Property(type = PropertyType.CHECKBOX, name = "Color", description = "Set the text color of the skill tracker",
            category = "Trackers", subcategory = SUBCATEGORY_SKILL)
    private int trackers_skillColor;

    @Property(type = PropertyType.CHECKBOX, name = "Time Elapsed", description = "Show time elapsed since session start",
            category = "Trackers", subcategory = SUBCATEGORY_SKILL)
    private boolean trackers_elapsed;

    @Property(type = PropertyType.SWITCH, name = "Show Current Pet", description = "Shows your active pet",
            category = "Trackers", subcategory = SUBCATEGORY_PET)
    private boolean trackers_currentPet;

    @Property(type = PropertyType.CHECKBOX, name = "Show Pet XP", description = "Shows an abbreviation of your current pet xp",
            category = "Trackers", subcategory = SUBCATEGORY_PET)
    private boolean trackers_currentXP;

    @Property(type = PropertyType.CHECKBOX, name = "Show XP Shared pets", description = "Shows pets that have an xp share",
            category = "Trackers", subcategory = SUBCATEGORY_PET)
    private boolean trackers_xpShared;

    @Property(type = PropertyType.CHECKBOX, name = "XP Shared Pet XP", description = "Shows an abbreviation xp of your xp shared pets",
            category = "Trackers", subcategory = SUBCATEGORY_PET)
    private boolean trackers_xpSharedXP;


    @Property(type = PropertyType.SWITCH, name = "Commission Display", description = "Shows a display of your current active Commissions",
            category = "Mining", subcategory = SUBCATEGORY_MINING_DISPLAY)
    private boolean mining_commissionDisplay;

    @Property(type = PropertyType.CHECKBOX, name = "Powder Display", description = "Shows a display about your current powder",
            category = "Mining", subcategory = SUBCATEGORY_MINING_DISPLAY)
    private boolean mining_powderDisplay;

    @Property(type = PropertyType.CHECKBOX, name = "Powder/h", description = "Shows your current powder gain",
            category = "Mining", subcategory = SUBCATEGORY_MINING_DISPLAY)
    private boolean mining_powderPerHour;

    @Property(type = PropertyType.CHECKBOX, name = "Powder Gained", description = "Shows your powder gained since session start",
            category = "Mining", subcategory = SUBCATEGORY_MINING_DISPLAY)
    private boolean mining_powderGained;

    @Property(type = PropertyType.BUTTON, name = "End Session", description = "End your current powder Session",
            category = "Mining", subcategory = SUBCATEGORY_MINING_DISPLAY)
    private void mining_endPowderSession() {
    }

    @Property(type = PropertyType.SWITCH, name = "Show Forge Display", description = "Shows a forge display about your current forge",
            category = "Mining", subcategory = SUBCATEGORY_FORGE)
    private boolean mining_forgeDisplay;

    @Property(type = PropertyType.SWITCH, name = "Forge Alert", description = "Shows you a message when your forge has finished",
            category = "Mining", subcategory = SUBCATEGORY_FORGE)
    private boolean mining_forgeAlert;

    @Property(type = PropertyType.SWITCH, name = "Cheapest Perk", description = "Hightlights the cheapest fortune/speed perk in your HOTM tree",
            category = "Mining", subcategory = SUBCATEGORY_HOTM)
    private boolean mining_cheapestPerk;

    @Property(type = PropertyType.SWITCH, name = "Treasure Chest Display", description = "Shows a treasure chest display",
            category = "Mining", subcategory = SUBCATEGORY_CH_TC)
    private boolean chtc_display;

    @Property(type = PropertyType.CHECKBOX, name = "Hide Jungle Loot", description = "Hides loot for jungle chests",
            category = "Mining", subcategory = SUBCATEGORY_CH_TC)
    private boolean chtc_hideJungle;

    @Property(type = PropertyType.CHECKBOX, name = "Hide Goblin Loot", description = "Hides loot for goblin chests",
            category = "Mining", subcategory = SUBCATEGORY_CH_TC)
    private boolean chtc_hideGoblin;

    @Property(type = PropertyType.CHECKBOX, name = "Hide Mithril Loot", description = "Hides loot for mithril chests",
            category = "Mining", subcategory = SUBCATEGORY_CH_TC)
    private boolean chtc_hideMithril;

    @Property(type = PropertyType.CHECKBOX, name = "Hide Precursor Loot", description = "Hides loot for precursor chests",
            category = "Mining", subcategory = SUBCATEGORY_CH_TC)
    private boolean chtc_hidePrecursor;

    @Property(type = PropertyType.CHECKBOX, name = "Hide Magma Loot", description = "Hides loot for magma chests",
            category = "Mining", subcategory = SUBCATEGORY_CH_TC)
    private boolean chtc_hideMagma;

    @Property(type = PropertyType.CHECKBOX, name = "Hide Common Drops", description = "Hides common drops like wishing compass",
            category = "Mining", subcategory = SUBCATEGORY_CH_TC)
    private boolean chtc_hideCommon;

    @Property(type = PropertyType.CHECKBOX, name = "Block / Chest", description = "Counts your average block count you mine untial a chest apears",
            category = "Mining", subcategory = SUBCATEGORY_CH_TC)
    private boolean chtc_blocksPerChest;

    @Property(type = PropertyType.CHECKBOX, name = "Estimated Coins", description = "Calculates estimated coins base on current bazaar / ah prices",
            category = "Mining", subcategory = SUBCATEGORY_CH_TC)
    private boolean chtc_estimatedCoins;

    @Property(type = PropertyType.SWITCH, name = "Gemstone Display", description = "Counts mined gemstones (does not count gemstones collected by sacks)",
            category = "Mining", subcategory = SUBCATEGORY_CH_G)
    private boolean chg_display;

    @Property(type = PropertyType.CHECKBOX, name = "Show Ruby", description = "Shows Ruby Gemstones",
            category = "Mining", subcategory = SUBCATEGORY_CH_G)
    private boolean chg_ruby;
    @Property(type = PropertyType.CHECKBOX, name = "Show Amethyst", description = "Shows Amethyst Gemstones",
            category = "Mining", subcategory = SUBCATEGORY_CH_G)
    private boolean chg_amethyst = true;
    @Property(type = PropertyType.CHECKBOX, name = "Show Jade", description = "Shows Jade Gemstones",
            category = "Mining", subcategory = SUBCATEGORY_CH_G)
    private boolean chg_jade;
    @Property(type = PropertyType.CHECKBOX, name = "Show Amber", description = "Shows Amber Gemstones",
            category = "Mining", subcategory = SUBCATEGORY_CH_G)
    private boolean chg_amber;
    @Property(type = PropertyType.CHECKBOX, name = "Show Topaz", description = "Shows Topaz Gemstones",
            category = "Mining", subcategory = SUBCATEGORY_CH_G)
    private boolean chg_topaz;
    @Property(type = PropertyType.CHECKBOX, name = "Show Jasper", description = "Shows Jasper Gemstones",
            category = "Mining", subcategory = SUBCATEGORY_CH_G)
    private boolean chg_jasper;

    @Property(type = PropertyType.SELECTOR, name = "Show as", description = "Shows gemstone count as", options = {
                "Rough", "Flawed", "Fine", "Flawless", "Highest"
            }, category = "Mining", subcategory = SUBCATEGORY_CH_G)
    private int chg_showAs;

    @Property(type = PropertyType.CHECKBOX, name = "Estimated Value", description = "Shows estimated value of gemstones",
            category = "Mining", subcategory = SUBCATEGORY_CH_G)
    private int chg_value;

    public Config() {
        super(new File("./config/nes/config.toml"), NotEnoughSkyblock.NAME, new JVMAnnotationPropertyCollector(), new ConfigSorting());
        initialize();
    }

    public static class ConfigSorting extends SortingBehavior {
        @NotNull
        @Override
        public Comparator<Category> getCategoryComparator() {
            return (o1, o2) -> {
                if(o1.getName().equals(NotEnoughSkyblock.NAME)) {
                    return -1;
                } else if(o2.getName().equals(NotEnoughSkyblock.NAME)) {
                    return 1;
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            };
        }
    }
}
