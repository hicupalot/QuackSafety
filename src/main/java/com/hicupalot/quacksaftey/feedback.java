package com.hicupalot.quacksaftey;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class feedback implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("quacksaftey.feedback")) {
            sender.sendMessage(ChatColor.GOLD +"[Quack] If you have any feedback/bugs/suggestions" +
                    "about the server please put them here https://app.feedbacky.net/b/quack");
        }
        else {
            sender.sendMessage(ChatColor.GOLD +"[QUACK]"+ ChatColor.RED+"You do not have permission to run that command");
        }
        return true;

    }

}
