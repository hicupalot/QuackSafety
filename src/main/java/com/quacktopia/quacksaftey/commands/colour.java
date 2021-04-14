package com.quacktopia.quacksaftey.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class colour implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("quacksaftey.colour")) {
            sender.sendMessage(ChatColor.WHITE + "[Quack] The colour code for black is &0");
            sender.sendMessage(ChatColor.DARK_BLUE + "[Quack] The colour code for dark blue is &1!");
            sender.sendMessage(ChatColor.DARK_GREEN + "[Quack] The colour code for dark green is &2");
            sender.sendMessage(ChatColor.DARK_AQUA + "[Quack] The colour code for aqua is &3");
            sender.sendMessage(ChatColor.DARK_RED + "[Quack] The colour code for dark red is &4");
            sender.sendMessage(ChatColor.DARK_PURPLE + "[Quack] The colour code for dark purple is &5");
            sender.sendMessage(ChatColor.GOLD + "[Quack] The colour code for gold is &6");
            sender.sendMessage(ChatColor.GRAY + "[Quack] The colour code for light grey is &7");
            sender.sendMessage(ChatColor.DARK_GRAY + "[Quack] The colour code for dark grey is &8");
            sender.sendMessage(ChatColor.BLUE + "[Quack] The colour code for blue is &9");
            sender.sendMessage(ChatColor.GREEN + "[Quack] The colour code for light green is &a");
            sender.sendMessage(ChatColor.AQUA + "[Quack] The colour code for light blue is &b");
            sender.sendMessage(ChatColor.RED + "[Quack] The colour code for red is &c");
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "[Quack] The colour code for pink is &d");
            sender.sendMessage(ChatColor.YELLOW + "[Quack] The colour code for yellow is &e");
            sender.sendMessage(ChatColor.WHITE + "[Quack] The colour code for magic is &k");
            sender.sendMessage(ChatColor.WHITE + "[Quack] The colour code for bold is &l");
            sender.sendMessage(ChatColor.WHITE + "[Quack] The colour code for strikethrough is &m");
            sender.sendMessage(ChatColor.WHITE + "[Quack] The colour code for italics is &o");
            sender.sendMessage(ChatColor.WHITE + "[Quack] The colour code for underline is &n");
            sender.sendMessage(ChatColor.WHITE + "[Quack] The colour code for white is &f");
        } else {
            sender.sendMessage(ChatColor.GOLD + "[QUACK]" + ChatColor.RED + "You do not have permission to run that command");
        }
        return true;

    }

}

