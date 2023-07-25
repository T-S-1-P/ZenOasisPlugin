package me.plugin.zenoasisplugin.Utils;

import me.plugin.zenoasisplugin.ZenOasisPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TownUtils {
    static ZenOasisPlugin plugin = JavaPlugin.getPlugin(ZenOasisPlugin.class);
    public static class Town {
        private String TownName;
        private String TownIcon;
        private String TownNameColor;
        private String MayorName;
        private List<String> MemberNames;
        private int TownX;
        private int TownY;
        private int TownZ;


        public Town(String townName, String townIcon, String townNameColor, String mayorName, List<String> memberNames, int townX, int townY, int townZ) {
            this.TownName = townName;
            this.TownIcon = townIcon;
            this.TownNameColor = townNameColor;
            this.MayorName = mayorName;
            this.MemberNames = memberNames;
            this. TownX = townX;
            this.TownY = townY;
            this.TownZ = townZ;
        }
        public void setMemberNames(List<String> newMemberNames){this.MemberNames = newMemberNames;}
        public void setTownNameColor(String newColor){this.TownNameColor = newColor;}
        public void setTownMayor(String mayorName){this.MayorName = mayorName;}

        public String getTownName() {
            return TownName;
        }

        public String getTownIcon() {
            return TownIcon;
        }

        public String getTownNameColor() {
            return TownNameColor;
        }

        public String getMayorName() {
            return MayorName;
        }

        public List<String> getMemberNames() {
            return MemberNames;
        }

        public int getTownX() {
            return TownX;
        }

        public int getTownY() {
            return TownY;
        }

        public int getTownZ() {
            return TownZ;
        }
    }

    public static Town findPlayersTown(String playerName){
        ArrayList<Town> currentTowns = (ArrayList<Town>) ConfigUtils.loadTowns(plugin.getConfig());
        Town placeHolder = new Town("This is a bug, please report it to staff", "DIAMOND", "WHITE", "BUG", new ArrayList<>(), 1,1,1);
        for (Town town : currentTowns) {
            for (String name : town.getMemberNames()) {
                if (playerName.equalsIgnoreCase(name)) {
                    return town;
                }
            }
        }
        return placeHolder;
    }

    public static boolean isValidTown(String townName){
        ArrayList<Town> currentTowns = (ArrayList<Town>) ConfigUtils.loadTowns(plugin.getConfig());
        for (Town town : currentTowns) {
            if (townName.equalsIgnoreCase(town.getTownName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasTown(String playerName){
        ArrayList<Town> currentTowns = (ArrayList<Town>) ConfigUtils.loadTowns(plugin.getConfig());
        for (Town town : currentTowns) {
            for (String name : town.getMemberNames()) {
                if (playerName.equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isMayor(String playerName){
        ArrayList<Town> currentTowns = (ArrayList<Town>) ConfigUtils.loadTowns(plugin.getConfig());
        for (Town town : currentTowns) {
            if (playerName.equalsIgnoreCase(town.getMayorName())) {
                return true;
            }
        }
        return false;
    }

    public static void disbandTown(String playerName){
        ArrayList<Town> currentTowns = (ArrayList<Town>) ConfigUtils.loadTowns(plugin.getConfig());
        Iterator<Town> iterator = currentTowns.iterator();
        while (iterator.hasNext()) {
            Town town = iterator.next();
            if (playerName.equalsIgnoreCase(town.getMayorName())) {
                iterator.remove();
            }
        }
        ConfigUtils.saveTowns(currentTowns, plugin.getConfig());

    }

    public static void leaveTown(String playerName){
        ArrayList<Town> currentTowns = (ArrayList<Town>) ConfigUtils.loadTowns(plugin.getConfig());
        Iterator<Town> iterator = currentTowns.iterator();
        while (iterator.hasNext()) {
            Town town = iterator.next();
            if (town.getMemberNames().contains(playerName)) {
                List<String> currentMembers = town.getMemberNames();
                currentMembers.remove(playerName);
            }
        }
        ConfigUtils.saveTowns(currentTowns, plugin.getConfig());
    }

    public static void joinTown(String playerName, String townName){
        ArrayList<Town> currentTowns = (ArrayList<Town>) ConfigUtils.loadTowns(plugin.getConfig());
        Iterator<Town> iterator = currentTowns.iterator();
        while (iterator.hasNext()) {
            Town town = iterator.next();
            if (town.getTownName().equalsIgnoreCase(townName)) {
                List<String> currentMembers = town.getMemberNames();
                currentMembers.add(playerName);
                town.setMemberNames(currentMembers);
            }
        }
        ConfigUtils.saveTowns(currentTowns, plugin.getConfig());
    }

    public static void kickFromTown(String playerName, String townName){
        ArrayList<Town> currentTowns = (ArrayList<Town>) ConfigUtils.loadTowns(plugin.getConfig());
        Iterator<Town> iterator = currentTowns.iterator();
        while (iterator.hasNext()) {
            Town town = iterator.next();
            if (town.getTownName().equalsIgnoreCase(townName)) {
                List<String> currentMembers = town.getMemberNames();
                currentMembers.add(playerName);
                town.setMemberNames(currentMembers);
            }
        }
        ConfigUtils.saveTowns(currentTowns, plugin.getConfig());
    }

    public static void transferMayor(String playerName, String newMayor){
        ArrayList<Town> currentTowns = (ArrayList<Town>) ConfigUtils.loadTowns(plugin.getConfig());
        Iterator<Town> iterator = currentTowns.iterator();
        while (iterator.hasNext()) {
            Town town = iterator.next();
            if (town.getMayorName().equalsIgnoreCase(playerName)) {
                town.setTownMayor(newMayor);
            }
        }
        ConfigUtils.saveTowns(currentTowns, plugin.getConfig());
    }

    public static void changeTownColor(String playerName, String color){
        ArrayList<Town> currentTowns = (ArrayList<Town>) ConfigUtils.loadTowns(plugin.getConfig());
        Iterator<Town> iterator = currentTowns.iterator();
        while (iterator.hasNext()) {
            Town town = iterator.next();
            if (town.getMayorName().equalsIgnoreCase(playerName)) {
                town.setTownNameColor(color);
            }
        }
        ConfigUtils.saveTowns(currentTowns, plugin.getConfig());
    }

    public static void createTown(Player p, Town newTown){
        ArrayList<Town> currentTowns = (ArrayList<Town>) ConfigUtils.loadTowns(plugin.getConfig());
        for (Town town : currentTowns) {
            if (town.getTownName().equalsIgnoreCase(newTown.getTownName())) {
                p.sendMessage(ChatColor.RED + "A town already exists with that name");
                return;
            }
            if (town.getTownIcon().equalsIgnoreCase(newTown.getTownIcon())) {
                p.sendMessage(ChatColor.RED + "A town already exists with that icon");
                return;
            }
        }
        currentTowns.add(newTown);
        ConfigUtils.saveTowns(currentTowns, plugin.getConfig());
        p.sendMessage(ChatColor.GOLD + "Town successfully created! See all towns in /towns");
        p.sendMessage(ChatColor.GOLD + "You have created the town of " + ChatColor.WHITE + "" + ChatColor.BOLD + newTown.getTownName());
    }

    public static ItemStack createTownItem(Town town){
        Material material = Material.getMaterial(town.getTownIcon());
        ItemStack townItem = new ItemStack(material);
        ItemMeta townMeta = townItem.getItemMeta();
        ChatColor townColor = getTownChatColor(town.getTownNameColor());
        townMeta.setDisplayName(townColor + "" + ChatColor.BOLD + town.getTownName());
        ArrayList<String> townLore = new ArrayList<>();
        townLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Mayor: " + ChatColor.RESET + town.getMayorName());
        townLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Members: " + ChatColor.RESET + town.getMemberNames());
        townLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Location: " + ChatColor.RESET + town.getTownX() + ", " + town.getTownY() + ", " + town.getTownZ());
        townMeta.setLore(townLore);
        townItem.setItemMeta(townMeta);
        return townItem;
    }

    public static ChatColor getTownChatColor(String color){
        switch(color){
            case "white":
                return ChatColor.WHITE;
            case "red":
                return ChatColor.RED;
            case "blue":
                return ChatColor.BLUE;
            case "black":
                return ChatColor.BLACK;
            case "pink":
                return ChatColor.LIGHT_PURPLE;
            case "green":
                return ChatColor.GREEN;
            case "yellow":
                return ChatColor.YELLOW;
            case "aqua":
                return ChatColor.AQUA;
            case "purple":
                return ChatColor.DARK_PURPLE;
            default:
                return ChatColor.MAGIC;
        }

    }
}
