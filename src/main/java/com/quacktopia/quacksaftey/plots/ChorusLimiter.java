package com.quacktopia.quacksaftey.plots;

import com.plotsquared.core.location.Location;
import com.plotsquared.core.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class ChorusLimiter implements Listener {
    @EventHandler
    public void Chorus(PlayerItemConsumeEvent e) {
        Location loc = null;
        assert false;
        loc.isPlotArea();
        Plot plot = Plot.getPlot(loc);
        plot.isAdded(e.getPlayer().getUniqueId());
        Player p = e.getPlayer();
        if (loc.isPlotArea() && !loc.isPlotRoad()) {
            if (e.getItem().equals(new ItemStack(Material.CHORUS_FRUIT))) {
                if (!p.hasPermission("quacksafety.staff")) {
                    if (!plot.getOwner().equals(e.getPlayer().getUniqueId()) || !plot.isAdded(e.getPlayer().getUniqueId()) || !plot.getTrusted().contains(e.getPlayer().getUniqueId())) {
                        e.setCancelled(true);
                        p.sendMessage(ChatColor.GOLD + "[QUACK] " + "the use of chorus fruit is only enabled on plots you can build on!");
                    }
                }
            }
        }
    }
}