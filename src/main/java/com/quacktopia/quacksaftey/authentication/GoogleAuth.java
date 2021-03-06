package com.quacktopia.quacksaftey.authentication;

import com.quacktopia.quacksaftey.bot.Config;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.UUID;

public class GoogleAuth implements Listener {
    private ArrayList<UUID> authlocked;

    public void onEnable() {
        authlocked = new ArrayList<>();

        Config.plugin.getConfig().options().copyDefaults(true);
        Config.plugin.saveConfig();
    }

    @SuppressWarnings("unused")
    public ArrayList<UUID> getAuthlocked() {
        return authlocked;
    }

    @EventHandler
    public void Joining(PlayerJoinEvent e) {
        if (Config.plugin.getConfig().getBoolean("GoogleAuth"))
        if (!e.getPlayer().hasPermission("quacksafety.auth")) {
            authlocked.remove(e.getPlayer().getUniqueId());
            return;
        }
        if (e.getPlayer().hasPermission("quacksafety.auth")){
            Player player = e.getPlayer();
            if (!Config.plugin.getConfig().contains("authcodes." + player.getUniqueId())) {
                GoogleAuthenticator gAuth = new GoogleAuthenticator();
                GoogleAuthenticatorKey gkey = gAuth.createCredentials();
                player.sendMessage(ChatColor.GOLD + "Your Google Auth Code is " + gkey.getKey());
                player.sendMessage(ChatColor.BLUE + "Please enter this code in the Google Authenticator App BEFORE you leave the server");
                Config.plugin.getConfig().set("authcodes." + player.getUniqueId(), gkey.getKey());
                Config.plugin.saveConfig();
            } else {
                authlocked.add(player.getUniqueId());
                player.sendMessage(ChatColor.RED + "Please enter the code found in the Google Authenticator App!");
                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1000000, 255, true, false));
                player.setWalkSpeed(0);
                player.setFlySpeed(0);
            }

        }
    }

    private boolean playerInputCode(Player player, int code) {
        String secretkey = Config.plugin.getConfig().getString("authcodes." + player.getUniqueId());

        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        assert secretkey != null;
        boolean codeisvalid = gAuth.authorize(secretkey, code);


        if (codeisvalid) {
            authlocked.remove(player.getUniqueId());
            player.removePotionEffect(PotionEffectType.BLINDNESS);
            player.setFlySpeed(0.1f); //default flyspeed
            player.setWalkSpeed(0.2f); //default walkspeed
            return codeisvalid;
        }
        return codeisvalid;
    }

    @EventHandler
    @SuppressWarnings("deprecation")
    public void chat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        if (authlocked.contains(player.getUniqueId())) {
            try {
                int code = Integer.parseInt(message);
                if (playerInputCode(player, code)) {
                    authlocked.remove(player.getUniqueId());
                    player.sendMessage(ChatColor.GREEN + "Access Granted");
                } else {
                    player.sendMessage(ChatColor.RED + "That code was not correct.");

                }
            } catch (Exception e) {
                player.sendMessage(ChatColor.RED + "That code was not correct.");
            }
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void move(PlayerMoveEvent event) { //Stops people moving
        Player player = event.getPlayer();
        if (authlocked.contains(player.getUniqueId())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void blockbreak(BlockBreakEvent event) { //Stops people breaking blocks
        Player player = event.getPlayer();
        if (authlocked.contains(player.getUniqueId())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void blockplace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (authlocked.contains(player.getUniqueId())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void CommandBlock(PlayerCommandPreprocessEvent e) {
        if (authlocked.contains(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void Interact(PlayerInteractEvent e) {
        if (authlocked.contains(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    @SuppressWarnings("deprecation")
    public void RecieveChat(AsyncPlayerChatEvent e) {
        for (Player pl : e.getRecipients()) {
            if (authlocked.contains(pl.getUniqueId())) {
                e.getRecipients().remove(pl);
            }
        }
    }
    @EventHandler
    public void TP(PlayerTeleportEvent e){
        if (authlocked.contains(e.getPlayer().getUniqueId())){
            e.setCancelled(true);
        }
    }

        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
            if (sender.hasPermission("quacksafety.adminauth") && !authlocked.contains((((Player) sender).getUniqueId()))) {
                Player target = Bukkit.getServer().getPlayer(args[1]);
                assert target != null;
                if (target.hasPermission("quacksafety.auth")) {
                    Config.plugin.getConfig().set("authcodes." + target.getUniqueId(), null);
                    Config.plugin.saveConfig();
                    sender.sendMessage(ChatColor.GOLD + "You reset " + target.getName() + "'s authcode");
                    target.sendMessage(ChatColor.RED + "Please rejoin the server due to your authcode being reset!");
                    if (Config.discord.getTextChannelById(Config.ADMIN_CHANNEL_ID) != null) {
                        Config.discord.getTextChannelById(Config.ADMIN_CHANNEL_ID).sendMessage(target.getName() + "'s authcode was reset by " + sender.getName()).queue();

                    }
                }
            } else{
                return false;
            }
        }
            return false;
    }
}