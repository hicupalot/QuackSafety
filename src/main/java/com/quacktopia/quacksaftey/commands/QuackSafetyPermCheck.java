package com.quacktopia.quacksaftey.commands;

import com.quacktopia.quacksaftey.bot.Config;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QuackSafetyPermCheck implements CommandExecutor { //For testing if its just LuckPerms or my code!
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage(ChatColor.GOLD + "QuackSafety:");
            sender.sendMessage(ChatColor.GOLD + "Author: " + Config.plugin.getDescription().getAuthors());
            sender.sendMessage(ChatColor.GOLD + "Version: " + Config.plugin.getDescription().getVersion());
        }
        return false;
    }
}
