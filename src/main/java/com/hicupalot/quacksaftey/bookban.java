package com.hicupalot.quacksaftey;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class bookban implements Listener {
    @EventHandler
    public void BookBan(PlayerInteractEvent e) {
        if (e.getHand() == EquipmentSlot.HAND) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                if (e.getClickedBlock()==null)
                    return;
                }
                if (e.getClickedBlock().getType() == Material.WRITABLE_BOOK || e.getClickedBlock().getType() == Material.WRITTEN_BOOK) {
                    e.setCancelled(true);
                }
            }
        }

    }