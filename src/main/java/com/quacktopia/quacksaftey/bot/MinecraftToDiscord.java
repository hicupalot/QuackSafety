package com.quacktopia.quacksaftey.bot;

import net.dv8tion.jda.api.JDA;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MinecraftToDiscord implements CommandExecutor {
    static JDA MTD;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            final StringBuilder stb = new StringBuilder();
            for (int i = 1; i < args.length; ++i) {
                stb.append(args[i]);
                stb.append(" ");
            }
            if (sender.hasPermission("quacksafety.staffhelp")) {
                if (args.length < 1) {
                    sender.sendMessage(ChatColor.RED + "Please provide a message you wish to ask the other Helpers on the Discord");
                    return false;
                }
                if (args.length > 1) {
                    sender.sendMessage(ChatColor.RED + "Please use /staffhelp (message)");
                    return false;
                }
                if (MTD.getTextChannelById("812756243957284914") == null) {
                    return false;
                }
                MTD.getTextChannelById("812756243957284914").sendMessage("HelperHelp: " + sender.getName() + " requires help: " + stb.toString().trim() + "!").queue();
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission!");
            }
        }
            return false;
        }
    }

