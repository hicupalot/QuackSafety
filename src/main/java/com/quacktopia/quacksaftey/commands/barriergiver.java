package com.quacktopia.quacksaftey.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class barriergiver implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            PlayerInventory inventory = player.getInventory();
            inventory.addItem(new ItemStack(Material.BARRIER));
            sender.sendMessage(ChatColor.GOLD + "[QUACK] You have been given a Barrier");
        } else {
            sender.sendMessage(ChatColor.RED + "[QUACK] This is a Player Only Command");
            return false;
        }
        return false;
    }
}