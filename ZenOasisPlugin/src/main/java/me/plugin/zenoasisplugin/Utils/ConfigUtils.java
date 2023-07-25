package me.plugin.zenoasisplugin.Utils;

import me.plugin.zenoasisplugin.ZenOasisPlugin;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class ConfigUtils {
    static ZenOasisPlugin plugin = JavaPlugin.getPlugin(ZenOasisPlugin.class);

    public static void saveTowns(List<TownUtils.Town> towns, FileConfiguration config) {
        ConfigurationSection townsSection = config.createSection("towns");

        for (int i = 0; i < towns.size(); i++) {
            TownUtils.Town town = towns.get(i);
            ConfigurationSection townSection = townsSection.createSection("town" + i);

            townSection.set("TownName", town.getTownName());
            townSection.set("TownIcon", town.getTownIcon());
            townSection.set("TownNameColor", town.getTownNameColor());
            townSection.set("MayorName", town.getMayorName());
            townSection.set("MemberNames", town.getMemberNames());
            townSection.set("TownX", town.getTownX());
            townSection.set("TownY", town.getTownY());
            townSection.set("TownZ", town.getTownZ());
        }
        plugin.saveConfig();
    }
    public static List<TownUtils.Town> loadTowns(FileConfiguration config) {
        List<TownUtils.Town> towns = new ArrayList<>();

        ConfigurationSection townsSection = config.getConfigurationSection("towns");
        if (townsSection != null) {
            for (String townKey : townsSection.getKeys(false)) {
                ConfigurationSection townSection = townsSection.getConfigurationSection(townKey);
                if (townSection != null) {
                    String townName = townSection.getString("TownName");
                    String townIcon = townSection.getString("TownIcon");
                    String townColor = townSection.getString("TownNameColor");
                    String mayorName = townSection.getString("MayorName");
                    List<String>  memberNames = townSection.getStringList("MemberNames");
                    int townX = townSection.getInt("TownX");
                    int townY = townSection.getInt("TownY");
                    int townZ = townSection.getInt("TownZ");
                    TownUtils.Town town = new TownUtils.Town(townName, townIcon, townColor, mayorName, memberNames, townX, townY, townZ);

                    towns.add(town);
                }
            }
        }

        return towns;
    }
}
