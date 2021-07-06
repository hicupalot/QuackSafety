package com.quacktopia.quacksaftey.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Magic implements CommandExecutor {
    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
            if (sender.hasPermission("quacksafety.magic")) {
                if (args.length == 0) {
                    Player online = (Player) Bukkit.getOnlinePlayers();
                    online.getWorld().strikeLightning(online.getLocation());
                    online.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 5, 2, true, false));
                    Bukkit.broadcast(ChatColor.YELLOW + "[" + ChatColor.RED + "MAGIC" + ChatColor.YELLOW + "]" + ChatColor.LIGHT_PURPLE + sender.getName() + " cast Wingardium Leviosa!", "quacksafety.magicreviever");
                    return false;
                }
            }
            if (args.length == 1) {
                Player target = Bukkit.getServer().getPlayer(args[1]);
                target.getWorld().strikeLightning(target.getLocation());
                target.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 5, 2, true, false));
                target.sendMessage("[" + ChatColor.RED + "MAGIC" + ChatColor.YELLOW + "]" + ChatColor.LIGHT_PURPLE + "You had Wingardium Leviosa cast on you by " + sender.getName());
            }
            if (args.length>=2){
                sender.sendMessage(ChatColor.RED+"Please do /magic to cast it on the entire server and /magic player to cast it on the entire server");
            }
            return false;
        }
   return false;
    }
}

