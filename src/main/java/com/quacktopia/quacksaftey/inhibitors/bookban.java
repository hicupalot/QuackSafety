package com.quacktopia.quacksaftey.inhibitors;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class bookban implements Listener {
    @EventHandler
    public void BookBan(PlayerInteractEvent e) {
        if(e.getPlayer().hasPermission("quacksaftey.bookbypass"))
            return;
        if (e.getHand() == EquipmentSlot.HAND || e.getHand() == EquipmentSlot.OFF_HAND) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                if (e.getItem()==null) {
                    return;
                }
                // Bukkit.broadcastMessage(e.getItem().getType().name());
                if (e.getItem().getType() == Material.WRITABLE_BOOK || e.getItem().getType() == Material.WRITTEN_BOOK) {
                    e.getPlayer().closeInventory(); //Needed to close the Book and Quill GUI
                    e.setCancelled(true);
                }
            }
        }


    }}
