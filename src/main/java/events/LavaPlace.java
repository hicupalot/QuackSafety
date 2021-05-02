package events;

import com.plotsquared.core.events.PlayerEnterPlotEvent;
import com.plotsquared.core.events.PlotPlayerEvent;
import com.plotsquared.core.plot.Plot;
import com.plotsquared.core.location.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.Objects;

public class LavaPlace implements Listener {
    @EventHandler
    @SuppressWarnings("deprecated")
    public void Lava(BlockPlaceEvent e){
        Location loc = null;
        assert false;
        loc.isPlotArea();
        Plot plot = Plot.getPlot(loc);
        plot.isAdded(e.getPlayer().getUniqueId());
        Player player = e.getPlayer();
        if (loc.isPlotArea() && !loc.isPlotRoad()) {
        if (e.getBlockPlaced().isLiquid() && !plot.getMembers().isEmpty() && !plot.getTrusted().isEmpty()){
            if (e.getPlayer().getUniqueId() == plot.getOwner()) {
                return;
            }
            Bukkit.broadcast(ChatColor.YELLOW + "[" + ChatColor.RED + "STAFF" + ChatColor.YELLOW + "]" + ChatColor.LIGHT_PURPLE + e.getPlayer().getName() + " is possibly griefing" +
                    " by placing " + e.getBlockPlaced() + "on a plot", "quacksafety.lavanotify");
        }
        }
    }
}
