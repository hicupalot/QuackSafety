package com.quacktopia.quacksaftey.bot;

import com.quacktopia.quacksaftey.QuackSaftey;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.util.ArrayList;

public class CommandManager extends ListenerAdapter {

    private final ArrayList<DiscordCommand> commands;
    private final Main main;
    static QuackSaftey plugin;

    public CommandManager(QuackSaftey instance, ArrayList<DiscordCommand> commands, ArrayList<DiscordCommand> commands1, Main main) {
        plugin = instance;
        this.commands = commands1;
        this.main = main;
    }
    public CommandManager(Main main) {

        this.main = main;
        this.commands = new ArrayList<>();

    }

    private void registerCommands() {
       commands.add(new AddFilteredWords(main));
       commands.add(new RemoveFilteredWords(main));
       commands.add(new DiscordToMinecraft(main));
        CommandListUpdateAction commandUpdateAction = Config.Discord.updateCommands();
        for (DiscordCommand discordCommand : commands) {
            commandUpdateAction.addCommands(discordCommand.buildCommand());
        }
        commandUpdateAction.queue();

    }
    @Override
    public void onSlashCommand(SlashCommandEvent event) {
        if (event.getGuild() == null || !event.getGuild().getId().equals(Config.QUACKTOPIA_SERVER) || !event.getGuild().getId().equals(Config.TESTING_SERVER)) {
            return;
        }

        DiscordCommand discordCommand = null;

        for (DiscordCommand dis : commands) {
            if (dis.getName().equalsIgnoreCase(event.getName())) {
                discordCommand = dis;
            }
        }

        if (discordCommand == null || event.getMember() == null) {
            return;
        }
        discordCommand.onCommand(event);

    }
}