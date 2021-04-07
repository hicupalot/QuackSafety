package com.hicupalot.quacksaftey;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryCreativeEvent;
public class NBTBanner implements Listener {
    @EventHandler
    public void NBTBan(InventoryCreativeEvent e) {
        if (e.getClick() == ClickType.MIDDLE) {
            Player p = (Player) e.getWhoClicked();
            if (p.hasPermission("quackSaftey.admin.NBTBypass"))
                return;
        }
        if (e.getCursor().getType() == Material.CHEST || e.getCursor().getType() == Material.DISPENSER || e.getCursor().getType() == Material.TRAPPED_CHEST){
            e.setCancelled(true);
        }
        }

    }
