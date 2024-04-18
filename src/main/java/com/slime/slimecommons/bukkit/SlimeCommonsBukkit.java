package com.slime.slimecommons.bukkit;

import com.slime.slimecommons.bukkit.listeners.*;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.UnknownDependencyException;
import org.bukkit.plugin.java.JavaPlugin;

public final class SlimeCommonsBukkit extends JavaPlugin {
    private static SlimeCommonsBukkit instance;
    private Economy economy;

    public SlimeCommonsBukkit() {
        instance = this;
    }

    public static SlimeCommonsBukkit getInstance() {
        return instance;
    }

    public Economy getEconomy(){
        return economy;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        start();
    }

    private void start() {
        getDependencies();
        getEvents();

        printLogo();
    }

    private void getEvents(){
        getServer().getPluginManager().registerEvents(new PlayerInteractEventListener(), this);
    }

    private void getDependencies(){
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getPluginLoader().disablePlugin(this);
            throw new UnknownDependencyException("PlaceholderAPI does not found");
        }

        if(Bukkit.getPluginManager().getPlugin("WorldGuard") == null) {
            getPluginLoader().disablePlugin(this);
            throw new UnknownDependencyException("WorldGuard does not found");
        }

        if (Bukkit.getPluginManager().getPlugin("Vault") == null){
            getPluginLoader().disablePlugin(this);
            throw new UnknownDependencyException("Vault does not found");
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if(rsp == null){
            getPluginLoader().disablePlugin(this);
            throw new UnknownDependencyException("Economy with Vault does not found");
        }
        economy = rsp.getProvider();
    }

    private void printLogo(){
        Logger.log("\n" +
                "   _____ _ _                 _____                                          \n" +
                "  / ____| (_)               / ____|                                         \n" +
                " | (___ | |_ _ __ ___   ___| |     ___  _ __ ___  _ __ ___   ___  _ __  ___ \n" +
                "  \\___ \\| | | '_ ` _ \\ / _ \\ |    / _ \\| '_ ` _ \\| '_ ` _ \\ / _ \\| '_ \\/ __|\n" +
                "  ____) | | | | | | | |  __/ |___| (_) | | | | | | | | | | | (_) | | | \\__ \\\n" +
                " |_____/|_|_|_| |_| |_|\\___|\\_____\\___/|_| |_| |_|_| |_| |_|\\___/|_| |_|___/\n" +
                "                                                                            \n");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
