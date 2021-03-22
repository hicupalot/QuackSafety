package com.hicupalot.quacksaftey;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

public final class QuackSaftey extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.GOLD + "[QuackSaftey] QuackSaftey plugin initiated");
        this.getCommand("didibreakit").setExecutor(new plugintest());
        this.getCommand("barrier").setExecutor(new barriergiver());
        this.getCommand("colourcodes").setExecutor(new colour());
        this.getCommand("discord").setExecutor(new discord());
        this.getCommand("feedback").setExecutor(new feedback());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.RED + "[QuackSaftey] QuackSaftey plugin shutting down");
    }
}
