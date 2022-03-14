package me.huls.asgardlobby.events;

import me.huls.asgardlobby.battle.BattleEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class GodEvent implements Listener {

    @EventHandler
    public void godMode(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if(BattleEvent.pvpMode.contains(player.getName())) return;
            e.setCancelled(true);
        }
    }
}