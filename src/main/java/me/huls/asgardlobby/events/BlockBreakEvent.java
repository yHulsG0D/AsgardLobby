package me.huls.asgardlobby.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockBreakEvent implements Listener {

    @EventHandler
    public void breakBlock(org.bukkit.event.block.BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("asgard.build")) return;
        player.sendMessage("§cVocê não tem permissão para construir.");
        event.setCancelled(true);
    }
}
