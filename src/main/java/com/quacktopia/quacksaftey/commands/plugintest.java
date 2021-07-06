package com.quacktopia.quacksaftey.commands;

import com.quacktopia.quacksaftey.bot.Config;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class plugintest implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
            if (sender.hasPermission("quacksafety.doesitwork")) {
                sender.sendMessage(ChatColor.RED + "[QUACKSAFETY] You haven't broken it Hicup!" + "Your user is" + sender.getName());
                sender.sendMessage(ChatColor.GOLD+"Hard Depends: "+ Config.plugin.getDescription().getDepend().toString());
                sender.sendMessage(ChatColor.GOLD+"Soft Depends: "+ Config.plugin.getDescription().getSoftDepend().toString());
            } else {
                sender.sendMessage(ChatColor.GOLD + "[QUACK]" + ChatColor.RED + " You do not have permission to run that command");
            }
        }
        return false;

    }

}
