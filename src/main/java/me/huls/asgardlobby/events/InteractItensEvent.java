package me.huls.asgardlobby.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractItensEvent implements Listener {

    @EventHandler
    public void interactEvent(PlayerInteractEvent e) {
        Player player = e.getPlayer();
    }
}
