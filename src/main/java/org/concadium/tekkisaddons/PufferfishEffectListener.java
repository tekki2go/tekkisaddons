package org.concadium.tekkisaddons;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PufferfishEffectListener implements Listener {

    @EventHandler
    public void onPlayerHitWithPufferfish(EntityDamageByEntityEvent event) {
        // Check if the damager and victim are both players
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
