package com.quacktopia.quacksaftey.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class colour implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("quacksafety.colour")) {
                ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
                BookMeta meta = (BookMeta) book.getItemMeta();
                meta.setTitle("Colour Book");
                meta.setAuthor(ChatColor.YELLOW + "Quacktopia");
                meta.addPage(
                        ChatColor.WHITE + " The colour code for black is &0 \n" +
                                ChatColor.DARK_BLUE + " The colour code for dark blue is &1!\n" +
                                ChatColor.DARK_GREEN + " The colour code for dark green is &2\n" +
                                ChatColor.DARK_AQUA + " The colour code for aqua is &3\n" +
                                ChatColor.DARK_RED + " The colour code for dark red is &4\n" +
                                ChatColor.DARK_PURPLE + " The colour code for dark purple is &5\n" +
                                ChatColor.GOLD + " The colour code for gold is &6\n" +
                                ChatColor.GRAY + " The colour code for light grey is &7\n" +
                                ChatColor.DARK_GRAY + " The colour code for dark grey is &8\n" +
                                ChatColor.BLUE + " The colour code for blue is &9\n" +
                                ChatColor.GREEN + " The colour code for light green is &a\n" +
                                ChatColor.AQUA + " The colour code for light blue is &b\n" +
                                ChatColor.RED + " The colour code for red is &c\n" +
                                ChatColor.LIGHT_PURPLE + " The colour code for pink is &d\n" +
                                ChatColor.YELLOW + " The colour code for yellow is &e\n" +
                                ChatColor.WHITE + " The colour code for magic is &k\n" +
                                ChatColor.BOLD + " The colour code for bold is &l\n" +
                                ChatColor.STRIKETHROUGH + " The colour code for strikethrough is &m\n" +
                                ChatColor.ITALIC + " The colour code for italics is &o\n" +
                                ChatColor.UNDERLINE + " The colour code for underline is &n\n" +
                                ChatColor.WHITE + " The colour code for white is &f");
                book.setItemMeta(meta);
                sender.getServer().getPlayer(String.valueOf(sender)).getInventory().addItem(book);
            } else {
                sender.sendMessage(ChatColor.GOLD + "[QUACK]" + ChatColor.RED + " You do not have permission to run that command");
            }
            return false;

        }
    return false;
    }
}

