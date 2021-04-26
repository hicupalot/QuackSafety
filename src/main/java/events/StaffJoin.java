package events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class StaffJoin implements Listener {
    @EventHandler
    public void StaffJoinNotifier(PlayerJoinEvent e){
        if (e.getPlayer().hasPermission("quacksafety.staff")){
            Bukkit.broadcast(ChatColor.AQUA + "[" + ChatColor.RED + "STAFF" + ChatColor.AQUA + "]" + ChatColor.LIGHT_PURPLE + e.getPlayer().getName() + " joined Quacktopia on  " + e.getPlayer().getServer().getName()
                   , "quacksafety.staff");

        }
    }
}
