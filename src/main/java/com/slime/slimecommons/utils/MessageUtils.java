package com.slime.slimecommons.utils;

import org.bukkit.ChatColor;

/***
 * @deprecated The class '{@link com.slime.slimecommons.utils.MessageUtils}' is marked for removal. Use '{@link com.slime.slimecommons.utils.MessageBuilder}' instead.
 */
@Deprecated (forRemoval = true)
public class MessageUtils {
    public static String Colorize(String value){
        return ChatColor.translateAlternateColorCodes('&', value);
    }
}
