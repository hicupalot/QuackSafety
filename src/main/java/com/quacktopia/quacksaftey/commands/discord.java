package com.quacktopia.quacksaftey.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class discord implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("quacksafety.discord")) {
            sender.sendMessage(ChatColor.GOLD + "[Quack] Join the Discord here" + ChatColor.AQUA + " https://quacktopia.com/discord! " +
                    ChatColor.GOLD + "Please remember you have to be 13+ to use Discord!");
        } else {
            sender.sendMessage(ChatColor.GOLD + "[QUACK]" + ChatColor.RED + " You do not have permission to run that command");
        }
        return false;

    }

}
