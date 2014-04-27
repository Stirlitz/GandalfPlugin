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
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

public class gandalf extends JavaPlugin {
	
/*	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onEntitySpawn(CreatureSpawnEvent event){
		LivingEntity entity = event.getEntity();
		
		if (entity.getType() == EntityType.VILLAGER){
			EntityInsentient nmsEntity = (EntityInsentient) ((CraftLivingEntity) entity).getHandle();
			
		}
	}*/
	
	LivingEntity bro, balrog;
	Location disableLoc;
	
	
	 @Override
	 public void onEnable() {
	     getLogger().info("gandalf.onEnable has been invoked!");
	 }
	 @Override
	 public void onDisable() {
	     getLogger().info("gandalf.onDisable has been invoked!");
	     try {
	    	 bro.damage(10000);
	    	 balrog.damage(10000);
	     } catch (NullPointerException e) {}
	     try {
//	    	 disableLoc.setZ(loc.getZ() - 10);
//	    	 loc.setY(loc.getY() - 2);
	    	 disableLoc.setX(disableLoc.getX() + 5);
         for (int i = 0; i < 10; i++) {
        	 Block b = disableLoc.getBlock();
        	 b.setType(Material.AIR);
        	 disableLoc.setZ(disableLoc.getZ() + 1);
         }
	     } catch (NullPointerException e) {}
	     
	 }

	 @Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	     if (cmd.getName().equalsIgnoreCase("gandalf")) {
	         if (sender instanceof Player) {
	             Player player = (Player)sender;
	             Location playerLoc = player.getLocation();
	             disableLoc = player.getLocation();
	             Location loc = player.getLocation();
	             Location uLoc = player.getLocation();
	             final Location sphereLoc = player.getLocation();
	             loc.setX(loc.getX() + 5);
	             final World world = Bukkit.getWorld("world");
	             
	             uLoc.setY(uLoc.getY() + 2);
	             uLoc.setX(uLoc.getX() + 5);
	             
	             for (int i = 0; i < 10; i++) {
	            	 Block b = loc.getBlock();
	            	 b.setType(Material.STONE);
	            	 loc.setZ(loc.getZ() + 1);
	             }
	             

	             
	             bro = (LivingEntity) world.spawnEntity(uLoc, EntityType.VILLAGER);
	             bro.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2000, 5));
	             uLoc.setZ(uLoc.getZ() + 10);
	             balrog = (LivingEntity) world.spawnEntity(uLoc, EntityType.GIANT);
	             balrog.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2000, 5));

	             
	             int wait = 0;
	             
	             wait = wait + 40;
	             BukkitScheduler scheduleA = Bukkit.getServer().getScheduler();
	             scheduleA.scheduleSyncDelayedTask(this, new Runnable() {
	            	 public void run() {
	    	             Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + /*player.getName() + */"You cannot pass!" );
	    	             balrog.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2000, 10));
					} 
	             }, wait);
	             

	             wait = wait + 30;
	             scheduleA.scheduleSyncDelayedTask(this, new Runnable() {
	            	 public void run() {
	    	             Bukkit.getServer().broadcastMessage(ChatColor.RED + /*player.getName() + */"<Balrog noises>" );
	    	             balrog.setFireTicks(2000);
					} 
	             }, wait);
	             
	             wait = wait + 30;
	             scheduleA.scheduleSyncDelayedTask(this, new Runnable() {
	            	 public void run() {
	    	             Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + /*player.getName() + */"I am a servant of the secret fire," );
	    	             Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + /*player.getName() + */"wielder of the Flame of Anor." );
					} 
	             }, wait);
	             
	             wait = wait + 30;
	             scheduleA.scheduleSyncDelayedTask(this, new Runnable() {
	            	 public void run() {
	    	             sphereLoc.setY(sphereLoc.getY() + 2);
	    	             sphereLoc.setX(sphereLoc.getX() + 5);
	    	             		int sphereRadius = 3;
	    		             	int cx = sphereLoc.getBlockX();
	    		             	int cy = sphereLoc.getBlockY();
	    		             	int cz = sphereLoc.getBlockZ();
	    		             	int rSquared = sphereRadius * sphereRadius;
	    		            
	    		            
	    		             	for (int x = cx - sphereRadius; x <= cx + sphereRadius; x++) {
	    		             		for (int z = cz - sphereRadius; z <= cz + sphereRadius; z++) {
	    		             			if ((cx - x) * (cx -x) + (cz - z) * (cz - z) <= rSquared && (cx - x) * (cx - x) + (cz - z) * (cz - z) > 4 ) {
	    		             				final Location l = new Location(world, x, cy, z);
	    		             				if(l.getBlock().getType().toString().equalsIgnoreCase("air"))
	    		             					l.getBlock().setType(Material.SPONGE);
	    		             			}
	    		             		}
	    		             	}
					} 
	             }, wait);
	             
	             wait = wait + 30;
	             scheduleA.scheduleSyncDelayedTask(this, new Runnable() {
	            	 public void run() {
	    	             		int sphereRadius = 3;
	    		             	int cx = sphereLoc.getBlockX();
	    		             	int cy = sphereLoc.getBlockY();
	    		             	int cz = sphereLoc.getBlockZ();
	    		             	int rSquared = sphereRadius * sphereRadius;
	    		            
	    		            
	    		             	for (int x = cx - sphereRadius; x <= cx + sphereRadius; x++) {
	    		             		for (int z = cz - sphereRadius; z <= cz + sphereRadius; z++) {
	    		             			if ((cx - x) * (cx -x) + (cz - z) * (cz - z) <= rSquared && (cx - x) * (cx - x) + (cz - z) * (cz - z) > 4 ) {
	    		             				final Location l = new Location(world, x, cy, z);
//	    		             				if(l.getBlock().getType().toString().equalsIgnoreCase("air"))
	    		             					l.getBlock().setType(Material.AIR);
	    		             			}
	    		             		}
	    		             	}
					} 
	             }, wait);
	             

	     
	             
	             
	             
	             
	             

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
