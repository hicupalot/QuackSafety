package com.quacktopia.quacksaftey.plots;

import com.plotsquared.core.location.Location;
import com.plotsquared.core.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class PlotPlayers implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender){
            sender.sendMessage(ChatColor.GOLD + " You can't are console, you are simultaneously nowhere and everywhere!");
        return false;
    }
        Location loc = null;
        assert false;
        loc.isPlotArea();
        Plot plot = Plot.getPlot(loc);
        if (sender.hasPermission("quacksafety.staff")) {
        if (!loc.isPlotArea()|| loc.isPlotRoad()){
                sender.sendMessage(ChatColor.RED + "You can't perform this command on the road!");
                return false;
            }
        if (sender instanceof Player){
            sender.sendMessage(ChatColor.GOLD+"[QUACK] "+ "players in the plot: "+ plot.getPlayersInPlot());
            }
            else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
                return false;
            }
            }
        return false;
    }
}
