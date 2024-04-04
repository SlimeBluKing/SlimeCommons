package com.slime.slimecommons.listeners;

import com.slime.slimecommons.SlimeCommons;
import com.slime.slimecommons.events.PlayerLeftClickEvent;
import com.slime.slimecommons.events.PlayerRightClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractEventListener implements Listener {
    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event){
        if(event.getAction().toString().contains("RIGHT")){
            PlayerRightClickEvent rightClickEvent = new PlayerRightClickEvent(event.getPlayer(), event.getPlayer().getInventory().getItemInMainHand());
            SlimeCommons.getInstance().getServer().getPluginManager().callEvent(rightClickEvent);
        }

        if(event.getAction().toString().contains("LEFT")){
            PlayerLeftClickEvent leftClickEvent = new PlayerLeftClickEvent(event.getPlayer(), event.getPlayer().getInventory().getItemInMainHand());
            SlimeCommons.getInstance().getServer().getPluginManager().callEvent(leftClickEvent);
        }
    }
}
