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
            String username = args[1];
                Player target = Bukkit.getServer().getPlayer(args[1]);
                Player p = (Player) sender;
            if (args.length == 0) {
                sender.sendMessage(ChatColor.GOLD + "[QUACK]" + ChatColor.RED + "Please do /playtime (player)");
                return false;
            }
            if (args.length>2){
                sender.sendMessage(ChatColor.GOLD + "[QUACK]" + ChatColor.RED + "Please do /playtime (player)");
                return false;
            }
                if (target == null) {
                    sender.sendMessage(ChatColor.GOLD + "QUACK" + ChatColor.RED + "You must supply a valid Player");
                    return false;
                }
                target.getStatistic(Statistic.PLAY_ONE_MINUTE); //ticks played not minutes [always divide by 20]
                long ticks = target.getStatistic(Statistic.PLAY_ONE_MINUTE);
                long s = ticks / 20;
                long seconds = (s % (60 * 60 ));
                long hours = s / (60 * 60);
                long minutes = seconds / 60;
                long days = s/(60*60*24);
                long hours1 = (s % hours*60*60);
                seconds = s % 60;
                p.sendMessage(ChatColor.AQUA + "Username" + ChatColor.YELLOW + ": " + ChatColor.GOLD +  target.getName());
                p.sendMessage(ChatColor.AQUA +
                        "Playtime" + ChatColor.YELLOW + ": " + ChatColor.GOLD + days + " days" + hours + " hours" + minutes + " minutes" + seconds + " seconds"  + ".");
                p.sendMessage(ChatColor.AQUA + "Games Quit" + ChatColor.YELLOW + ": " + ChatColor.GOLD +  target.getStatistic(Statistic.LEAVE_GAME));
            } else {
            sender.sendMessage(ChatColor.GOLD + "[QUACK]" + ChatColor.RED + " You do not have permission to run that command");
            }
        return false;
        }
}

