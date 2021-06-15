package com.quacktopia.quacksaftey.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.user.update.UserUpdateAvatarEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.command.CommandExecutor;

public class AvatarChecker extends ListenerAdapter {
    static JDA MTD;
    public void AvatarChange(UserUpdateAvatarEvent e){
        if (!e.getNewAvatarId().equals(e.getOldAvatarUrl())){
            assert (e.getNewAvatarUrl()!=null);
            assert (e.getOldAvatarUrl()!=null);
            MTD.getTextChannelById(Config.LOGGING_CHANNEL).sendMessage(e.getUser().getName()+" just changed their profile picture "+ e.getNewAvatarUrl()).queue();
        }
    }
}
