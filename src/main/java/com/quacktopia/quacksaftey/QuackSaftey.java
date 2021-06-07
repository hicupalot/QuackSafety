package com.quacktopia.quacksaftey;

import com.quacktopia.quacksaftey.bot.MinecraftToDiscord;
import com.quacktopia.quacksaftey.authentication.GoogleAuth;
import com.quacktopia.quacksaftey.commands.*;
import com.quacktopia.quacksaftey.inhibitors.*;
import com.quacktopia.quacksaftey.plots.ChorusLimiter;
import com.quacktopia.quacksaftey.plots.LavaPlace;
import com.quacktopia.quacksaftey.plots.PlotPlayers;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

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
        getCommand("PlotPlayers").setExecutor(new PlotPlayers());
        getCommand("PermCheck").setExecutor(new QuackSafetyPermCheck());
        System.out.println(ChatColor.GOLD + "[QuackSafety] Commands Loaded");
        getServer().getPluginManager().registerEvents(new ProjectileInhibitor(), this);
        getServer().getPluginManager().registerEvents(new PrimedTNTBlocker(), this);
        getServer().getPluginManager().registerEvents(new BookBan(), this);
        getServer().getPluginManager().registerEvents(new ArmorStandLimiter(), this);
        getServer().getPluginManager().registerEvents(new EventChecker(), this);
        getServer().getPluginManager().registerEvents(new LaggOmeter(), this);
        getServer().getPluginManager().registerEvents(new SpeedLimit(), this);
        getServer().getPluginManager().registerEvents(new commandprefix(), this);
        getServer().getPluginManager().registerEvents(new LavaPlace(), this);
        getServer().getPluginManager().registerEvents(new ChorusLimiter(), this);
        getServer().getPluginManager().registerEvents(new OpStopper(), this);
        System.out.println(ChatColor.GOLD + "[QuackSafety] Inhibitors and Events loaded");
        System.out.println(ChatColor.GOLD + "[QuackSaftey] QuackSaftey v" + getDescription().getVersion() + " By Authors" + getDescription().getAuthors());
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "[QuackSaftey] QuackSaftey plugin shutting down");
    }
}
