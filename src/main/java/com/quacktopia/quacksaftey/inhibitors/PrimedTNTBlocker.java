package com.quacktopia.quacksaftey.inhibitors;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class PrimedTNTBlocker implements Listener{

    @EventHandler
    public void primedTNTStop(EntitySpawnEvent e) {
        if(e.getEntityType() == EntityType.PRIMED_TNT)
        e.setCancelled(true);
        //Stops Primed TNT
    }
}
