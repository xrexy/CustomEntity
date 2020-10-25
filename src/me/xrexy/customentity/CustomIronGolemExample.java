package me.xrexy.customentity;

import org.bukkit.Location;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_12_R1.EntityIronGolem;
import net.minecraft.server.v1_12_R1.World;

public class CustomIronGolemExample extends EntityIronGolem{

	public CustomIronGolemExample(World world, Location loc) {
		super(world);
		
		// Code to customize entity
		this.setCustomName(ChatColor.RED + "Iron Golem");
		this.setCustomNameVisible(true);
		
		
		this.getWorld().addEntity(this);
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
	}

}
