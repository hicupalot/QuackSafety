package com.quacktopia.quacksaftey.bot;

import io.github.cdimascio.dotenv.Dotenv;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class Config extends JavaPlugin {
    private final String token;
    private final String filterchannel;
    private final List<String> alertnames;
    private final List<String> badstatus;

    public Config(String token, String filterchannel, List<String> alertnames, List<String> badstatus) {
        this.alertnames = alertnames;
        this.token = token;
        this.badstatus = badstatus;
        this.filterchannel = filterchannel;
    }
    private static final Dotenv dotenv = Dotenv.load();
    public static String get(String key) {
        return dotenv.get(key.toUpperCase());
    }
    public String getToken() {
        return token;
    }
    public List<String> getAlertNames() {
        return alertnames;
    }
    public String getFilterchannel(){
        return filterchannel;
    }
    public List<String> getBadstatus(){
        return badstatus;
    }

    public void addFilterName(String word) {
        this.alertnames.add(word.toLowerCase());
        this.saveConfig();
    }
    public void addFilterStatus(String word){
        this.badstatus.add(word.toLowerCase());
        this.saveConfig();
    }
}

