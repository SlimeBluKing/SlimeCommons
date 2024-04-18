package com.slime.slimecommons.bungeecord;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.logging.Level;

public class Logger {
    public static void log(String log) {
        ProxyServer.getInstance().getLogger().info(log);
    }

    public static void log(Plugin plugin, String log) {
        plugin.getLogger().info(log);
    }

    public static void warning(String log) {
        ProxyServer.getInstance().getLogger().warning(log);
    }

    public static void warning(Plugin plugin, String log) {
        plugin.getLogger().warning(log);
    }

    public static void severe(String log) {
        ProxyServer.getInstance().getLogger().severe(log);
    }

    public static void severe(Plugin plugin, String log) {
        plugin.getLogger().severe(log);
    }

    public static void severe(String log, Exception e) {
        ProxyServer.getInstance().getLogger().log(Level.SEVERE, log, e);
    }

    public static void severe(Plugin plugin, String log, Exception e) {
        plugin.getLogger().log(Level.SEVERE, log, e);
    }
}