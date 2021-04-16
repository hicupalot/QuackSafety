package com.quacktopia.quacksaftey.commands;

import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class playtime implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("quacksaftey.playtime")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.getStatistic(Statistic.PLAY_ONE_MINUTE); //ticks played not minutes
                int seconds = p.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
                int minutes = seconds / 60;
                int hours = minutes / 60;
                int days = hours / 24;
                sender.sendMessage(ChatColor.GOLD + p.getName() + ":" +
                        "Playtime:" + days + hours + minutes + seconds + ".");
                sender.sendMessage(ChatColor.BLUE + "Games Quit:" + p.getStatistic(Statistic.LEAVE_GAME));
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to run this command");
            }
        }
    return true;}
}
