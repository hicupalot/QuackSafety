package com.quacktopia.quacksaftey.bot;

import com.quacktopia.quacksaftey.QuackSaftey;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AddFilteredWords extends ListenerAdapter {
    static QuackSaftey plugin;

    public AddFilteredWords(QuackSaftey instance) {
        plugin = instance;
    }

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
            if (plugin.getConfig().getList("filteredwords").contains(word.toLowerCase())) {
                e.reply("This word is already filtered!").setEphemeral(true).queue();
                return;
            }
            plugin.getConfig().getStringList("filteredwords").add(word);
            e.reply("Added " + word + " to the filtered words checker!").setEphemeral(true).queue();
            plugin.saveConfig();
        }
    }
}
