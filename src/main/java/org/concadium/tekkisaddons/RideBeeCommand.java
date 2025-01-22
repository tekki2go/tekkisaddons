package org.concadium.tekkisaddons;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Bee;
import org.bukkit.entity.Player;

public class RideBeeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Spawn a bee and let the player ride it
            Bee bee = player.getWorld().spawn(player.getLocation(), Bee.class);
            bee.addPassenger(player);
            player.sendMessage("You are now riding a bee!");

            return true;
        } else {
            sender.sendMessage("This command can only be used by players.");
            return false;
        }
    }
}
