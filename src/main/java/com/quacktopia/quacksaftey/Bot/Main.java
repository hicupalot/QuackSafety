package com.quacktopia.quacksaftey.Bot;

import com.quacktopia.quacksaftey.QuackSaftey;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;
import java.util.Objects;

public class Main{
    public static void main(String[] args) throws LoginException, InterruptedException {
        JDABuilder builder = JDABuilder.createLight(Config.get("token"));
        JDA jda;
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("Over Quacktopia"));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES);
        builder.build().awaitReady();
        builder.addEventListeners(new Main());
        builder.addEventListeners(new DiscordToMinecraft());
    }
}
