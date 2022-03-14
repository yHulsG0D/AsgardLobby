package me.huls.asgardlobby.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class NoHungryEvent implements Listener {

    @EventHandler
    public void noHungry(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player) {
            if (e.getFoodLevel() < 20) {
                e.setFoodLevel(20);
            }
        }
    }
}