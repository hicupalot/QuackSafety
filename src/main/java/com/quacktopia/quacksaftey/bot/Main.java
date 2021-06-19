package com.quacktopia.quacksaftey.bot;

import com.quacktopia.quacksaftey.QuackSaftey;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Main {
    private static Main main;
    private final CommandManager commandManager;
    public static void main(String[] args){
        try {
            main = new Main();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Bot failed to start!");
            System.exit(999);
        }
    }
    @SuppressWarnings("unused")
    public Main() throws Exception {
        JDA jda = JDABuilder.createDefault("ODI4OTI5Mjg0ODIzMTg3NTI2.YGwujg.x5WrHdA2m3jv7Im3wjotoivASmU").setStatus(OnlineStatus.ONLINE).setActivity(Activity.watching("Over Quacktopia"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES)
                .setMemberCachePolicy(MemberCachePolicy.ALL).enableCache(CacheFlag.ACTIVITY).build().awaitReady();
        jda.addEventListener(new StatusChecker());
        jda.addEventListener(new DiscordToMinecraft(main));
        jda.addEventListener(new NameChecker());
        jda.addEventListener(new AvatarChecker());
        this.commandManager = new CommandManager(this);
        jda.addEventListener(commandManager);
        if (jda.getGuildById(Config.QUACKTOPIA_SERVER) == null) {
            if (jda.getGuildById(Config.TESTING_SERVER) == null) {
                System.out.println("This is a private Bot! The Bot has shut down for safety reasons! If this is a mistake please contact an Admin");
                System.exit(39715);
            }
        }
    }
            public CommandManager getCommandManager() {
                return commandManager;
            }
        }