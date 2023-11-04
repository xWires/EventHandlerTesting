package xyz.tangledwires.eventhandlertesting.listeners;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import xyz.tangledwires.eventhandlertesting.Main;

public class onDeathListener implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        final FileConfiguration config = Main.getPlugin(null).getConfig();
          if (config.getString("settings.death-message-enabled") == "true") {
               final String deathMessage = ChatColor.translateAlternateColorCodes("&".charAt(0), config.getString("settings.death-message"));
               final String deathMessageFormatted = deathMessage.replace("{player}", event.getEntity().getName());
               event.setDeathMessage(deathMessageFormatted);
          }
    }
}
