package me.huls.asgardlobby.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

public class ScoreboardEvent implements Listener {

    @EventHandler
    public void setScore(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        int onPlayers = event.getPlayer().getServer().getOnlinePlayers().size();
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("test", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(" §d§lASGARD");
        Score score = objective.getScore("§1");
        score.setScore(10);
        Score score1 = objective.getScore("§fLobby: §a#1");
        score1.setScore(9);
        Score score2 = objective.getScore("§fOnline: §e" + onPlayers);
        score2.setScore(8);
        Score score3 = objective.getScore("§2");
        score3.setScore(7);
        Score score4 = objective.getScore("§fRankUP Bomba: §617");
        score4.setScore(6);
        Score score5 = objective.getScore("§3");
        score5.setScore(5);
        Score score6 = objective.getScore("   §7loja.asgard.net");
        score6.setScore(4);
        player.setScoreboard(board);
    }
}
