package me.huls.asgardlobby.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MotdEvent implements Listener  {

    @EventHandler
    public void onMotd(ServerListPingEvent e) {
        if(Bukkit.hasWhitelist()) {
            e.setMotd("Linha1" + "" + "");
        } else {
            e.setMotd("");
        }
    }
}
