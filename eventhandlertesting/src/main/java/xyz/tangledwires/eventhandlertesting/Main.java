package xyz.tangledwires.eventhandlertesting;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.tangledwires.eventhandlertesting.listeners.onDeathListener;
import xyz.tangledwires.eventhandlertesting.listeners.onPlayerJoinListener;
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Loaded EventHandlerTesting");
        getServer().getPluginManager().registerEvents(new onPlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new onDeathListener(), this);
        if (this.getConfig().getString("settings.join-message") == null) {
            this.getConfig().set("settings.join-message", "&c{player} is bad at Minecraft.");
        }
        if (this.getConfig().getString("settings.join-message-enabled") == null) {
            this.getConfig().set("settings.join-message-enabled", "true");
        }
    }
    @Override
    public void onDisable() {
        getLogger().info("Disabling EventHandlerTesting");
    }
    public FileConfiguration getPluginConfiguration() { return this.getConfig(); }
}