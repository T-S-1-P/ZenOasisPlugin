package me.plugin.zenoasisplugin.Commands;

import me.plugin.zenoasisplugin.Utils.HologramUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HologramsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(p.hasPermission("op")){
                if(strings.length != 1){
                    p.sendMessage(ChatColor.GOLD + "Use /hologram list to see a list of the available holograms");
                }else{
                    switch(strings[0]){
                        case "list":
                            p.sendMessage(ChatColor.GOLD + "Available holograms: " + ChatColor.GREEN + "rules, welcome");
                            break;
                        case "rules":
                            HologramUtils.createRulesHologram(p);
                            p.sendMessage(ChatColor.GOLD + "You create the rules hologram");
                            break;
                        case "welcome":
                            HologramUtils.createWelcomeHologram(p);
                            p.sendMessage(ChatColor.GOLD + "You create the welcome hologram");
                            break;
                    }
                }
            }
        }
        return true;
    }
}
