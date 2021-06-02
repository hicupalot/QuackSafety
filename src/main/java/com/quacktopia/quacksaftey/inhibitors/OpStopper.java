package com.quacktopia.quacksaftey.inhibitors;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class OpStopper implements Listener {
    @SuppressWarnings("unused")
    public void OpEvent(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().equals("/op")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "You can't op from ingame!");
        }
    }
}