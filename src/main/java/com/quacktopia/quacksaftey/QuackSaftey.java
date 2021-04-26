package com.quacktopia.quacksaftey;

import com.quacktopia.quacksaftey.commands.*;
import com.quacktopia.quacksaftey.inhibitors.*;
import events.StaffJoin;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public final class QuackSaftey extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.GOLD + "[QuackSaftey] QuackSaftey plugin booting up on v" + getDescription().getAPIVersion());
        getCommand("didibreakit").setExecutor(new plugintest());
        getCommand("barrier").setExecutor(new barriergiver());
        getCommand("colourcodes").setExecutor(new colour());
        getCommand("discord").setExecutor(new discord());
        getCommand("feedback").setExecutor(new feedback());
        getCommand("playtime").setExecutor(new playtime());
        System.out.println(ChatColor.GOLD + "[QuackSafety] Commands Loaded");
        getServer().getPluginManager().registerEvents(new ProjectileInhibitor(), this);
        getServer().getPluginManager().registerEvents(new PrimedTNTBlocker(), this);
        getServer().getPluginManager().registerEvents(new bookban(), this);
        getServer().getPluginManager().registerEvents(new ArmorStandLimiter(), this);
        getServer().getPluginManager().registerEvents(new EventChecker(), this);
        getServer().getPluginManager().registerEvents(new LaggOmeter(), this);
        getServer().getPluginManager().registerEvents(new SpeedLimit(), this);
        getServer().getPluginManager().registerEvents(new commandprefix(), this);
        getServer().getPluginManager().registerEvents(new StaffJoin(), this);
        System.out.println(ChatColor.GOLD + "[QuackSafety] Inhibitors and Events loaded");
        System.out.println(ChatColor.GOLD + "[QuackSaftey] QuackSaftey v" + getDescription().getAPIVersion() + " By Authors" + getDescription().getAuthors());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.RED + "[QuackSaftey] QuackSaftey plugin shutting down");
    }
}
