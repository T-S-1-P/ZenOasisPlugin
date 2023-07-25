package me.plugin.zenoasisplugin.Utils;

import me.plugin.zenoasisplugin.ZenOasisPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class GUIUtils {
    static ZenOasisPlugin plugin = JavaPlugin.getPlugin(ZenOasisPlugin.class);

    public static void createTownColorMenu(Player p){
        Inventory colorMenu = Bukkit.createInventory(p, 9, ChatColor.LIGHT_PURPLE + "✍ Town Color Selector ✍");
        
        ItemStack whiteItem = new ItemStack(Material.WHITE_WOOL);
        ItemMeta whiteMeta = whiteItem.getItemMeta();
        whiteMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Click to set your town color as white!");
        whiteItem.setItemMeta(whiteMeta);
        colorMenu.addItem(whiteItem);

        ItemStack redItem = new ItemStack(Material.RED_WOOL);
        ItemMeta redMeta = redItem.getItemMeta();
        redMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Click to set your town color as red!");
        redItem.setItemMeta(redMeta);
        colorMenu.addItem(redItem);

        ItemStack blueItem = new ItemStack(Material.BLUE_WOOL);
        ItemMeta blueMeta = blueItem.getItemMeta();
        blueMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Click to set your town color as blue!");
        blueItem.setItemMeta(blueMeta);
        colorMenu.addItem(blueItem);

        ItemStack blackItem = new ItemStack(Material.BLACK_WOOL);
        ItemMeta blackMeta = blackItem.getItemMeta();
        blackMeta.setDisplayName(ChatColor.BLACK + "" + ChatColor.BOLD + "Click to set your town color as black!");
        blackItem.setItemMeta(blackMeta);
        colorMenu.addItem(blackItem);
        
        ItemStack pinkItem = new ItemStack(Material.PINK_WOOL);
        ItemMeta pinkMeta = pinkItem.getItemMeta();
        pinkMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Click to set your town color as pink!");
        pinkItem.setItemMeta(pinkMeta);
        colorMenu.addItem(pinkItem);

        ItemStack greenItem = new ItemStack(Material.GREEN_WOOL);
        ItemMeta greenMeta = greenItem.getItemMeta();
        greenMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Click to set your town color as green!");
        greenItem.setItemMeta(greenMeta);
        colorMenu.addItem(greenItem);

        ItemStack yellowItem = new ItemStack(Material.YELLOW_WOOL);
        ItemMeta yellowMeta = yellowItem.getItemMeta();
        yellowMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Click to set your town color as yellow!");
        yellowItem.setItemMeta(yellowMeta);
        colorMenu.addItem(yellowItem);

        ItemStack aquaItem = new ItemStack(Material.CYAN_WOOL);
        ItemMeta aquaMeta = aquaItem.getItemMeta();
        aquaMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Click to set your town color as aqua!");
        aquaItem.setItemMeta(aquaMeta);
        colorMenu.addItem(aquaItem);

        ItemStack purpleItem = new ItemStack(Material.PURPLE_WOOL);
        ItemMeta purpleMeta = purpleItem.getItemMeta();
        purpleMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Click to set your town color as purple!");
        purpleItem.setItemMeta(purpleMeta);
        colorMenu.addItem(purpleItem);

        p.openInventory(colorMenu);
    }
    public static void createTownsMenu(Player p){
        Inventory townsMenu = Bukkit.createInventory(p, 54, ChatColor.GREEN+ "Towns: ");

        ArrayList<TownUtils.Town> currentTowns = (ArrayList<TownUtils.Town>) ConfigUtils.loadTowns(plugin.getConfig());
        for (TownUtils.Town town : currentTowns) {
            ItemStack townItem = TownUtils.createTownItem(town);
            townsMenu.addItem(townItem);
        }
        p.openInventory(townsMenu);
    }
}
