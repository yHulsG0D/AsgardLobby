package me.huls.asgardlobby.battle;

import me.huls.asgardlobby.holders.EntryItensBuild;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class BattleLeaveEvent implements Listener {

    @EventHandler
    public void battleLeave(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack itemInHand = player.getItemInHand();

        if (!(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK))) return;
        if(!(itemInHand.getType().equals(Material.TRIPWIRE_HOOK))) return;
        if (!(itemInHand.getItemMeta().getDisplayName().equalsIgnoreCase("§cSair"))) return;
        if(!(BattleEvent.pvpMode.contains(player.getName()))) return;
        BattleEvent.pvpMode.remove(player.getName());
        player.getInventory().setHelmet(new ItemStack(Material.AIR));
        player.getInventory().setChestplate(new ItemStack(Material.AIR));
        player.getInventory().setLeggings(new ItemStack(Material.AIR));
        player.getInventory().setBoots(new ItemStack(Material.AIR));
        player.getInventory().clear();
        player.getInventory().setItem(4, EntryItensBuild.serverselector(player));
        player.getInventory().setItem(1, EntryItensBuild.infos(player));
        player.getInventory().setItem(7, EntryItensBuild.pvp(player));
        player.setHealthScale(2.0);
        player.sendMessage("§d§lASGARD §7(*) §cVocê saiu do modo batalha!");
    }
}
