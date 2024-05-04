package com.slime.slimecommons.bukkit.utils;

import com.slime.slimecommons.bukkit.integrations.PlaceholderAPIIntegration;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ActionBarBuilder {
    private String message;

    public ActionBarBuilder(String message) {
        this.message = message;
    }

    public void parsePapi(Player player) {
        message = PlaceholderAPIIntegration.parsePapi(player, message);
    }

    public void send(Player player) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MessageBuilder.Colorize(message)));
    }
}
