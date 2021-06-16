package com.quacktopia.quacksaftey.bot;

import com.quacktopia.quacksaftey.QuackSaftey;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StatusChecker {
    public static QuackSaftey plugin;
    public StatusChecker(QuackSaftey instance) {
        plugin = instance;
    }
    private final HashMap<String, String> StatusCache = new HashMap<String, String>();

    public StatusChecker() {

    }

    private void StatusCheck() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(() -> {
            for (Member member : Config.Discord.getGuildById(Config.QUACKTOPIA_SERVER).getMembers()) {
                for (Activity status : member.getActivities()) {
                    if (status.getType() == Activity.ActivityType.CUSTOM_STATUS) {
                        String Status = status.getName();
                        List<String> bannedwords = (List<String>) plugin.getConfig().getList("filteredwords");
                        if (StatusCache.containsKey(member.getId()) && StatusCache.get(member.getId()).equals(status)) {
                            return;
                        }
                        for (String s : Status.split(" ")) {
                            assert bannedwords!=null;
                            if (bannedwords.contains(s.toLowerCase())) {
                                Config.Discord.getTextChannelById(Config.DISCORD_INAPPROPRIATE_CHECK).sendMessage(member.getEffectiveName() + " may have an inappropriate status:" + Status + " their discord id is " + member.getId());
                                Config.Discord.getTextChannelById(Config.TESTING_STATUS_CHANNEL).sendMessage(member.getEffectiveName() + " may have an inappropriate status:" + Status + " their discord id is " + member.getId());
                                Config.Discord.getTextChannelById(Config.STAMPY_LOGGING_CHANNEL).sendMessage(member.getEffectiveName() + " may have an inappropriate status:" + Status + " their discord id is " + member.getId());
                                StatusCache.put(member.getId(), Status);
                            }
                        }
                    }
                }
            }
        }, 10, 30, TimeUnit.SECONDS);
    }
}


