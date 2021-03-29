package com.hicupalot.quacksaftey;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.material.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.*;
public class bookban implements Listener {
    @EventHandler
    public void BookBan(PlayerInteractEvent e) {
        if (e.getHand() == EquipmentSlot.HAND) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
        if (e.getClickedBlock().getType() == Material.WRITABLE_BOOK || e.getClickedBlock().getType() == Material.WRITTEN_BOOK) {
        e.setCancelled(true);
                }
            }
        }

    }}