package me.plugin.zenoasisplugin.Listeners;

import me.plugin.zenoasisplugin.Utils.TownUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "✍ Town Color Selector ✍")){
            Player p = (Player) e.getWhoClicked();
            ItemStack clickedItem = e.getCurrentItem();
            e.setCancelled(true);
            if(clickedItem != null && clickedItem.hasItemMeta() && clickedItem.getItemMeta().hasDisplayName()){
                switch(clickedItem.getType()){
                    case WHITE_WOOL:
                        TownUtils.changeTownColor(p.getName(), "white");
                        p.sendMessage(ChatColor.GOLD + "You have changed your town color to " + ChatColor.WHITE + "" + ChatColor.BOLD + "WHITE");
                        break;

                    case RED_WOOL:
                        TownUtils.changeTownColor(p.getName(), "red");
                        p.sendMessage(ChatColor.GOLD + "You have changed your town color to " + ChatColor.RED + "" + ChatColor.BOLD + "RED");
                        break;

                    case BLUE_WOOL:
                        TownUtils.changeTownColor(p.getName(), "blue");
                        p.sendMessage(ChatColor.GOLD + "You have changed your town color to " + ChatColor.BLUE + "" + ChatColor.BOLD + "BLUE");
                        break;

                    case BLACK_WOOL:
                        TownUtils.changeTownColor(p.getName(), "black");
                        p.sendMessage(ChatColor.GOLD + "You have changed your town color to " + ChatColor.BLACK + "" + ChatColor.BOLD + "BLACK");
                        break;

                    case PINK_WOOL:
                        TownUtils.changeTownColor(p.getName(), "pink");
                        p.sendMessage(ChatColor.GOLD + "You have changed your town color to " + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "PINK");
                        break;

                    case GREEN_WOOL:
                        TownUtils.changeTownColor(p.getName(), "green");
                        p.sendMessage(ChatColor.GOLD + "You have changed your town color to " + ChatColor.GREEN + "" + ChatColor.BOLD + "GREEN");
                        break;

                    case YELLOW_WOOL:
                        TownUtils.changeTownColor(p.getName(), "yellow");
                        p.sendMessage(ChatColor.GOLD + "You have changed your town color to " + ChatColor.YELLOW + "" + ChatColor.BOLD + "YELLOW");
                        break;

                    case CYAN_WOOL:
                        TownUtils.changeTownColor(p.getName(), "aqua");
                        p.sendMessage(ChatColor.GOLD + "You have changed your town color to " + ChatColor.AQUA + "" + ChatColor.BOLD + "AQUA");
                        break;

                    case PURPLE_WOOL:
                        TownUtils.changeTownColor(p.getName(), "purple");
                        p.sendMessage(ChatColor.GOLD + "You have changed your town color to " + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "PURPLE");
                        break;
                }
            }
        }
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN+ "Towns: ")){
            e.setCancelled(true);
        }
    }
}
