package org.concadium.tekkisaddons;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;

public class tekkisaddons extends JavaPlugin implements Listener {

    private FileConfiguration config;

    @Override
    public void onEnable() {
        // Ensure the config file is created and loaded
        createDefaultConfig();
        config = getConfig();

        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("TekkisAddons enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("TekkisAddons disabled!");
    }

    private void createDefaultConfig() {
        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            if (!getDataFolder().mkdirs()) {
                getLogger().warning("Could not create the plugin data folder!");
            }
            saveResource("config.yml", false);
        }
    }

    @EventHandler
    public void onPlayerHitWithPufferfish(EntityDamageByEntityEvent event) {
        // Check if the feature is enabled in the config
        if (!config.getBoolean("features.pufferfish_effects", true)) {
            return;
        }

        // Check if the damager is a player
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            Player attacker = (Player) event.getDamager();
            Player victim = (Player) event.getEntity();

            // Check if the attacker is holding a pufferfish
            if (attacker.getInventory().getItemInMainHand().getType() == Material.PUFFERFISH) {
                // Apply effects to the victim
                applyPufferfishEffects(victim);
            }
        }
    }

    private void applyPufferfishEffects(Player player) {
        // These effects mimic those from eating a pufferfish
        player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 3)); // Poison III for 10 seconds
        player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 100, 2));  // Hunger II for 5 seconds
        player.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 300, 0));  // Nausea for 15 seconds
    }
}
