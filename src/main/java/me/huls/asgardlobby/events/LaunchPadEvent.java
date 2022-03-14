package me.huls.asgardlobby.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class LaunchPadEvent implements Listener {

    @EventHandler
    public void launchPad(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location location = event.getFrom().subtract(event.getTo());
        if (location.getBlockX() == 0 && location.getBlockZ() == 0 && location.getBlockY() == 0) return;

        Block downBlock = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
        if (!downBlock.getType().equals(Material.SLIME_BLOCK)) return;

        player.setVelocity(player.getVelocity().multiply(5f));
    }
}