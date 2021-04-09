package com.hicupalot.quacksaftey;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class bookban implements Listener {
    @EventHandler

    public void BookBan(PlayerInteractEvent event) {

        ItemStack itemStack = event.getPlayer().getInventory().getItemInMainHand();
        ItemStack offHand = event.getPlayer().getInventory().getItemInOffHand();
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) { return; }
        if ((itemStack.getType() == Material.WRITABLE_BOOK || itemStack.getType() == Material.WRITTEN_BOOK) && !event.getPlayer().hasPermission("quacksaftey.book")) {

            event.getPlayer().closeInventory();
            event.setCancelled(true);

        }

        if ((offHand.getType() == Material.WRITABLE_BOOK || offHand.getType() == Material.WRITTEN_BOOK) && !event.getPlayer().hasPermission("quacksaftey.book")) {

            event.getPlayer().closeInventory();
            event.setCancelled(true);

        }}}
