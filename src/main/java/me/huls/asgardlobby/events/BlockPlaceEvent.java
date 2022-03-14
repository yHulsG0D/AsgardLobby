package me.huls.asgardlobby.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockPlaceEvent implements Listener {

    @EventHandler
    public void blockPlace(org.bukkit.event.block.BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("asgard.build")) return;
        player.sendMessage("§cVocê não tem permissão para construir.");
        event.setCancelled(true);
    }
}
