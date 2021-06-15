package com.quacktopia.quacksaftey.bot;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateNameEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class NameChecker extends JavaPlugin {
    private String matchBannedWords(String texttocheck) {
        String name = texttocheck.toLowerCase();
        List<String> bannedwords = (List<String>) this.getConfig().getList("filteredwords");
        assert bannedwords != null;
        for (String s : bannedwords) {
            if (name.contains(s.toLowerCase())) {
                return s;
            }
        }
        return null;
    }
@SuppressWarnings("unused")
    public void name(GuildMemberJoinEvent e) {
        String name = e.getMember().getEffectiveName().toLowerCase();
        String match = matchBannedWords(name);
        if (match != null) {
            Config.Discord.getTextChannelById(Config.DISCORD_INAPPROPRIATE_CHECK).sendMessage(name + " is possibly inappropriate. CONTAINS: " + match + " their discord id is" + e.getMember().getId()).queue();
            Config.Discord.getTextChannelById(Config.TESTING_STATUS_CHANNEL).sendMessage(name + " is possibly inappropriate. CONTAINS: " + match + " their discord id is" + e.getMember().getId()).queue();
        }
    }
@SuppressWarnings("unused")
    public void onlineNameCheck(GuildMemberUpdateNicknameEvent e) {
        if (e.getMember().getNickname()==null) {
            return;
        }
        String name = e.getNewNickname().toLowerCase();
        String match = matchBannedWords(name);
        if (match != null) {
            Config.Discord.getTextChannelById(Config.DISCORD_INAPPROPRIATE_CHECK).sendMessage(e.getMember().getEffectiveName() + "'s nickname is " + name + " this is possibly inappropriate CONTAINS: " + match + " their discord id is " + e.getMember().getId()).queue();
            Config.Discord.getTextChannelById(Config.TESTING_STATUS_CHANNEL).sendMessage(e.getMember().getEffectiveName() + "'s nickname is " + name + " this is possibly inappropriate CONTAINS: " + match + " their discord id is " + e.getMember().getId()).queue();
        }
    }
@SuppressWarnings("unused")
    public void realNameChange(UserUpdateNameEvent e) {
        String name = e.getNewName().toLowerCase();
        String match = matchBannedWords(name);
        if (match != null) {
            Config.Discord.getTextChannelById(Config.DISCORD_INAPPROPRIATE_CHECK).sendMessage(e.getNewName() + " is possibly inappropriate CONTAINS: " + match + " their discord id is " + e.getUser().getId()).queue();
            Config.Discord.getTextChannelById(Config.TESTING_STATUS_CHANNEL).sendMessage(e.getNewName() + " is possibly inappropriate CONTAINS: " + match + " their discord id is " + e.getUser().getId()).queue();
        }
    }
}