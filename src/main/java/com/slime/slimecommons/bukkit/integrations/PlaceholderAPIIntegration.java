package com.slime.slimecommons.bukkit.integrations;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlaceholderAPIIntegration {
    public static String parsePapi(Player player, String str) {
        return PlaceholderAPI.setPlaceholders(player, str);
    }
}
