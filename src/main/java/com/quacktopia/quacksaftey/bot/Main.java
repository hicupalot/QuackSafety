package com.quacktopia.quacksaftey.bot;

import com.quacktopia.quacksaftey.QuackSaftey;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
    private static Main main;
    private final CommandManager commandManager;

    public static void main(String[] args) {
        try {
            main = new Main();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Bot failed to start!");
            System.exit(1);
        }
    }

    public static QuackSaftey plugin;

    public Main(CommandManager commandManager, CommandManager commandManager1, QuackSaftey instance) {
        this.commandManager = new CommandManager(this);
        plugin = instance;
    }

    @SuppressWarnings("unused")
    public Main() throws Exception {
        String token = plugin.getConfig().getString("token");
        JDA jda = JDABuilder.createLight(token).setStatus(OnlineStatus.ONLINE).setActivity(Activity.watching("Over Quacktopia"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES).build().awaitReady();
        jda.addEventListener(new StatusChecker());
        jda.addEventListener(new DiscordToMinecraft());
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