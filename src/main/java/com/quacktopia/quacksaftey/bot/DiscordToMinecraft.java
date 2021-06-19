package com.quacktopia.quacksaftey.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class DiscordToMinecraft extends DiscordCommand {
    public DiscordToMinecraft(Main main) {
        super(main, "helperhelp", Config.plugin.getConfig().getString("quackhelper"));
    }
    @Override
    public void onCommand(SlashCommandEvent e) {
        String mcname= e.getOption("Username").getAsString().toLowerCase();
        Player p = Bukkit.getServer().getPlayer(mcname);
        if (e.getMember().getRoles().toString().contains(Config.SERVER_HELPER_ID)) {
            assert p != null;
            if (p.hasPermission("quacksafety.staffhelp")) {
                p.sendMessage(ChatColor.RED + "[" + ChatColor.YELLOW + "STAFF" + ChatColor.RED + "]: " + ChatColor.LIGHT_PURPLE + "Help Recieved from " + e.getMember().getEffectiveName() + ": " + ChatColor.YELLOW + e.getOption("Message").getAsString());
            } else {
                    if (!p.hasPermission("quacksafety.staffhelp")) {
                        e.reply("**THAT USER ISNT STAFF**").setEphemeral(true).queue();
                    }
                }
        }
                }
                    @Override
                    public CommandData buildCommand () {
                        return new CommandData("helperhelp", "Reply to a Helper who needs help")
                                .addOption(OptionType.STRING, "Username", "The Helper who Needs Help", true)
                                .addOption(OptionType.STRING,"Message","The messgae reply to send to the helper who needs help",true);
                    }
                }
