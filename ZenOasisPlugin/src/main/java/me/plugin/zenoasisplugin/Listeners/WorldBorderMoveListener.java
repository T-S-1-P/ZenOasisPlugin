package me.plugin.zenoasisplugin.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class WorldBorderMoveListener implements Listener {
    int worldBorder = 10000;
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        if(e.getPlayer().getLocation().getBlockX() > worldBorder || e.getPlayer().getLocation().getBlockX() < -worldBorder || e.getPlayer().getLocation().getBlockZ() < -worldBorder || e.getPlayer().getLocation().getBlockZ() > worldBorder){
            Player p = e.getPlayer();
            if(!p.hasPermission("op")){
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You hit the world border");
                Location playerLocation = p.getLocation();

                if(playerLocation.getBlockX() > worldBorder){
                    p.teleport(playerLocation.subtract(1.5, 0,0));
                }else if(playerLocation.getBlockX() < -worldBorder){
                    p.teleport(playerLocation.add(1.5, 0,0));
                }else if(playerLocation.getBlockZ() > worldBorder){
                    p.teleport(playerLocation.subtract(0, 0,1.5));
                }else if(playerLocation.getBlockZ() < -worldBorder){
                    p.teleport(playerLocation.add(0, 0,1.5));
                }
            }
        }
    }
}
