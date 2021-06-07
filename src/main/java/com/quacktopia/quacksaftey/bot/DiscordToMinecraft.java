package com.quacktopia.quacksaftey.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class DiscordToMinecraft extends ListenerAdapter {
    static JDA MTD;

    public void Command(MessageReceivedEvent e) {
        if (!e.getChannel().getId().equals("812756243957284914") || !e.getChannel().getId().equals("817766659279945780")) {
            e.getMessage().delete().queue();
            return;
        }
        if (e.getAuthor().isBot() || e.isWebhookMessage()) {
            e.getMessage().delete().queue();
            return;
        }
        String[] args = e.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase("!reply")) {
            e.getMessage().delete().queue();
            if (e.getMember().getRoles().stream().filter(role -> role.getName().equalsIgnoreCase("Server Helper")).findAny().orElse(null) == null) {
                if (args.length < 2) {
                    e.getChannel().sendMessage("The format is !reply (username) (message)").queue();
                    return;
                }
            }
            String mcname = args[1];
            Player p = Bukkit.getServer().getPlayer(mcname);
            StringBuilder sb = new StringBuilder();

            for (int i = 2; i < args.length; i++) {

                sb.append(args[i] + " ");
                String helpmsg = sb.toString().trim();
                assert p != null;
                if (p.hasPermission("quacksafety.staffhelp")) {
                    p.sendMessage(ChatColor.RED + "[" + ChatColor.YELLOW + "STAFF" + ChatColor.RED + "]: " + ChatColor.LIGHT_PURPLE + "Help Recieved from " + e.getAuthor().getAsTag() + ": " + ChatColor.YELLOW + helpmsg);
                } else {
                    if (e.getChannel().getId().equals("812756243957284914") || e.getChannel().getId().equals("817766659279945780")) {
                        if (!p.hasPermission("quacksafety.staffhelp")) {
                            e.getMessage().delete().queue();
                            e.getChannel().sendMessage(e.getMember().getAsMention() + "** That Player Is NOT Staff**").queue();
                        }
                    }
                }
            }
        }
    }
}
