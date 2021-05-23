package com.quacktopia.quacksaftey;

import com.quacktopia.quacksaftey.Bot.MinecraftToDiscord;
import com.quacktopia.quacksaftey.commands.*;
import com.quacktopia.quacksaftey.inhibitors.*;
import events.LavaPlace;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class QuackSaftey extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getConfig().get("token");
        System.out.println(ChatColor.GOLD + "[QuackSaftey] QuackSaftey plugin booting up on v" + getDescription().getAPIVersion());
        getCommand("didibreakit").setExecutor(new plugintest());
        getCommand("barrier").setExecutor(new barriergiver());
        getCommand("colourcodes").setExecutor(new colour());
        getCommand("discord").setExecutor(new discord());
        getCommand("feedback").setExecutor(new feedback());
        getCommand("playtime").setExecutor(new playtime());
        getCommand("serverinfo").setExecutor(new ServerInfo());
        getCommand("magic").setExecutor(new Magic());
        getCommand("staffhelp").setExecutor(new MinecraftToDiscord());
        System.out.println(ChatColor.GOLD + "[QuackSafety] Commands Loaded");
        getServer().getPluginManager().registerEvents(new ProjectileInhibitor(), this);
        getServer().getPluginManager().registerEvents(new PrimedTNTBlocker(), this);
        getServer().getPluginManager().registerEvents(new bookban(), this);
        getServer().getPluginManager().registerEvents(new ArmorStandLimiter(), this);
        getServer().getPluginManager().registerEvents(new EventChecker(), this);
        getServer().getPluginManager().registerEvents(new LaggOmeter(), this);
        getServer().getPluginManager().registerEvents(new SpeedLimit(), this);
        getServer().getPluginManager().registerEvents(new commandprefix(), this);
        getServer().getPluginManager().registerEvents(new LavaPlace(), this);
        System.out.println(ChatColor.GOLD + "[QuackSafety] Inhibitors and Events loaded");
        System.out.println(ChatColor.GOLD + "[QuackSaftey] QuackSaftey v" + getDescription().getAPIVersion() + " By Authors" + getDescription().getAuthors());
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "[QuackSaftey] QuackSaftey plugin shutting down");
    }
}
