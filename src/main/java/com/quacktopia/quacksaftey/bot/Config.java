package com.quacktopia.quacksaftey.bot;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class Config extends JavaPlugin {
    //------------------------------------------------------------------------------------
    private final String token;
    private final List<String> filteredwords;
    public static final String ADMIN_CHANNEL_ID = "817766659279945780";
    public static final String SERVER_HELPER_CHANNEL_ID = "812756243957284914";
    public static final String DISCORD_HELPER_CHANNEL_ID = "758768271066923068";
    public static final String DISCORD_INAPPROPRIATE_CHECK = "Placeholder";
    public static final String LOGGING_CHANNEL = "310219769234325505";
    public static final String TESTING_SERVER = "325893724678782979";
    public static final String QUACKTOPIA_SERVER = "298176792492244992";
    public static final String TESTING_STATUS_CHANNEL = "853294626680078337";
    public static final String STAMPY_MOD_ID = "728201924763058206";
    public static final String DISCORD_HELPER_ID = "736635609665241098";
    public static final String SERVER_HELPER_ID = "298178020806492161";
    public static final String STAMPY_ADMIN_ID = "729410635011457086";
    public static final String QUACK_DISC_ADMIN_ID = "759818242726035466";
    public static final String QT_STAFF_COMMANDS_CHANNEL = "736633672949825591";
    public static final String STAMPY_COMMANDS_CHANNEL = "729413192673132686";
    public static JDA Discord;
//-------------------------------------------------------------------------------------
    public Config(String token, List<String> filteredwords) {
        this.filteredwords = filteredwords;
        this.token = token;
    }

    private static final Dotenv dotenv = Dotenv.load();

    public static String get(String key) {
        return dotenv.get(key.toUpperCase());
    }

    public String getToken() {
        return token;
    }

    public List<String> getAlertNames() {
        return filteredwords;
    }
}

