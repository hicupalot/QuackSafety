package com.quacktopia.quacksaftey.inhibitors;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.entity.AreaEffectCloudApplyEvent;
import org.bukkit.event.entity.LingeringPotionSplashEvent;
import org.bukkit.event.player.PlayerRecipeDiscoverEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.event.world.StructureGrowEvent;

public class EventChecker implements Listener {
    @EventHandler
    public void onBlockDispense(BlockDispenseEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void onLingering(LingeringPotionSplashEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void onTreeGrow(StructureGrowEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void magicpreventer(AreaEffectCloudApplyEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void RecipeCleaner(PlayerRecipeDiscoverEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void PistonOut(BlockPistonExtendEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void PistonIn(BlockPistonRetractEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void NetherPortal(PortalCreateEvent e){
        e.setCancelled(true);
    }
}

