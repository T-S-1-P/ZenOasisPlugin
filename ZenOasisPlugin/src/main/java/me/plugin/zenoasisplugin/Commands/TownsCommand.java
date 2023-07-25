package me.plugin.zenoasisplugin.Commands;

import me.plugin.zenoasisplugin.Utils.GUIUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class TownsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            GUIUtils.createTownsMenu(p);
        }
        return true;
    }
}
