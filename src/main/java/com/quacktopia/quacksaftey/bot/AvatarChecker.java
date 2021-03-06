package com.quacktopia.quacksaftey.bot;

import net.dv8tion.jda.api.events.user.update.UserUpdateAvatarEvent;

public class AvatarChecker {
    private final Main main;

    public AvatarChecker(Main main) {
        this.main = main;
        avatar();
    }

    private void avatar() {}
        public void AvatarChange (UserUpdateAvatarEvent e){
            if (!e.getNewAvatarId().equals(e.getOldAvatarUrl())) {
                assert (e.getNewAvatarUrl() != null);
                assert (e.getOldAvatarUrl() != null);
                Config.discord.getTextChannelById(Config.LOGGING_CHANNEL).sendMessage(e.getUser().getName() + " just changed their profile picture " + e.getNewAvatarUrl()).queue();
                Config.discord.getTextChannelById(Config.TESTING_STATUS_CHANNEL).sendMessage(e.getUser().getName() + " just changed their profile picture " + e.getNewAvatarUrl()).queue();
                Config.discord.getTextChannelById(Config.STAMPY_LOGGING_CHANNEL).sendMessage(e.getUser().getName() + " just changed their profile picture " + e.getNewAvatarUrl()).queue();
            }
        }
    }
