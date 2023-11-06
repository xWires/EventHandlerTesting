package xyz.tangledwires.eventhandlertesting;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.tangledwires.eventhandlertesting.listeners.onDeathListener;
import xyz.tangledwires.eventhandlertesting.listeners.onPlayerJoinListener;
public class EventHandlerTestingMain extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Loaded EventHandlerTesting");
        getServer().getPluginManager().registerEvents(new onPlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new onDeathListener(), this);
        if (this.getConfig().getString("settings.join-message") == null) {
            this.getConfig().set("settings.join-message", "&eWelcome {player} back to the server!");
            this.saveConfig();
        }
        if (this.getConfig().getString("settings.join-message-enabled") == null) {
            this.getConfig().set("settings.join-message-enabled", "true");
            this.saveConfig();
        }
        if (this.getConfig().getString("settings.death-message") == null) {
            this.getConfig().set("settings.death-message", "&c{player} is bad at Minecraft!");
            this.saveConfig();
        }
        if (this.getConfig().getString("settings.death-message-enabled") == null) {
            this.getConfig().set("settings.death-message-enabled", "true");
            this.saveConfig();
        }
    }
    @Override
    public void onDisable() {
        getLogger().info("Disabling EventHandlerTesting");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("eventhandlertesting")) {
            if (args.length == 0) {
                return false;
            }
            else if (args[0].equalsIgnoreCase("reload")) {
                this.reloadConfig();
                sender.sendMessage("Reloaded Config!");
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public FileConfiguration getPluginConfiguration() { return this.getConfig(); }
}