package me.huls.asgardlobby.battle;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class BattlePvpEvent implements Listener {

    @EventHandler
    public void battlePVP(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            if (event.getEntity() instanceof Player) {
                Player damager = (Player) event.getDamager();
                Player player = (Player) event.getEntity();
                if(BattleEvent.pvpMode.contains(damager.getName()) && BattleEvent.pvpMode.contains(player.getName())) {
                } else {
                    event.setCancelled(true);
                    damager.sendMessage("§cVocê só pode bater em jogadores que estão no modo pvp!");
                    return;
                }
            }
        }
    }
}