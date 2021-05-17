package com.quacktopia.quacksaftey.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Magic implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("quacksafety.magic")){
            Player online = (Player) Bukkit.getOnlinePlayers();
        online.playSound(online.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT,10,10);
        online.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1000000, 255, true, false));
        Bukkit.broadcast(ChatColor.YELLOW + "[" + ChatColor.RED + "MAGIC" + ChatColor.YELLOW + "]" + ChatColor.LIGHT_PURPLE + sender.getName() + " cast Wingardium Leviosa!","quacksafety.magicreviever");
        }
    return true;
    }
}
