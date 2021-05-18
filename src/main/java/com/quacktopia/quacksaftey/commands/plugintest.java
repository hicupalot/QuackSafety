package com.quacktopia.quacksaftey.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
public class plugintest implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("quacksafety.doesitwork")) {
            sender.sendMessage(ChatColor.RED + "[QUACKSAFETY] You haven't broken it Hicup!" + "Your user is" + sender.getName());
        } else {
            sender.sendMessage(ChatColor.GOLD + "[QUACK]" + ChatColor.RED + " You do not have permission to run that command");
        }
        return false;

    }

}
