package com.quacktopia.quacksaftey.bot;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

public abstract class DiscordCommand {
    protected final Main main;
    private final String name;
    private final String roleID;

    public DiscordCommand(Main main, String name, String roleID) {
        this.main = main;
        this.name = name;
        this.roleID = roleID;
        }
    public abstract void onCommand(SlashCommandEvent event);
    public abstract CommandData buildCommand();

    public String getName() {
        return name;
    }

    public String getRoleID() {
        return roleID;
    }

}
