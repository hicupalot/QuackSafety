package com.quacktopia.quacksaftey.inhibitors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("deprecation")
    public class LaggOmeter implements Listener {
    private HashMap<UUID, Long> cooldown = new HashMap<UUID,Long>();
    private int cooldowntime = 3600;

        @EventHandler
        public void AnyItemFrame(PlayerInteractEvent e) {
        Player p = e.getPlayer();
            if (e.getPlayer().hasPermission("quacksafety.itemframebypass"))
                return;
            if (e.getHand() == EquipmentSlot.HAND){
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (e.getItem() == null) {
                        return;
                    }
                    int numberofitemframes = 1;
                    if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.ITEM_FRAME) || e.getPlayer().getInventory().getItemInOffHand().getType().equals(Material.ITEM_FRAME)) {
                        for (Entity entity : e.getPlayer().getLocation().getChunk().getEntities()) {
                            if (entity instanceof ItemFrame) {
                                numberofitemframes++;
                            }
                        }
                        if (numberofitemframes == 100) {
                            Bukkit.broadcast(ChatColor.YELLOW + "[" + ChatColor.RED + "LAG-O-METER" + ChatColor.YELLOW + "]" + ChatColor.LIGHT_PURPLE + e.getPlayer().getName() + " is possibly trying to exploit the server by placing " +
                                    " 100 Item Frames in a single chunk", "quacksafety.laggometer");
                        cooldown.put(p.getUniqueId(),System.currentTimeMillis());

                        }
                        if (numberofitemframes > 100){
                            if (cooldown.containsKey(p.getUniqueId())){
                                long secondsleft = (System.currentTimeMillis() - cooldown.get(p.getUniqueId()));
                                if (secondsleft <= 0) {
                            Bukkit.broadcast(ChatColor.YELLOW + "[" + ChatColor.RED + "LAG-O-METER" + ChatColor.YELLOW + "]" + ChatColor.LIGHT_PURPLE + e.getPlayer().getName() + " is possibly trying to exploit the server by placing " +
                             " more than 100 Item Frames in a single chunk", "quacksafety.laggometer");
                                    cooldown.put(p.getUniqueId(),System.currentTimeMillis());
                                }
                                else {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        @EventHandler
        public void DroppedItems(PlayerDropItemEvent e) {
            Player p = e.getPlayer();
            if (e.getPlayer().hasPermission("quacksafety.dropitembypass"))
                return;
            if (e.getPlayer().dropItem(false)) {
                int numberofdroppeditems = 1;
                for (Entity entity : e.getPlayer().getLocation().getChunk().getEntities()) {
                    if (entity instanceof Item) {
                        numberofdroppeditems++;
                    }
                }
                if (numberofdroppeditems == 640) {
                    Bukkit.broadcast(ChatColor.YELLOW + "[" + ChatColor.RED + "LAG-O-METER" + ChatColor.YELLOW + "]" + ChatColor.LIGHT_PURPLE + e.getPlayer().getName() + " is possibly trying to exploit the server by dropping " +
                            "640 Item Drops in a single chunk", "quacksafety.laggometer");
                    cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                }
                if (numberofdroppeditems > 640) {
                    if (cooldown.containsKey(p.getUniqueId())){
                        long secondsleft = (System.currentTimeMillis() - cooldown.get(p.getUniqueId()));
                        if (secondsleft <= 0) {
                            Bukkit.broadcast(ChatColor.YELLOW + "[" + ChatColor.RED + "LAG-O-METER" + ChatColor.YELLOW + "]" + ChatColor.LIGHT_PURPLE + e.getPlayer().getName() + " is possibly trying to exploit the server by dropping " +
                                    " more than 640 Item Drops in a single chunk", "quacksafety.laggometer");
                            cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                        }
                        else {
                            return;

                    }
                }
            }
        }
    }
        @EventHandler
        public void Painting(PlayerInteractEvent e) {
            Player p = e.getPlayer();
            if (e.getPlayer().hasPermission("quacksafety.paintingbypass"))
                return;
            if (e.getHand() == EquipmentSlot.HAND) {
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (e.getItem() == null) {
                        return;
                    }
                    int numberofpaintings = 1;
                    if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.PAINTING) || e.getPlayer().getInventory().getItemInOffHand().getType().equals(Material.PAINTING)) {
                        for (Entity entity : e.getPlayer().getLocation().getChunk().getEntities()) {
                            if (entity instanceof ItemFrame) {
                                numberofpaintings++;
                            }
                        }
                        if (numberofpaintings == 100) {
                            Bukkit.broadcast(ChatColor.YELLOW + "[" + ChatColor.RED + "LAG-O-METER" + ChatColor.YELLOW + "]" + ChatColor.LIGHT_PURPLE + e.getPlayer().getName() + " is possibly trying to exploit the server by placing " +
                                    " 100 paintings in a single chunk", "quacksafety.laggometer");
                            cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                        }
                        if (numberofpaintings > 100) {
                            if (cooldown.containsKey(p.getUniqueId())){
                                long secondsleft = (System.currentTimeMillis() - cooldown.get(p.getUniqueId()));
                                if (secondsleft <= 0) {
                                Bukkit.broadcast(ChatColor.YELLOW + "[" + ChatColor.RED + "LAG-O-METER" + ChatColor.YELLOW + "]" + ChatColor.LIGHT_PURPLE + e.getPlayer().getName() + " is possibly trying to exploit the server by placing " +
                                            " more then 100 paintings in a single chunk", "quacksafety.laggometer");
                                    cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                                }
                                else {
                                    return;
                                }
                            }
                        }
                    }
                }

            }
        }
    }