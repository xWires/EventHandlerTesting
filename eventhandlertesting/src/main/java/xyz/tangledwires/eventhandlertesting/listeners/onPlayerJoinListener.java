package xyz.tangledwires.eventhandlertesting.listeners;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import xyz.tangledwires.eventhandlertesting.Main;


public class onPlayerJoinListener implements Listener {
     @EventHandler
     public void onPlayerJoin(PlayerJoinEvent event) {
          final FileConfiguration config = Main.getPlugin(null).getConfig();
          if (config.getString("settings.join-message-enabled") == "true") {
               final String joinMessage = ChatColor.translateAlternateColorCodes("&".charAt(0), config.getString("settings.join-message"));
               final String joinMessageFormatted = joinMessage.replace("{player}", event.getPlayer().getName());
               event.setJoinMessage(joinMessageFormatted);
          }
     }
}