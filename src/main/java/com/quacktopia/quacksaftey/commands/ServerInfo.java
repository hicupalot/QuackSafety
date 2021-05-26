package com.quacktopia.quacksaftey.commands;

import com.plotsquared.core.PlotSquared;
import net.minecraft.server.v1_16_R3.MinecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.io.Console;

public class ServerInfo implements CommandExecutor {
    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
            if (sender.hasPermission("quacksafety.serverinfo")) {
                sender.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "[QUACKTOPIA CREATIVE]:");
                sender.sendMessage(ChatColor.BLUE + "Player Count: " + MinecraftServer.getServer().getPlayerCount());
                sender.sendMessage(ChatColor.BLUE + "TPS: " + MinecraftServer.getServer().recentTps.length);
                sender.sendMessage(ChatColor.BLUE + "Number of Plots: " + PlotSquared.get().getPlots("world"));
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to perform this");
            }
            return false;
        }
        return false;
    }
}

