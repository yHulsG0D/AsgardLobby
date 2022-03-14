package me.huls.asgardlobby.events;

import me.huls.asgardlobby.holders.EntryItensBuild;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class SetEntryItensEvent implements Listener {

    @EventHandler
    public void entryItens(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.getInventory().clear();
        p.getInventory().setHelmet(new ItemStack(Material.AIR));
        p.getInventory().setChestplate(new ItemStack(Material.AIR));
        p.getInventory().setLeggings(new ItemStack(Material.AIR));
        p.getInventory().setBoots(new ItemStack(Material.AIR));
        p.getInventory().setItem(4, EntryItensBuild.serverselector(p));
        p.getInventory().setItem(1, EntryItensBuild.infos(p));
        p.getInventory().setItem(7, EntryItensBuild.pvp(p));
    }

    @EventHandler
    public void respawnItens(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        p.getInventory().clear();
        p.getInventory().setHelmet(new ItemStack(Material.AIR));
        p.getInventory().setChestplate(new ItemStack(Material.AIR));
        p.getInventory().setLeggings(new ItemStack(Material.AIR));
        p.getInventory().setBoots(new ItemStack(Material.AIR));
        p.getInventory().setItem(4, EntryItensBuild.serverselector(p));
        p.getInventory().setItem(1, EntryItensBuild.infos(p));
        p.getInventory().setItem(7, EntryItensBuild.pvp(p));
    }
}