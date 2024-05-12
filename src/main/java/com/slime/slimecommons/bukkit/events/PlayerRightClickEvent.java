package com.slime.slimecommons.bukkit.events;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Getter
public class PlayerRightClickEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final ItemStack item;

    public PlayerRightClickEvent(Player player, ItemStack item){
        this.player = player;
        this.item = item;
    }

    @Override
    public @NotNull HandlerList getHandlers(){
        return handlers;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }
}
