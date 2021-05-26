package com.quacktopia.quacksaftey.commands;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class commandprefix implements Listener {
    @EventHandler
    public void denyall(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/denyall")) {
            e.setCancelled(true);
            e.getPlayer().performCommand("p deny *");
            e.getPlayer().sendMessage(ChatColor.BLUE+ "You have successfully denied everyone from your pond");
        }
    }

    @EventHandler
    public void allowall(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/allowall")) {
            e.setCancelled(true);
            e.getPlayer().performCommand("p remove *");
            e.getPlayer().sendMessage( ChatColor.BLUE+ "You have successfully allowed everyone back into your pond, this may remove" +
                    " everyone from your pond so you will have to re-add them");
        }
    }

    @EventHandler
    public void plotday(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/plotday")) {
            e.setCancelled(true);
            e.getPlayer().performCommand("p flag set time 0");
            e.getPlayer().sendMessage(ChatColor.BLUE+ "have successfully set the plot to daytime");
        }
    }

    @EventHandler
    public void plotnight(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/plotnight")) {
            e.setCancelled(true);
            e.getPlayer().performCommand("p flag set time 18000");
            e.getPlayer().sendMessage(ChatColor.BLUE+ "You have successfully set the plot to nighttime");
        }
    }

    @EventHandler
    public void sunset(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/plotsunset")) {
            e.setCancelled(true);
            e.getPlayer().performCommand("p flag set time 12750");
            e.getPlayer().sendMessage(ChatColor.BLUE+"You have successfully set the plot to sunset");
        }
    }

    @EventHandler
    public void sunrise(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/plotsunrise")) {
            e.setCancelled(true);
            e.getPlayer().performCommand("p flag set time 23000");
            e.getPlayer().sendMessage(ChatColor.BLUE+"You have successfully set the plot to sunrise");
        }
    }

    @EventHandler
    public void rain(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/plotrain")) {
            e.setCancelled(true);
            e.getPlayer().performCommand("p flag set rain");
            e.getPlayer().sendMessage(ChatColor.BLUE+"You have successfully made your plot rain");
        }
    }

    @EventHandler
    public void sun(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/plotsun")) {
            e.setCancelled(true);
            e.getPlayer().performCommand("p flag set weather clear");
            e.getPlayer().sendMessage(ChatColor.BLUE+ "You have successfully made your plot sunny");
        }
    }
    @EventHandler
    public void snow(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/plotsnow")) {
            e.setCancelled(true);
            e.getPlayer().performCommand("p flag set weather rain");
            e.getPlayer().performCommand("p setbiome snowy_taiga");
            e.getPlayer().sendMessage(ChatColor.BLUE+ "You have successfully made your plot snowy");
        }
    }
}