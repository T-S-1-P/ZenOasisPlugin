package me.plugin.zenoasisplugin;

import me.plugin.zenoasisplugin.Commands.*;
import me.plugin.zenoasisplugin.Listeners.InventoryClickListener;
import me.plugin.zenoasisplugin.Listeners.WorldBorderMoveListener;
import org.bukkit.plugin.java.JavaPlugin;


public final class ZenOasisPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("town").setExecutor(new TownCommand(this));
        getCommand("hologram").setExecutor(new HologramsCommand());
        getCommand("towns").setExecutor(new TownsCommand());
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        getServer().getPluginManager().registerEvents(new WorldBorderMoveListener(), this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
