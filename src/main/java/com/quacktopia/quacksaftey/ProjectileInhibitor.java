package com.quacktopia.quacksaftey;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;


public class ProjectileInhibitor implements Listener {
    @EventHandler
    public void projectileLaunch(ProjectileLaunchEvent e) {
        Projectile projectile = e.getEntity();
        if (projectile.getShooter() instanceof Player) {
            Player player = (Player) projectile.getShooter();
            e.setCancelled(true);
        }
    }
}