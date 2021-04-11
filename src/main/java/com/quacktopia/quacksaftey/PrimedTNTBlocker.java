package com.quacktopia.quacksaftey;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class PrimedTNTBlocker implements Listener{
    @EventHandler
    public void primedTNTStop(EntitySpawnEvent event)
    {
        if(event.getEntityType() == EntityType.PRIMED_TNT)
            event.setCancelled(true);
        //Stops Primed TNT
    }
}
