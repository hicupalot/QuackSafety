package com.quacktopia.quacksaftey.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class playtime implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("quacksafety.playtime")) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
            if (args.length < 0) {
                sender.sendMessage(ChatColor.GOLD + "[QUACK]" + ChatColor.RED + "Please do /playtime (player)");
                return true;
            }
                Player p = (Player) sender;
                if (target == null) {
                    sender.sendMessage(ChatColor.GOLD + "QUACK" + ChatColor.RED + "You must supply a valid Player");
                    return true;
                }
                target.getStatistic(Statistic.PLAY_ONE_MINUTE); //ticks played not minutes [always divide by 20]
                long ticks = target.getStatistic(Statistic.PLAY_ONE_MINUTE);
                long s = ticks / 20;
                long seconds = (s % (60 * 60 ));
                long hours = s / (60 * 60);
                long minutes = seconds / 60;
                long days = s/(60*60*24);
                seconds = s % 60;
                sender.sendMessage(ChatColor.AQUA + "Username" + ChatColor.YELLOW + " :" + ChatColor.GOLD +  target.getName());
                sender.sendMessage(ChatColor.AQUA +
                        "Playtime" + ChatColor.YELLOW + " :" + ChatColor.GOLD + days + " days" + hours + " hours" + minutes + " minutes" + seconds + " seconds"  + ".");
                sender.sendMessage(ChatColor.AQUA + "Games Quit" + ChatColor.YELLOW + " :" + ChatColor.GOLD +  target.getStatistic(Statistic.LEAVE_GAME));
            } else {
            sender.sendMessage(ChatColor.GOLD + "[QUACK]" + ChatColor.RED + "You do not have permission to run that command");
            }
        return true;
        }
}

