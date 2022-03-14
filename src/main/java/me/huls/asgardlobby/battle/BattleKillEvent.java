package me.huls.asgardlobby.battle;
;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class BattleKillEvent implements Listener {

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity.getType() == EntityType.PLAYER)) return;
        Player player = (Player) entity;
        Player killer = entity.getKiller();
        if (BattleEvent.pvpMode.contains(killer.getName())) {
            player.sendMessage("§aVocê foi morto por §f" + entity.getKiller().getName() + "§a.");
            killer.sendMessage("§aVocê matou o jogador §f" + entity.getName() + "§a.");
        }
    }
}