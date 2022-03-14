package me.huls.asgardlobby.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SetCustomHealthEvent implements Listener {

    @EventHandler
    public void setHealth(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        e.getPlayer().setHealthScale(2.0);
    }

    @EventHandler
    public void setHealthTwo(PlayerRespawnEvent e) {
        e.getPlayer().setHealthScale(2.0);
    }
}
