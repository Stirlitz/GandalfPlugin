package gandalf;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.plugin.java.JavaPlugin;

public class gandalf extends JavaPlugin {
	 @Override
	 public void onEnable() {
	     getLogger().info("gandalf.onEnable has been invoked!");
	 }
	 @Override
	 public void onDisable() {
	     getLogger().info("gandalf.onDisable has been invoked!");
	 }

	 @Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	     if (cmd.getName().equalsIgnoreCase("gandalf")) {
	         if (sender instanceof Player) {
	             Player player = (Player)sender;
	             Location loc = player.getLocation();
	             loc.setX(loc.getX() + 5);
	             World world = null;
	             LivingEntity bro = world.spawnCreature(loc, EntityType.VILLAGER);
//	             Block b = loc.getBlock();
//	             b.setType(Material.STONE);
	             Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + player.getName() + ": You cannot pass!" );
	             // DO SOMETHING HERE
	             return true;
	         }
	         else {
	             sender.sendMessage("Can only be executed by players.");
	             return false;
	         }
	     }
	     return false;
	 }



}
