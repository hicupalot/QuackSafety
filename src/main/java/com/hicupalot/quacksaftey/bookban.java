package com.hicupalot.quacksaftey;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.*;
import org.bukkit.permissions.*;

public class bookban implements Listener {
    @EventHandler
    public void BookBan(PlayerInteractEvent e) {
        if (e.getHand() == EquipmentSlot.HAND || e.getHand() == EquipmentSlot.OFF_HAND) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                if (e.getItem()==null) {
                    return;
                }
                // Bukkit.broadcastMessage(e.getItem().getType().name());
                if (e.getItem().getType() == Material.WRITABLE_BOOK || e.getItem().getType() == Material.WRITTEN_BOOK) {
                    e.getPlayer().closeInventory();
                    e.setCancelled(true);
                }
            }
        }


    }}
