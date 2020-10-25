package me.xrexy.customentity;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_12_R1.World;

public class CustomEntitySpawnExamples extends JavaPlugin implements Listener {

	// THIS IS JUST AN EXAMPLE HOW TO SPAWN THE ENTITIES

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void interactEvent(PlayerInteractEvent event) {
		/*
		 * LEFT CLICK - Gonna spawn the custom Iron Golem from "CustomIronGolemExample" class 
		 * RIGHT CLICK - Gonna spawn the custom Zombie from "CustomZombieExample" class (With a owner variable)
		 */

		Player owner = event.getPlayer();
		Location location = owner.getLocation();
		World nmsworld = ((CraftWorld) location.getWorld()).getHandle();

		if (event.getAction().equals(Action.LEFT_CLICK_AIR))
			CustomEntity.EXAMPLE_GOLEM.spawn(nmsworld, location);

		if (event.getAction().equals(Action.LEFT_CLICK_BLOCK))
			CustomEntity.EXAMPLE_ZOMBIE.spawn(nmsworld, location, owner);
	}
}
