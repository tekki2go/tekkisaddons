package org.concadium.tekkisaddons;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class tekkisaddons extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register event listeners
        Bukkit.getPluginManager().registerEvents(new BeeRideListener(), this);
        Bukkit.getPluginManager().registerEvents(new PufferfishEffectListener(), this);

        // Register commands
        getCommand("ridebee").setExecutor(new RideBeeCommand());

        getLogger().info("TekkisAddons enabled with bee-riding and pufferfish effects!");
    }

    @Override
    public void onDisable() {
        getLogger().info("TekkisAddons disabled!");
    }
}
