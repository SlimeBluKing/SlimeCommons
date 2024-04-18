package com.slime.slimecommons.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.logging.Level;

public class Logger {
    public static void log(String log) {
        Bukkit.getLogger().info(log);
    }

    public static void log(Plugin plugin, String log) {
        plugin.getLogger().info(log);
    }

    public static void warning(String log) {
        Bukkit.getLogger().warning(log);
    }

    public static void warning(Plugin plugin, String log) {
        plugin.getLogger().warning(log);
    }

    public static void severe(String log) {
        Bukkit.getLogger().severe(log);
    }

    public static void severe(Plugin plugin, String log) {
        plugin.getLogger().severe(log);
    }

    public static void severe(String log, Exception e) {
        Bukkit.getLogger().log(Level.SEVERE, log, e);
    }

    public static void severe(Plugin plugin, String log, Exception e) {
        plugin.getLogger().log(Level.SEVERE, log, e);
    }
}
