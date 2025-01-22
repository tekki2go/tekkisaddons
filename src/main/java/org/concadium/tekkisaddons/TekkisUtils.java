package org.concadium.tekkisaddons;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.EnumSet;

public class TekkisUtils {
    // Define a set of valid flower materials
    private static final EnumSet<Material> FLOWERS = EnumSet.of(
            Material.DANDELION,
            Material.POPPY,
            Material.BLUE_ORCHID,
            Material.ALLIUM,
            Material.AZURE_BLUET,
            Material.RED_TULIP,
            Material.ORANGE_TULIP,
            Material.WHITE_TULIP,
            Material.PINK_TULIP,
            Material.OXEYE_DAISY,
            Material.CORNFLOWER,
            Material.LILY_OF_THE_VALLEY,
            Material.WITHER_ROSE
    );

    /**
     * Checks if a player is holding a flower in their main hand.
     *
     * @param player The player to check.
     * @return True if the player is holding a flower, false otherwise.
     */
    public static boolean isHoldingFlower(Player player) {
        Material itemInHand = player.getInventory().getItemInMainHand().getType();
        return FLOWERS.contains(itemInHand);
    }
}
