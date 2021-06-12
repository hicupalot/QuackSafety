package com.quacktopia.quacksaftey.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public class Main extends JavaPlugin {
    @SuppressWarnings("unused")
    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createLight(("token")).setStatus(OnlineStatus.ONLINE).setActivity(Activity.watching("Over Quacktopia"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES).addEventListeners(new Main())
                .addEventListeners(new DiscordToMinecraft()).addEventListeners(new NameChecker()).addEventListeners(new StatusChecker()).build().awaitReady();
        jda.upsertCommand("helpreply", "Reply to the Helper who requested help!").queue();
        if (jda.getGuildById(Config.QUACKTOPIA_SERVER) == null) {
            if (jda.getGuildById(Config.TESTING_SERVER) == null) {
                System.out.println("This is a private Bot! The Bot has shut down for safety reasons! If this is a mistake please contact an Admin");
                System.exit(1);
            }
        }
    }
}