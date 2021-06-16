package com.quacktopia.quacksaftey.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.user.update.UserUpdateAvatarEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
public class AvatarChecker extends ListenerAdapter {
    public void AvatarChange(UserUpdateAvatarEvent e){
        if (!e.getNewAvatarId().equals(e.getOldAvatarUrl())){
            assert (e.getNewAvatarUrl()!=null);
            assert (e.getOldAvatarUrl()!=null);
            Config.Discord.getTextChannelById(Config.LOGGING_CHANNEL).sendMessage(e.getUser().getName()+" just changed their profile picture "+ e.getNewAvatarUrl()).queue();
            Config.Discord.getTextChannelById(Config.TESTING_STATUS_CHANNEL).sendMessage(e.getUser().getName()+" just changed their profile picture "+ e.getNewAvatarUrl()).queue();
            Config.Discord.getTextChannelById(Config.STAMPY_LOGGING_CHANNEL).sendMessage(e.getUser().getName()+" just changed their profile picture "+ e.getNewAvatarUrl()).queue();
        }
    }
}
