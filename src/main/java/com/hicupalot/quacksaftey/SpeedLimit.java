package com.hicupalot.quacksaftey;
import org.bukkit.Server;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.util.*;
import org.bukkit.event.*;
import org.bukkit.*;
public class SpeedLimit implements Listener {
    @EventHandler
    public void speedingticket(PlayerMoveEvent e) {
        if(e.getFrom().distance(e.getTo()) > 20.0)
            e.setCancelled(true);
        Bukkit.broadcast("The user"+ e.getPlayer().getName()+" is possibly hacking/speeding with a minimum " +
                "velocity of"+
        e.getPlayer().getVelocity()+" Please check on this user", "quacksaftey.speedingticket");

    }
}
