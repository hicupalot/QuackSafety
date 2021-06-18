package com.quacktopia.quacksaftey.bot;

import com.quacktopia.quacksaftey.QuackSaftey;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

public class RemoveFilteredWords extends DiscordCommand {
    public RemoveFilteredWords(Main main) {
        super(main, "removealertword",Config.plugin.getConfig().getString("adminrole"));
    }
@Override
    public void onCommand(SlashCommandEvent e) {
    if (e.getMember() == null) {
        e.reply("Please check the code! SlashCommand recieved but user didn't send the command!?").setEphemeral(true).queue();
        return;
    }
    if (e.getMember().getUser().isBot()) {
        e.reply("Bot's cannot execute this command for safety reasons!").setEphemeral(true).queue();
        return;
    }
    if (!e.getChannel().getId().equals(Config.STAMPY_COMMANDS_CHANNEL) || !e.getChannel().getId().equals(Config.QT_STAFF_COMMANDS_CHANNEL)) {
        e.reply("You have to execute this command in the commands channel!").setEphemeral(true).queue();
        return;
    }
    if (e.getMember().getRoles().toString().contains(Config.DISCORD_HELPER_ID) || e.getMember().getRoles().toString().contains(Config.STAMPY_MOD_ID)
            || e.getMember().getRoles().toString().contains(Config.STAMPY_ADMIN_ID) || e.getMember().getRoles().toString().contains(Config.SERVER_HELPER_ID)
            || e.getMember().isOwner() || e.getMember().getRoles().toString().contains(Config.QUACK_DISC_ADMIN_ID)) {
        String word = e.getOption("word").getAsString();
        if (!Config.plugin.getConfig().getList("filteredwords").contains(word.toLowerCase())) {
            e.reply("This word isn't in the filter anyway!").setEphemeral(true).queue();
            return;
        }
        Config.plugin.getConfig().getStringList("filteredwords").remove(word);
        e.reply("Removed " + word + " from the filter!").setEphemeral(true).queue();
        Config.plugin.saveConfig();
    }
}
        @Override
        public CommandData buildCommand(){
            return new CommandData("removealertword", "Removes a word from the status alert")
                    .addOption(OptionType.STRING, "word", "Word to be removed.", true);
        }
    }

