package me.plugin.zenoasisplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RulesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            p.sendMessage(ChatColor.GREEN + "" + ChatColor.UNDERLINE + "In Game Rules:");
            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "1. " + ChatColor.GRAY + "No griefing, stealing, or lying.");
            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "2. " + ChatColor.GRAY + "No cheating, chunkbase, cracked accounts, xray, and other hacks/cheats or hacked clients.");
            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "3. " + ChatColor.GRAY + "PVP must have consent.");
            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "4. " + ChatColor.GRAY + "Do not build on the crater wall, inside of the crater wall, and just outside of the crater wall in spawn. You’re welcome to build near spawn if you want, but just keep a little distance from the walls. To leave spawn, walk through the tunnel, it’ll take you outside the wall.");
            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "5. " + ChatColor.GRAY + "World border is 10,000 x 10,000. Do not go outside of 10,000 in any direction in the overworld.");
            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "6. " + ChatColor.GRAY + "Do not destroy other people’s builds. Make sure you set claim to your builds/land. Put your claimed coordinates in the coordinates channel.");
            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "7. " + ChatColor.GRAY + "Builds you make in a town isn’t owned by you or your mayor. It belongs to the town, but mayors are responsible for keeping builds relevant to the town theme and can remove builds that don’t suite the vibe.");
            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "8. " + ChatColor.GRAY + "30 villagers allowed per town and must be name tagged.");
        }
        return true;
    }
}
