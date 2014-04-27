package gandalf;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import de.ntcomputer.minecraft.controllablemobs.api.ControllableMob;
import de.ntcomputer.minecraft.controllablemobs.api.ControllableMobs;

public class gandalf extends JavaPlugin {
	
	 private HashMap<Player,ControllableMob<Villager>> villagerMap;
	 
	 private void spawnVillager(Player owner, Location spawnLocation) {
		 this.cleanVillager(owner);
		 Villager villager = spawnLocation.getWorld().spawn(spawnLocation, Villager.class);
		 ControllableMob<Villager> controlledVillager = ControllableMobs.putUnderControl(villager);
	 }
	 
	 private void cleanVillager(Player owner) {
		 if(this.villagerMap.containsKey(owner)) {
			 ControllableMob<Villager> controlledVillager = this.villagerMap.get(owner);
			 controlledVillager.getActions().die();this.villagerMap.remove(owner);
		 }
	 }
	 
	 @EventHandler
	 public void onPlayerLeave(PlayerQuitEvent event){
		 this.cleanVillager(event.getPlayer());
	 }
	 
	 @Override
	 public void onEnable() {
	     getLogger().info("gandalf.onEnable has been invoked!");
	     this.villagerMap = new HashMap<Player,ControllableMob<Villager>>();
	 }
	 @Override
	 public void onDisable() {
	     getLogger().info("gandalf.onDisable has been invoked!");
	     for(ControllableMob<Villager> controlledVillager: this.villagerMap.values()) {
	    	 controlledVillager.getActions().die();
	     }
	     this.villagerMap.clear();
	     this.villagerMap = null;
	 }

	 @Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	     if (cmd.getName().equalsIgnoreCase("gandalf")) {
	         if (sender instanceof Player) {
	             Player player = (Player)sender;
	             Location loc = player.getLocation();
	             loc.setX(loc.getX() + 5);
//	             World w = Bukkit.getWorld("world");
	             this.spawnVillager(player, loc);
//	             Entity bro = w.spawnEntity(loc, EntityType.VILLAGER);
//	             Block b = loc.getBlock();
//	             b.setType(Material.STONE);
	             Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + /*player.getName() + */": You cannot pass!" );
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
