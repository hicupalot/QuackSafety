package com.quacktopia.quacksaftey.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class feedback implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
            if (sender.hasPermission("quacksafety.feedback")) {
                sender.sendMessage(ChatColor.GOLD + "[Quack] If you have any feedback/bugs/suggestions" +
                        " about the server please put them here" + ChatColor.AQUA + " https://quacktopia.com/feedback");
            } else {
                sender.sendMessage(ChatColor.GOLD + "[QUACK]" + ChatColor.RED + " You do not have permission to run that command");
            }
        }
        return false;

    }

}