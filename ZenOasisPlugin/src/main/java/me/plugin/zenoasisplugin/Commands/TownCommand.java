package me.plugin.zenoasisplugin.Commands;

import me.plugin.zenoasisplugin.Utils.GUIUtils;
import me.plugin.zenoasisplugin.Utils.TownUtils;
import me.plugin.zenoasisplugin.ZenOasisPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TownCommand implements CommandExecutor {
    private final ZenOasisPlugin plugin;

    public TownCommand(ZenOasisPlugin plugin) {
        this.plugin = plugin;
    }

    List<String> confirmCommand = new ArrayList<>();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(strings.length ==0){
                p.sendMessage(ChatColor.YELLOW + "================= " + ChatColor.WHITE + "Town Help" + ChatColor.YELLOW + " =================");
                p.sendMessage(ChatColor.GOLD + "/towns: " + ChatColor.WHITE + "List of all current towns");
                p.sendMessage(ChatColor.GOLD + "/town create: " + ChatColor.WHITE + "Create a town of your own");
                p.sendMessage(ChatColor.GOLD + "/town join: " + ChatColor.WHITE + "Join an existing town");
                p.sendMessage(ChatColor.GOLD + "/town leave: " + ChatColor.WHITE + "Leave your current town");
                p.sendMessage(ChatColor.GOLD + "/town info: " + ChatColor.WHITE + "Information about your current town");
                p.sendMessage(ChatColor.GOLD + "/town kick: " + ChatColor.WHITE + "Kick someone out of your town" + ChatColor.GRAY + " (mayor only)");
                p.sendMessage(ChatColor.GOLD + "/town delete: " + ChatColor.WHITE + "Remove your current town" + ChatColor.GRAY + " (mayor only)");
                p.sendMessage(ChatColor.GOLD + "/town transfer: " + ChatColor.WHITE + "Transfer the title of mayor to another town member" + ChatColor.GRAY + " (mayor only)");
                p.sendMessage(ChatColor.GOLD + "/town setcolor: " + ChatColor.WHITE + "Set the color you want your town to appear as" + ChatColor.GRAY + " (mayor only)");
            }else{
                if(strings.length == 1){
                    if(strings[0].equalsIgnoreCase("create")){
                        if(TownUtils.hasTown(p.getName())){
                            p.sendMessage(ChatColor.GOLD + "You are already a member of a town");
                        }else{
                            p.sendMessage(ChatColor.GOLD + "To create a town, do the following:");
                            p.sendMessage(ChatColor.GOLD + "1. " + ChatColor.WHITE + "Stand where you want the town to be located");
                            p.sendMessage(ChatColor.GOLD + "2. " + ChatColor.WHITE + "Hold the item you want your town icon to be");
                            p.sendMessage(ChatColor.GOLD + "3. " + ChatColor.WHITE + "Use /town create <TownName>");
                        }
                    }
                    if(strings[0].equalsIgnoreCase("join")){
                        if(TownUtils.hasTown(p.getName())){
                            p.sendMessage(ChatColor.GOLD + "You are already a member of a town");
                        }else{
                            p.sendMessage(ChatColor.GOLD + "Use /town join <TownName> to join a town");
                        }
                    }
                    if(strings[0].equalsIgnoreCase("leave")){
                        if(TownUtils.hasTown(p.getName())){
                            if(TownUtils.isMayor(p.getName())){
                                if(!confirmCommand.contains(p.getName())){
                                    p.sendMessage(ChatColor.RED + "As town mayor, leaving your town will disband it");
                                    p.sendMessage(ChatColor.GOLD + "Are you sure you want to leave your town? Retype the command to confirm.");
                                    confirmCommand.add(p.getName());
                                    Bukkit.getScheduler().runTaskLater(plugin, () ->{
                                        confirmCommand.remove(p.getName());
                                    }, 80 );
                                }else{
                                    TownUtils.disbandTown(p.getName());
                                    p.sendMessage(ChatColor.RED + "You have successfully disbanded your town");
                                    confirmCommand.remove(p.getName());
                                }
                            }else{
                                if(!confirmCommand.contains(p.getName())){
                                    p.sendMessage(ChatColor.GOLD + "Are you sure you want to leave your town? Retype the command to confirm.");
                                    confirmCommand.add(p.getName());
                                    Bukkit.getScheduler().runTaskLater(plugin, () ->{
                                        confirmCommand.remove(p.getName());
                                    }, 80 );
                                }else{
                                    TownUtils.leaveTown(p.getName());
                                    p.sendMessage(ChatColor.RED + "You have successfully disbanded your town");
                                    confirmCommand.remove(p.getName());
                                }
                            }
                        }else{
                            p.sendMessage(ChatColor.GOLD + "You are not currently a member of a town");
                        }
                    }
                    if(strings[0].equalsIgnoreCase("kick")){
                        p.sendMessage(ChatColor.GOLD + "Use /town kick <PlayerName> to kick a player out of your town");
                    }
                    if(strings[0].equalsIgnoreCase("delete")){
                        if(TownUtils.hasTown(p.getName()) && TownUtils.isMayor(p.getName())){
                            if(!confirmCommand.contains(p.getName())){
                                p.sendMessage(ChatColor.RED + "Are you sure you want to delete your town? Retype the command to confirm.");
                                confirmCommand.add(p.getName());
                                Bukkit.getScheduler().runTaskLater(plugin, () ->{
                                    confirmCommand.remove(p.getName());
                                }, 80 );
                            }else{
                                TownUtils.disbandTown(p.getName());
                                p.sendMessage(ChatColor.RED + "You have successfully deleted your town");
                                confirmCommand.remove(p.getName());
                            }
                        }else{
                            p.sendMessage(ChatColor.GOLD + "You are not the mayor of a town");
                        }
                    }
                    if(strings[0].equalsIgnoreCase("info")){
                        if(TownUtils.hasTown(p.getName())){
                            TownUtils.Town town = TownUtils.findPlayersTown(p.getName());
                            ChatColor townColor = TownUtils.getTownChatColor(town.getTownNameColor());
                            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Town Name: " + townColor + "" + ChatColor.BOLD + town.getTownName());
                            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Mayor: " + ChatColor.WHITE + town.getMayorName());
                            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Members: " + ChatColor.WHITE + town.getMemberNames());
                            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Location: " + ChatColor.WHITE + town.getTownX() + ", " + town.getTownY() + ", " + town.getTownZ());
                        }else{
                            p.sendMessage(ChatColor.GOLD + "You are not currently a member of a town");
                        }
                    }
                    if(strings[0].equalsIgnoreCase("transfer")){
                        if(TownUtils.hasTown(p.getName())){
                            if(TownUtils.isMayor(p.getName())){
                                p.sendMessage(ChatColor.GOLD + "Use /town transfer <PlayerName> to designate a new mayor for your town");
                            }else{
                                p.sendMessage(ChatColor.GOLD + "You are not the mayor of your town");
                            }
                        }else{
                            p.sendMessage(ChatColor.GOLD + "You are not currently a member of a town");
                        }
                    }
                    if(strings[0].equalsIgnoreCase("setcolor")){
                        if(TownUtils.hasTown(p.getName())){
                            if(TownUtils.isMayor(p.getName())){
                                GUIUtils.createTownColorMenu(p);
                            }else{
                                p.sendMessage(ChatColor.GOLD + "You are not the mayor of your town");
                            }
                        }else{
                            p.sendMessage(ChatColor.GOLD + "You are not currently a member of a town");
                        }
                    }
                }
                if(strings.length == 2){
                    if(strings[0].equalsIgnoreCase("create")){
                        if(TownUtils.hasTown(p.getName())){
                            p.sendMessage(ChatColor.GOLD + "You are already a member of a town");
                        }else{
                            String townName = strings[1];
                            String townIcon = p.getInventory().getItemInMainHand().getType().toString();
                            List<String> memberNames = new ArrayList<>();
                            memberNames.add(p.getName());
                            if(!townIcon.equalsIgnoreCase("AIR")){
                                TownUtils.Town newTown = new TownUtils.Town(townName, townIcon, "white", p.getName(), memberNames, p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
                                TownUtils.createTown(p, newTown);
                            }else{
                                p.sendMessage(ChatColor.RED + "Please hold an item you want your town icon to be");
                            }
                        }
                    }
                    if(strings[0].equalsIgnoreCase("join")){
                        if(TownUtils.hasTown(p.getName())){
                            p.sendMessage(ChatColor.GOLD + "You are already a member of a town");
                        }else{
                            if(TownUtils.isValidTown(strings[1])){
                                TownUtils.joinTown(p.getName(), strings[1]);

                            }else{
                                p.sendMessage(ChatColor.RED + "That town doesn't exist");
                            }

                        }
                    }
                    if(strings[0].equalsIgnoreCase("kick")){
                        if(TownUtils.hasTown(p.getName()) && TownUtils.isMayor(p.getName())){
                            if(TownUtils.findPlayersTown(p.getName()).getMemberNames().contains(strings[1]) && !p.getName().equalsIgnoreCase(strings[1])){
                                TownUtils.kickFromTown(p.getName(), strings[1]);
                            }else{
                                p.sendMessage(ChatColor.RED + "You cannot kick that player from your town");
                            }
                        }else{
                            p.sendMessage(ChatColor.RED + "You are not the mayor of a town");
                        }
                    }
                    if(strings[0].equalsIgnoreCase("transfer")){
                        if(TownUtils.hasTown(p.getName()) && TownUtils.isMayor(p.getName())){
                            if(TownUtils.findPlayersTown(p.getName()).getMemberNames().contains(strings[1]) && !p.getName().equalsIgnoreCase(strings[1])){
                                TownUtils.transferMayor(p.getName(), strings[1]);
                            }else{
                                p.sendMessage(ChatColor.RED + "You cannot make that player the mayor of your town");
                            }
                        }else{
                            p.sendMessage(ChatColor.RED + "You are not the mayor of a town");
                        }
                    }
                }
                if(strings.length > 2){
                    if(strings[0].equalsIgnoreCase("create")){
                        if(TownUtils.hasTown(p.getName())){
                            p.sendMessage(ChatColor.GOLD + "You are already a member of a town");
                        }else{
                            StringBuilder builder = new StringBuilder();
                            for(int i = 1; i < strings.length; i++){
                                builder.append(strings[i]);
                                if(i < strings.length -1){
                                    builder.append(" ");
                                }
                            }
                            String townName = builder.toString();
                            String townIcon = p.getInventory().getItemInMainHand().getType().toString();
                            List<String> memberNames = new ArrayList<>();
                            memberNames.add(p.getName());
                            if(!townIcon.equalsIgnoreCase("AIR")){
                                TownUtils.Town newTown = new TownUtils.Town(townName, townIcon, "white", p.getName(), memberNames, p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
                                TownUtils.createTown(p, newTown);
                            }else{
                                p.sendMessage(ChatColor.RED + "Please hold an item you want your town icon to be");
                            }
                        }
                    }else{
                        p.sendMessage(ChatColor.RED + "Use /town or /townhelp");
                    }
                }
            }
        }
        return true;
    }
}
