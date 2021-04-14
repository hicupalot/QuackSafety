package com.quacktopia.quacksaftey.inhibitors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("deprecation")
    public class LaggOmeter implements Listener {
        @EventHandler
        public void AnyItemFrame(PlayerInteractEvent e) {
            if (e.getPlayer().hasPermission("quacksaftey.itemframebypass"))
                return;
            if (e.getHand() == EquipmentSlot.HAND){
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (e.getItem() == null) {
                        return;
                    }
                    int numberofitemframes = 1;
                    if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.ITEM_FRAME) || e.getPlayer().getInventory().getItemInOffHand().getType().equals(Material.ITEM_FRAME)) {
                        for (final Entity entity : e.getPlayer().getLocation().getChunk().getEntities()) {
                            if (entity instanceof ItemFrame) {
                                numberofitemframes++;
                            }
                        }
                        if (numberofitemframes > 100) {
                            Bukkit.broadcast(ChatColor.YELLOW+"["+ ChatColor.RED+"LAG-O-METER"+ ChatColor.YELLOW+"]"+ ChatColor.LIGHT_PURPLE + e.getPlayer().getName()+" is possibly trying to exploit the server by placing " +
                                    " more then 100 Item Frames in a single chunk", "quacksaftey.laggometer");
                        }

                    }

                }

            }


        }
        @EventHandler
        public void DroppedItems(PlayerDropItemEvent e) {
            if (e.getPlayer().hasPermission("quacksaftey.dropitembypass"))
                return;
                if (e.getPlayer().dropItem(true)) {
                }
                    int numberofdroppeditems = 1;
                        for (final Entity entity : e.getPlayer().getLocation().getChunk().getEntities()) {
                            if (entity instanceof Item) {
                                numberofdroppeditems++;
                            }
                        }
                        if (numberofdroppeditems > 6400) {
                            Bukkit.broadcast(ChatColor.YELLOW+"["+ ChatColor.RED+"LAG-O-METER"+ ChatColor.YELLOW+"]"+ ChatColor.LIGHT_PURPLE + e.getPlayer().getName()+" is possibly trying to exploit the server by dropping " +
                                    " more then 100 ItemStack Drops in a single chunk", "quacksaftey.laggometer");
                        }

                    }
                }
