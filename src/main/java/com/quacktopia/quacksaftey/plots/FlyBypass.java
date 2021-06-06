package com.quacktopia.quacksaftey.plots;

import com.plotsquared.core.location.Location;
import com.plotsquared.core.plot.Plot;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;

public class FlyBypass implements Listener {
    //Bypass Fly Flag on Plots
    public void Fly(PlayerEvent e) {
        Location loc = null;
        assert false;
        loc.isPlotArea();
        Plot plot = Plot.getPlot(loc);
        plot.isAdded(e.getPlayer().getUniqueId());
        Player p = e.getPlayer();
        if (loc.isPlotArea() && !loc.isPlotRoad()) {
            if (p.hasPermission("quacksafety.staff"))
            if (!p.getAllowFlight()){
                p.setFlying(true);
            }
        }
    }
}
