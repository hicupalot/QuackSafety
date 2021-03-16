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
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.RED + "[QuackSaftey] QuackSaftey plugin shutting down");
    }
}
