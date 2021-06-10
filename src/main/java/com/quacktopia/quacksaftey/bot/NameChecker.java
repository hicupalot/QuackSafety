package com.quacktopia.quacksaftey.bot;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateNameEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class NameChecker extends JavaPlugin {
    public void Name(GuildMemberJoinEvent e) {
        String Name = e.getMember().getEffectiveName().toLowerCase();
    }
}

