package com.quacktopia.quacksaftey.inhibitors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.inventory.ItemStack;

public class SpeedLimit implements Listener {
    @SuppressWarnings("deprecation")
    @EventHandler(priority = EventPriority.LOW)
    public void speedingticket(PlayerVelocityEvent e) {
        if (!e.getPlayer().isFlying()) {
            if (e.getPlayer().getFallDistance() > 5) {
                return;
            }
            if (e.getVelocity().lengthSquared() > 4 && (e.getVelocity().lengthSquared() < 10)) {
                    Bukkit.broadcast(ChatColor.AQUA + "[" + ChatColor.RED + "STAFF" + ChatColor.AQUA + "]" + ChatColor.LIGHT_PURPLE + e.getPlayer().getName() + " is possibly hacking/speeding with a minimum " +
                            "velocity of" + e.getPlayer().getVelocity() + " Please check on this user", "quacksaftey.speedingticket");
                }
            }
        }
    @EventHandler
    @SuppressWarnings("deprecation")
    public void flyingspeedticket(PlayerVelocityEvent e) {
        if (e.getPlayer().isFlying()) {
            if (e.getVelocity().lengthSquared() > 6 && e.getVelocity().lengthSquared() < 15) {
                Bukkit.broadcast(ChatColor.AQUA + "[" + ChatColor.RED + "STAFF" + ChatColor.AQUA + "]" + ChatColor.LIGHT_PURPLE + e.getPlayer().getName() + " is possibly hacking/speeding with a minimum " +
                        "velocity of" + e.getPlayer().getVelocity() + " Please check on this user", "quacksaftey.speedingticket");
            }
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    @SuppressWarnings("deprecation")
    public void majorspeedingviolation(PlayerVelocityEvent e) {
        if (e.getVelocity().lengthSquared() > 20) {
            e.setCancelled(true);
            Bukkit.broadcast(ChatColor.AQUA + "[" + ChatColor.RED + "STAFF" + ChatColor.AQUA + "]" + ChatColor.LIGHT_PURPLE + e.getPlayer().getName() + " is possibly hacking/speeding with a minimum " +
                    "velocity of" + e.getPlayer().getVelocity() + " Please check on this user", "quacksaftey.speedingticket");
        }
    }

    @EventHandler (priority = EventPriority.HIGH)
    public void speedbootsviolation(PlayerVelocityEvent e) {
        if (e.getVelocity().lengthSquared() > 15) {
            if (!e.getPlayer().getInventory().getBoots().getType().isEmpty()) {
                e.getPlayer().getInventory().setBoots(new ItemStack(Material.AIR));
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    @SuppressWarnings("deprecation")
    public void BlueIceException(PlayerVelocityEvent e) {
        if (e.getVelocity().lengthSquared() > 100000) {
            if (e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.BLUE_ICE) {
                e.setCancelled(true);
                Bukkit.broadcast(ChatColor.AQUA + "[" + ChatColor.RED + "STAFF" + ChatColor.AQUA + "]" + ChatColor.LIGHT_PURPLE + e.getPlayer().getName() + " is possibly hacking/speeding with a minimum " +
                        "velocity of" + e.getPlayer().getVelocity() + " Please check on this user", "quacksaftey.speedingticket");
            }
        }
    }
}
