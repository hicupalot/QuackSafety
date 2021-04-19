package com.quacktopia.quacksaftey;

import com.quacktopia.quacksaftey.commands.*;
import com.quacktopia.quacksaftey.inhibitors.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuackSaftey extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.GOLD + "[QuackSaftey] QuackSaftey plugin booting up");
        getCommand("didibreakit").setExecutor(new plugintest());
        getCommand("barrier").setExecutor(new barriergiver());
        getCommand("colourcodes").setExecutor(new colour());
        getCommand("discord").setExecutor(new discord());
        getCommand("feedback").setExecutor(new feedback());
        getCommand("playtime").setExecutor(new playtime());
        System.out.println(ChatColor.GOLD+"[QuackSafety] Commands Loaded");
        getServer().getPluginManager().registerEvents(new ProjectileInhibitor(), this);
        getServer().getPluginManager().registerEvents(new PrimedTNTBlocker(), this);
        getServer().getPluginManager().registerEvents(new bookban(), this);
        getServer().getPluginManager().registerEvents(new NBTBanner(), this);
        getServer().getPluginManager().registerEvents(new ArmorStandLimiter(), this);
        getServer().getPluginManager().registerEvents(new EventChecker(), this);
        getServer().getPluginManager().registerEvents(new LaggOmeter(), this);
        getServer().getPluginManager().registerEvents(new SpeedLimit(), this);
        System.out.println(ChatColor.GOLD+"[QuackSafety] Inhibitors and Events loaded");
        System.out.println(ChatColor.GOLD + "[QuackSaftey] QuackSaftey plugin loaded");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.RED + "[QuackSaftey] QuackSaftey plugin shutting down");
    }
}
