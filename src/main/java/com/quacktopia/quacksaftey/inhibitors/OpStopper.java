package com.quacktopia.quacksaftey.inhibitors;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class OpStopper implements Listener {
    @SuppressWarnings("unused")
    public void OpEvent(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().toLowerCase().startsWith("/op")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "You can't use /op from ingame for safety reasons!");
        }
    }
}