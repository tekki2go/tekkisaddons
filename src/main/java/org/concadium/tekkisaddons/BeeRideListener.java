package org.concadium.tekkisaddons;

import org.bukkit.entity.Bee;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class BeeRideListener implements Listener {

    private final tekkisaddons plugin;

    public BeeRideListener(tekkisaddons plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof Bee)) return;

        Player player = event.getPlayer();
        Bee bee = (Bee) event.getRightClicked();

        // Check if player has /ridebee on
        if (!player.hasMetadata("ridebee")) return;

        if (TekkisUtils.isHoldingFlower(player)) {
            event.setCancelled(true);
            bee.setMetadata("ridden", new FixedMetadataValue(plugin, true));
            bee.addPassenger(player);
        }
    }
}