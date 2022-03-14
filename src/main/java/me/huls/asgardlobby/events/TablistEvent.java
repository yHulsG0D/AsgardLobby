package me.huls.asgardlobby.events;

import me.huls.asgardlobby.utils.TabAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TablistEvent implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        TabAPI.sendHeaderAndFooter(p, "\n§d§lASGARD\n   §floja.asgard.net\n", "\n§eTwitter: §f@Asgard\n§eDiscord: §fdiscord.gg/asgard\n\n§7Estamos atualmente com§f " + p.getServer().getOnlinePlayers().size() + " §7jogadores online!\n§eAdquira produtos acessando nosso site: §floja.asgard.net\n");
    }
}