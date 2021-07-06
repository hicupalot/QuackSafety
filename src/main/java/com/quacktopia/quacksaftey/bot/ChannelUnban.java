package com.quacktopia.quacksaftey.bot;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

public class ChannelUnban extends DiscordCommand{
    public ChannelUnban(Main main) {
        super(main, "channelunban", Config.plugin.getConfig().getString("quackhelper"));
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
                e.getOption("Channel").getAsGuildChannel().upsertPermissionOverride(e.getOption("User").getAsMember()).reset().queue();
                e.reply("You unbanned "+ BannedMember.getAsMention()+ "from " + e.getOption("Channel").getAsGuildChannel()).setEphemeral(true).queue();
            }
        }
    }
    @Override
    public CommandData buildCommand () {
        return new CommandData("channelunban", "Unbans a user from a specific channel")
                .addOption(OptionType.CHANNEL, "Channel", "The Channel to unban the user from", true)
                .addOption(OptionType.USER,"User","The User to unban",true);
    }
}

