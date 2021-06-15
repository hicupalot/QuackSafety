package com.quacktopia.quacksaftey.events;

import com.quacktopia.quacksaftey.bot.Config;
import net.dv8tion.jda.api.JDA;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

@SuppressWarnings("unused")
public class OperatorListChange implements Listener {
    @SuppressWarnings("deprecation")
    public void Player(AsyncPlayerChatEvent e){
        if (!Bukkit.getOperators().isEmpty()){
            if (!e.getPlayer().getUniqueId().toString().equals("89ac0297-0e1e-4747-9aca-221a3d0c89c4")|| !e.getPlayer().getUniqueId().toString().equals("6fbf3ed5-ffb9-4229-ab76-714d9d9f5758") || !e.getPlayer().getUniqueId().toString().equals("48a52b7d-27ac-47a5-af33-2bfcebb00688") || !e.getPlayer().getUniqueId().toString().equals("2fcb88c2-fe15-43d5-8463-f404e4eace21") || !e.getPlayer().getUniqueId().toString().equals("59c99efa-7117-4005-9329-0f209e1abfc5")){
                if (Bukkit.getOperators().contains(e.getPlayer())){
                     Config.Discord.getTextChannelById(Config.ADMIN_CHANNEL_ID).sendMessage(e.getPlayer()+" is operator please ensure this isn't a mistake or that player hasn't force opped! (They have been forcibly deoped!").queue();
                     e.getPlayer().setOp(false);
                 }
                }
            }
        }
    }

