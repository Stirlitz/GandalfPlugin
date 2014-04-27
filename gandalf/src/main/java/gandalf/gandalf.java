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
import org.bukkit.entity.NPC;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.ntcomputer.minecraft.controllablemobs.api.ControllableMob;
import de.ntcomputer.minecraft.controllablemobs.api.ControllableMobs;

public class gandalf extends JavaPlugin {
	
/*	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onEntitySpawn(CreatureSpawnEvent event){
		LivingEntity entity = event.getEntity();
		
		if (entity.getType() == EntityType.VILLAGER){
			EntityInsentient nmsEntity = (EntityInsentient) ((CraftLivingEntity) entity).getHandle();
			
		}
	}*/
	
	
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
	             World w = Bukkit.getWorld("world");
	             LivingEntity bro = (LivingEntity) w.spawnEntity(loc, EntityType.VILLAGER);
	             bro.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 2000, 5));
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
