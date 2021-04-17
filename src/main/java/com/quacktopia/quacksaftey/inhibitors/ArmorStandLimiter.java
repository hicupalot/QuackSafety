package com.quacktopia.quacksaftey.inhibitors;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class ArmorStandLimiter implements Listener {
    @EventHandler
    public void ArmorStandChunk(PlayerInteractEvent e) {
        if (e.getPlayer().hasPermission("quacksafety.armorstandbypass"))
            return;
        if (e.getHand() == EquipmentSlot.HAND || e.getHand() == EquipmentSlot.OFF_HAND) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (e.getItem() == null) {
                    return;
                }
                int numberofarmorstands = 1;
                if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.ARMOR_STAND) || e.getPlayer().getInventory().getItemInOffHand().getType().equals(Material.ARMOR_STAND)) {
                    for (final Entity entity : e.getPlayer().getLocation().getChunk().getEntities()) {
                        if (entity instanceof ArmorStand) {
                            numberofarmorstands++;
                        }
                    }
                    if (numberofarmorstands > 5) {
                        e.setCancelled(true);
                        e.getPlayer().sendMessage(ChatColor.BLUE + "You have reached the maximum of 5 armour stands in a chunk");
                    }

                }
            }
        }


    }
}
