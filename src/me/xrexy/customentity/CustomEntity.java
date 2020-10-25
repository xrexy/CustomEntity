package me.xrexy.customentity;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_12_R1.Entity;

public enum CustomEntity {
	EXAMPLE_GOLEM(EntityType.IRON_GOLEM, CustomIronGolemExample.class),
	EXAMPLE_ZOMBIE(EntityType.ZOMBIE, CustomZombieExample.class);

	private Class<? extends Entity> clazz;
	private EntityType type;
	Player owner;

	private CustomEntity(EntityType type, Class<? extends Entity> clazz) {
		this.clazz = clazz;
		this.type = type;
	}

	@SuppressWarnings("deprecation")
	public void spawn(net.minecraft.server.v1_12_R1.World world, org.bukkit.Location loc) {
		try {
			CustomEntityRegistry.registerCustomEntity(this.type.getTypeId(), this.type.getName(), clazz);
			
			this.clazz.getConstructor(
							new Class[] { net.minecraft.server.v1_12_R1.World.class, org.bukkit.Location.class }).newInstance(world, loc);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void spawn(net.minecraft.server.v1_12_R1.World world, org.bukkit.Location loc, Player p) {
		try {
			this.owner = p;
			CustomEntityRegistry.registerCustomEntity(this.type.getTypeId(), this.type.getName(), clazz);

			this.clazz.getConstructor(
					new Class[] { net.minecraft.server.v1_12_R1.World.class, org.bukkit.Location.class, Player.class }).newInstance(world, loc, p);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	public EntityType getType() {
		return this.type;
	}

	public Class<? extends Entity> getEntityClass() {
		return this.clazz;
	}

	public Player getOwner() throws NullPointerException {
		return this.owner;
	}
}
