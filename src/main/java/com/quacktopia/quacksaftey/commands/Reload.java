package com.quacktopia.quacksaftey.commands;

import com.quacktopia.quacksaftey.bot.Config;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Reload implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
            if (sender.hasPermission("quacksafety.reload")) {
                Config.plugin.saveConfig();
                Config.plugin.reloadConfig();
                sender.sendMessage(ChatColor.GOLD+"Reloaded the config.yml! You do NOT need to do this if you "+
                        "changed the options from ingame!");
            }
            else{
                sender.sendMessage(ChatColor.RED+"You do not have the required permissions!");
            }
        }
        return false;
    }
}

