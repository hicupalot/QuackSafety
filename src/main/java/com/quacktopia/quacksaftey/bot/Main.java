package com.quacktopia.quacksaftey.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main{
    @SuppressWarnings("unused")
    public static void main(String[] args) throws LoginException, InterruptedException {
        JDABuilder builder = JDABuilder.createLight(("token"));
        JDA jda;
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("Over Quacktopia"));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES);
        builder.build().awaitReady();
        builder.addEventListeners(new Main());
        builder.addEventListeners(new DiscordToMinecraft());
    }
}
