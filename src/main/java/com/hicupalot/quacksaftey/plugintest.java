package com.hicupalot.quacksaftey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.command.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.permissions.Permission;
public class plugintest implements CommandExecutor{
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
             if (sender.hasPermission("quacksaftey.doesitwork")) {
                 sender.sendMessage(ChatColor.RED+"[QUACKSAFETY] You haven't broken it Hicup!");
            }
            else {
                 sender.sendMessage(ChatColor.GOLD +"[QUACK]"+ ChatColor.RED+"You do not have permission to run that command");
            }
            return true;

        }

    }
