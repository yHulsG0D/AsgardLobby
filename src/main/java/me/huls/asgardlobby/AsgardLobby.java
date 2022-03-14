package me.huls.asgardlobby;

import me.huls.asgardlobby.battle.*;
import me.huls.asgardlobby.commands.FlyCommand;
import me.huls.asgardlobby.commands.GamemodeCommand;
import me.huls.asgardlobby.events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AsgardLobby extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("");
        events();
        commands();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("");
    }

    public void events() {
        Bukkit.getPluginManager().registerEvents(new LaunchPadEvent(), this);
        Bukkit.getPluginManager().registerEvents(new NoHungryEvent(), this);
        Bukkit.getPluginManager().registerEvents(new TablistEvent(), this);
        Bukkit.getPluginManager().registerEvents(new SetCustomHealthEvent(), this);
        Bukkit.getPluginManager().registerEvents(new GodEvent(), this);
        Bukkit.getPluginManager().registerEvents(new SetEntryItensEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BattleEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BattleEndEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BattlePvpEvent(),this);
        Bukkit.getPluginManager().registerEvents(new BattleKillEvent(), this);
        Bukkit.getPluginManager().registerEvents(new DeathMessageEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ScoreboardEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BattleLeaveEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakEvent(), this);
    }

    public void commands() {
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("fly").setExecutor(new FlyCommand());
    }
}
