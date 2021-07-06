package com.quacktopia.quacksaftey.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Main {
    private static Main main;
    private final CommandManager commandManager;
    private final JDA jda;

    public static void main(String[] args) {
        try {
            main = new Main();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(999);
        }
    }

    @SuppressWarnings("unused")
    public Main() throws Exception {
        this.jda = JDABuilder.createDefault(Config.get("token")).setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.watching("Over Quacktopia"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES)
                .setMemberCachePolicy(MemberCachePolicy.ALL).enableCache(CacheFlag.ACTIVITY).build().awaitReady();
        this.commandManager = new CommandManager(this);
        jda.addEventListener(commandManager);
        new StatusChecker(this);
        new NameChecker(this);
        new AvatarChecker(this);
        }
    public CommandManager getCommandManager() {
        return commandManager;
    }

    public JDA getJda() {
        return jda;
    }
}