package me.huls.asgardlobby.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathMessageEvent implements Listener {

    @EventHandler
    public void deathMessage(PlayerDeathEvent event) {
        event.setDeathMessage(null);
    }
}
