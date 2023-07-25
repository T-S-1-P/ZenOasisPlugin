package me.plugin.zenoasisplugin.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class HologramUtils {
    public static void createRulesHologram(Player p){
        Location location = p.getLocation();
        ArmorStand line1 = (ArmorStand) p.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        line1.setVisible(false);
        line1.setGravity(false);
        line1.setCustomNameVisible(true);
        line1.setCustomName(ChatColor.BLUE + "" + ChatColor.UNDERLINE + "/rules for the full list of rules");

        ArmorStand line20 = (ArmorStand) p.getWorld().spawnEntity(location.add(0, 0.25, 0), EntityType.ARMOR_STAND);
        line20.setVisible(false);
        line20.setGravity(false);
        line20.setCustomNameVisible(true);
        line20.setCustomName(ChatColor.GREEN +  "Do not go outside of 10,000 in any direction.");

        ArmorStand line200 = (ArmorStand) p.getWorld().spawnEntity(location.add(0, 0.25, 0), EntityType.ARMOR_STAND);
        line200.setVisible(false);
        line200.setGravity(false);
        line200.setCustomNameVisible(true);
        line200.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "5. " + ChatColor.GREEN +  "World border is 10,000 x 10,000.");

        ArmorStand line21 = (ArmorStand) p.getWorld().spawnEntity(location.add(0, 0.25, 0), EntityType.ARMOR_STAND);
        line21.setVisible(false);
        line21.setGravity(false);
        line21.setCustomNameVisible(true);
        line21.setCustomName(ChatColor.GREEN +  "and just outside of the crater wall in spawn");

        ArmorStand line2 = (ArmorStand) p.getWorld().spawnEntity(location.add(0, 0.25, 0), EntityType.ARMOR_STAND);
        line2.setVisible(false);
        line2.setGravity(false);
        line2.setCustomNameVisible(true);
        line2.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "4. " + ChatColor.GREEN +  "Do not build on the crater wall, inside of the crater wall,");

        ArmorStand line3 = (ArmorStand) p.getWorld().spawnEntity(location.add(0, 0.25, 0), EntityType.ARMOR_STAND);
        line3.setVisible(false);
        line3.setGravity(false);
        line3.setCustomNameVisible(true);
        line3.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "3. " + ChatColor.GREEN +  "PVP must have consent");

        ArmorStand line40 = (ArmorStand) p.getWorld().spawnEntity(location.add(0, 0.25, 0), EntityType.ARMOR_STAND);
        line40.setVisible(false);
        line40.setGravity(false);
        line40.setCustomNameVisible(true);
        line40.setCustomName(ChatColor.GREEN +  "and other hacks/cheats or hacked clients");

        ArmorStand line4 = (ArmorStand) p.getWorld().spawnEntity(location.add(0, 0.25, 0), EntityType.ARMOR_STAND);
        line4.setVisible(false);
        line4.setGravity(false);
        line4.setCustomNameVisible(true);
        line4.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "2. " + ChatColor.GREEN +  "No cheating, chunkbase, cracked accounts, xray,");

        ArmorStand line5 = (ArmorStand) p.getWorld().spawnEntity(location.add(0, 0.25, 0), EntityType.ARMOR_STAND);
        line5.setVisible(false);
        line5.setGravity(false);
        line5.setCustomNameVisible(true);
        line5.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "1. " + ChatColor.GREEN +  "No griefing, stealing, or lying");

        ArmorStand line6 = (ArmorStand) p.getWorld().spawnEntity(location.add(0, 0.25, 0), EntityType.ARMOR_STAND);
        line6.setVisible(false);
        line6.setGravity(false);
        line6.setCustomNameVisible(true);
        line6.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "Rules:");
    }
    public static void createWelcomeHologram(Player p){
        Location location = p.getLocation();
        ArmorStand line1 = (ArmorStand) p.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        line1.setVisible(false);
        line1.setGravity(false);
        line1.setCustomNameVisible(true);
        line1.setCustomName(ChatColor.BLUE + "" + ChatColor.BOLD + "=========================================");


        ArmorStand line2 = (ArmorStand) p.getWorld().spawnEntity(location.add(0, 0.5, 0), EntityType.ARMOR_STAND);
        line2.setVisible(false);
        line2.setGravity(false);
        line2.setCustomNameVisible(true);
        line2.setCustomName(ChatColor.LIGHT_PURPLE + "Welcome to The Zen Oasis!");


        ArmorStand line3 = (ArmorStand) p.getWorld().spawnEntity(location.add(0, 0.5, 0), EntityType.ARMOR_STAND);
        line3.setVisible(false);
        line3.setGravity(false);
        line3.setCustomNameVisible(true);
        line3.setCustomName(ChatColor.BLUE + "" + ChatColor.BOLD + "=========================================");
    }
}
