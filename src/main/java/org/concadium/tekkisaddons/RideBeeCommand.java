package org.concadium.tekkisaddons;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Bee;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class RideBeeCommand implements CommandExecutor {

    private final tekkisaddons plugin;

    public RideBeeCommand(tekkisaddons plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length < 1) {
            player.sendMessage("Usage: /ridebee [on|off|summon]");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "on":
                player.setMetadata("ridebee", new FixedMetadataValue(plugin, true));
                player.sendMessage("Bee riding enabled! Right-click a bee with a flower to ride it.");
                break;
            case "off":
                player.removeMetadata("ridebee", plugin);
                player.sendMessage("Bee riding disabled.");
                break;
            case "summon":
                if (!player.hasPermission("tekkisaddons.ridebee.summon")) {
                    player.sendMessage("You do not have permission to summon bees.");
                    return true;
                }
                Bee bee = player.getWorld().spawn(player.getLocation(), Bee.class);
                bee.setMetadata("ridden", new FixedMetadataValue(plugin, true));
                bee.addPassenger(player);
                player.sendMessage("Bee summoned and you are now riding it!");
                break;
            default:
                player.sendMessage("Invalid argument. Usage: /ridebee [on|off|summon]");
                break;
        }

        return true;
    }
}
