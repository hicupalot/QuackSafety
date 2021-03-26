package com.hicupalot.quacksaftey;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.projectiles.*;
import org.bukkit.event.*;


public class ProjectileInhibitor implements Listener {
    @EventHandler
    public void projectileLaunch(ProjectileLaunchEvent e) {
        Projectile projectile = e.getEntity();
            if (projectile.getShooter() instanceof Player) {
                Player player = (Player) projectile.getShooter();
                e.setCancelled(true);}}}