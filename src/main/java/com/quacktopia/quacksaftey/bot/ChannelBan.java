package com.quacktopia.quacksaftey.bot;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.IPermissionHolder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChannelBan extends DiscordCommand{
    public ChannelBan(Main main) {
        super(main, "channelban", Config.plugin.getConfig().getString("quackhelper"));
    }
    @Override
    public void onCommand(SlashCommandEvent e) {
        if (e.getMember().getRoles().toString().contains(Config.SERVER_HELPER_ID) || e.getMember().getRoles().toString().contains(Config.DISCORD_HELPER_ID) || e.getMember().isOwner()) {
            Member BannedMember = e.getOption("User").getAsMember();
            if (BannedMember != null) { //ik this isn't nessisary but I want to make IntelliJ happy yk
                if (BannedMember.isOwner() || BannedMember.getRoles().toString().contains(Config.DISCORD_HELPER_ID) || BannedMember.getRoles().toString().contains(Config.SERVER_HELPER_ID)) {
                    e.reply("Excuse me!? You cannot ban a Staff Member!").setEphemeral(true).queue();
                    return;
                }
                e.getOption("Channel").getAsGuildChannel().upsertPermissionOverride(e.getOption("User").getAsMember()).setDeny(Permission.MESSAGE_READ).queue();
                e.reply("You banned "+ BannedMember.getAsMention()+ "from " + e.getOption("Channel").getAsGuildChannel()+ "for " + e.getOption("Reason")).setEphemeral(true).queue();
            }
        }
    }
    @Override
    public CommandData buildCommand () {
        return new CommandData("channelban", "Ban a user from a specific channel")
                .addOption(OptionType.CHANNEL, "Channel", "The Channel to ban the user from", true)
                .addOption(OptionType.USER,"User","The User to Ban",true)
                .addOption(OptionType.STRING,"Reason","The reason why they are banned",true);
    }
}

