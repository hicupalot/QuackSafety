package com.quacktopia.quacksaftey.inhibitors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
public class SpeedLimit implements Listener {
    @SuppressWarnings( "deprecation" )
    @EventHandler
    public void speedingticket(PlayerMoveEvent e) {
        if (e.getFrom().distance(e.getTo()) > 20.0) {
            e.setCancelled(true);
        Bukkit.broadcast(ChatColor.AQUA+"["+ ChatColor.RED+"STAFF"+ ChatColor.AQUA+"]"+ ChatColor.LIGHT_PURPLE + e.getPlayer().getName()+" is possibly hacking/speeding with a minimum " +
                "velocity of"+ e.getPlayer().getVelocity()+" Please check on this user", "quacksaftey.speedingticket");

    }
}}
