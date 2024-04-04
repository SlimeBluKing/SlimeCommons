package com.slime.slimecommons;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.logging.Level;

/***
 * @deprecated The class '{@link com.slime.slimecommons.Logging}' is marked for removal. Use '{@link com.slime.slimecommons.Logger}' instead.
 */
@Deprecated (forRemoval = true)
public class Logging {
    public static void log(String log) {
        deprecatedWarn();
        Bukkit.getLogger().info(log);
    }

    public static void log(Plugin plugin, String log) {
        deprecatedWarn();
        plugin.getLogger().info(log);
    }

    public static void warning(String log) {
        deprecatedWarn();
        Bukkit.getLogger().warning(log);
    }

    public static void warning(Plugin plugin, String log) {
        deprecatedWarn();
        plugin.getLogger().warning(log);
    }

    public static void severe(String log) {
        deprecatedWarn();
        Bukkit.getLogger().severe(log);
    }

    public static void severe(Plugin plugin, String log) {
        deprecatedWarn();
        plugin.getLogger().severe(log);
    }

    public static void severe(String log, Exception e) {
        deprecatedWarn();
        Bukkit.getLogger().log(Level.SEVERE, log, e);
    }

    public static void severe(Plugin plugin, String log, Exception e) {
        deprecatedWarn();
        plugin.getLogger().log(Level.SEVERE, log, e);
    }

    private static void deprecatedWarn() {
        Bukkit.getLogger().warning("The class 'Logging' is marked for cancellation. Use 'Logger' instead");
    }
}
