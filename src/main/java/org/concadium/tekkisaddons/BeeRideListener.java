package org.concadium.tekkisaddons;

import org.bukkit.entity.Bee;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class BeeRideListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        // Use the utility method to check if the player is holding a flower
        if (TekkisUtils.isHoldingFlower(player)) {
            Bee nearestBee = player.getWorld().getNearbyEntities(player.getLocation(), 5, 5, 5).stream()
                    .filter(entity -> entity.getType() == EntityType.BEE)
                    .map(entity -> (Bee) entity)
                    .findFirst()
                    .orElse(null);

            if (nearestBee != null) {
                nearestBee.addPassenger(player);
                player.sendMessage("You are now riding a bee!");
            } else {
                player.sendMessage("No bees are nearby to ride!");
            }
        }
    }
}
