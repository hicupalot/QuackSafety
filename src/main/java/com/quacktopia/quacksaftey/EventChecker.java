package com.quacktopia.quacksaftey;
import org.bukkit.event.*;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.entity.AreaEffectCloudApplyEvent;
import org.bukkit.event.entity.LingeringPotionSplashEvent;
import org.bukkit.event.player.PlayerRecipeDiscoverEvent;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.material.*;
import org.bukkit.block.*;
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
    }}


