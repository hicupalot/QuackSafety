package com.quacktopia.quacksaftey.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MinecraftToDiscord implements CommandExecutor {
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
                if (Config.discord.getTextChannelById(Config.SERVER_HELPER_CHANNEL_ID) == null) {
                    return false;
                }
                Config.discord.getTextChannelById(Config.SERVER_HELPER_CHANNEL_ID).sendMessage("HelperHelp: " + sender.getName() + " requires help: " + stb.toString().trim() + "!").queue();
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission!");
            }
        }
            return false;
        }
    }


