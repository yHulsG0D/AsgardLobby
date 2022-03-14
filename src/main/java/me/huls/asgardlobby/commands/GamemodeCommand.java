package me.huls.asgardlobby.commands;

import me.huls.asgardlobby.utils.ActionBarAPI;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas in-game!");
            return true;
        }

        Player p = (Player) sender;
        if (args.length < 1) {
            p.sendMessage("§c§lERRO! §cVocê não especificou o gamemode.");
            return true;
        }

        if (!p.hasPermission("asgardlobby.gamemode")) {
            p.sendMessage("§cVocê não tem permissão para utilizar este comando.");
        } else {

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("0")) {
                    p.setGameMode(GameMode.SURVIVAL);
                    ActionBarAPI.sendActionBar(p, "§e§lGM-0 -> §eSeu modo de jogo foi alterado!");
                    return true;
                }
                if (args[0].equalsIgnoreCase("1")) {
                    p.setGameMode(GameMode.CREATIVE);
                    ActionBarAPI.sendActionBar(p, "§e§lGM-1 -> §eSeu modo de jogo foi alterado!");
                    return true;
                }
                if (args[0].equalsIgnoreCase("2")) {
                    p.setGameMode(GameMode.ADVENTURE);
                    ActionBarAPI.sendActionBar(p, "§e§lGM-2 -> §eSeu modo de jogo foi alterado!");
                    return true;
                }
                if (args[0].equalsIgnoreCase("3")) {
                    p.setGameMode(GameMode.SPECTATOR);
                    ActionBarAPI.sendActionBar(p, "§e§lGM-3 -> §eSeu modo de jogo foi alterado!");
                    return true;
                }
            }
        }
        return false;
    }
}