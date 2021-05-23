package com.quacktopia.quacksaftey.Bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.Message;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MinecraftToDiscord implements CommandExecutor {
    static JDA MTD;
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
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
        if (args.length > 1){
            sender.sendMessage(ChatColor.RED+"Please use /staffhelp (message)");
            return false;
        }
        MTD.getTextChannelById("812756243957284914").sendMessage("HelperHelp: "+ sender.getName() + " requires help: "+ stb.toString().trim()+ "!").queue();
        }
            else {
                sender.sendMessage(ChatColor.RED + "You do not have permission!");
            }
            return false;
        }
    }
