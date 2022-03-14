package me.huls.asgardlobby.commands;

import me.huls.asgardlobby.utils.ActionBarAPI;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas in-game");
            return true;
        }
        Player p = (Player) sender;
        if (!(p.hasPermission("asgardlobby.fly"))) {
            p.sendMessage("§cSomente VIPs podem utilizar este comando.");
            return true;
        } else {
            if (p.getAllowFlight()) {
                p.setAllowFlight(false);
                p.setFlying(false);
                ActionBarAPI.sendActionBar(p, "§e§lFLY -> §eDesativado com sucesso!");
                p.playSound(p.getLocation(), Sound.CREEPER_DEATH, 1.0f, 1.0f);
            } else {
                p.setAllowFlight(true);
                ActionBarAPI.sendActionBar(p, "§e§lFLY -> §eAtivado com sucesso!");
            }
        }
        return true;
    }
}
