package com.quacktopia.quacksaftey.commands;

import net.md_5.bungee.api.ChatColor;
import org.apache.logging.log4j.core.config.plugins.util.PluginManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class QuackSafetyPermCheck extends JavaPlugin implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage(ChatColor.GOLD + "QuackSafety:");
            sender.sendMessage(ChatColor.GOLD + "Author: " + getDescription().getAuthors());
            sender.sendMessage(ChatColor.GOLD + "Version: " + getDescription().getVersion());
        }
        return false;
    }
}
