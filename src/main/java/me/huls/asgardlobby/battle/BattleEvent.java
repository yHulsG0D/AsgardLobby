package me.huls.asgardlobby.battle;

import me.huls.asgardlobby.utils.ItemBuilder;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class BattleEvent implements Listener {

    public static ArrayList<String> pvpMode = new ArrayList<>();

    @EventHandler
    public void interactPvP(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action action = e.getAction();
        ItemStack itemInHand = p.getItemInHand();

        if (!(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK))) return;
        if (!(itemInHand.getType().equals(Material.GOLD_SWORD))) return;
        if (!(itemInHand.getItemMeta().getDisplayName().equalsIgnoreCase("§ePVP"))) return;
        if(pvpMode.contains(p.getName())) return;

        pvpMode.add(p.getName());
        p.sendMessage("§d§lASGARD §7(*) §eVocê entrou no modo batalha!");
        p.getInventory().clear();
        p.setHealthScale(20.0);
        p.getInventory().setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
        p.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
        p.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
        p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
        p.getInventory().setItem(1, new ItemStack(Material.GOLDEN_APPLE, 6));
        p.getInventory().setItem(8, new ItemBuilder(Material.TRIPWIRE_HOOK).name("§cSair").lore("§7Clique para sair do PVP.").build());
    }
}