package com.slime.slimecommons.bungeecord.utils;

import com.slime.slimecommons.bungeecord.Logger;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageBuilder {
    private final List<String> messages;

    public MessageBuilder(String message) {
        messages = new ArrayList<>();
        messages.add(message);
    }

    public MessageBuilder(List<String> message) {
        messages = message;
    }

    public void replacePlaceholder(String placeholder, Object value) {
        messages.replaceAll(message -> message.replace(placeholder, value.toString()));
    }

    public void replacePlaceholders(Map<String, Object> values) {
        for(Map.Entry<String, Object> entry : values.entrySet()){
            replacePlaceholder(entry.getKey(), entry.getValue());
        }
    }

    public void send(ProxiedPlayer player) {
        for(String message : messages) {
            player.sendMessage(new TextComponent(Colorize(message)));
        }
    }

    public void sendToConsole() {
        for(String message : messages) {
            Logger.log(Colorize(message));
        }
    }

    public static String Colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
