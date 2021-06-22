package com.quacktopia.quacksaftey.bot;

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StatusChecker {
    private static Main main;
    private final HashMap<String, String> StatusCache;

    public StatusChecker(Main main) {
            this.main = main;
            this.StatusCache = new HashMap<>();
            StatusCheck();
    }

    private void StatusCheck() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(() -> {
            for (Member member : Config.discord.getGuildById(Config.QUACKTOPIA_SERVER).getMembers()) {
                for (Activity status : member.getActivities()) {
                    if (status.getType() == Activity.ActivityType.CUSTOM_STATUS) {
                        String Status = status.getName();
                        List<String> bannedwords = (List<String>) Config.plugin.getConfig().getList("filteredwords");
                        if (StatusCache.containsKey(member.getId()) && StatusCache.get(member.getId()).equals(status)) {
                            return;
                        }
                        for (String s : Status.split(" ")) {
                            assert bannedwords!=null;
                            if (bannedwords.contains(s.toLowerCase())) {
                                Config.discord.getTextChannelById(Config.DISCORD_INAPPROPRIATE_CHECK).sendMessage(member.getEffectiveName() + " may have an inappropriate status:" + Status + " their discord id is " + member.getId());
                                Config.discord.getTextChannelById(Config.TESTING_STATUS_CHANNEL).sendMessage(member.getEffectiveName() + " may have an inappropriate status:" + Status + " their discord id is " + member.getId());
                                Config.discord.getTextChannelById(Config.STAMPY_LOGGING_CHANNEL).sendMessage(member.getEffectiveName() + " may have an inappropriate status:" + Status + " their discord id is " + member.getId());
                                StatusCache.put(member.getId(), Status);
                            }
                        }
                    }
                }
            }
        }, 10, 30, TimeUnit.SECONDS);
    }
}


