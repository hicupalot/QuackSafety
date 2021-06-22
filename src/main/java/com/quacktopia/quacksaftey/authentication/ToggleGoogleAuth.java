package com.quacktopia.quacksaftey.authentication;

import com.quacktopia.quacksaftey.bot.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ToggleGoogleAuth implements CommandExecutor {
    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
            if (sender.hasPermission("quacksafety.adminauth")) {
                Config.plugin.getConfig().set("GoogleAuth", true);
                sender.sendMessage(ChatColor.GOLD + "You have enabled Google Authentication you CANNOT disable this from ingame for safety");
                for (Player Staff : Bukkit.getOnlinePlayers()) {
                    if (Staff.hasPermission("quacksafety.auth")) {
                        Staff.kickPlayer("You have been kicked as Google Authentication has been enabled!");
                        Config.discord.getTextChannelById(Config.ADMIN_CHANNEL_ID).sendMessage("Google Authentication has been enabled!").queue();
                    }
                    else {
                        sender.sendMessage(ChatColor.RED+"You do not have permission to do that!");
                    }

                }
            }
        }
    return false;
    }
}