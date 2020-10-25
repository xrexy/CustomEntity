package me.xrexy.customentity;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_12_R1.EntityZombie;
import net.minecraft.server.v1_12_R1.World;

public class CustomZombieExample extends EntityZombie{

	@SuppressWarnings("deprecation")
	public CustomZombieExample(World world, Location loc, Player owner) {
		super(world);
		
		this.setBaby(true);
		this.setCustomName(ChatColor.DARK_GRAY + "Little Ninja");
		this.setCustomNameVisible(true);
		
		Zombie craftZombie = (Zombie) this.getBukkitEntity();
		
		// Creating a new skull using the skin of the owner
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta sm = (SkullMeta) skull.getItemMeta();
		sm.setOwner(owner.getName());
		skull.setItemMeta(sm);
		
		equipArmorPieces(craftZombie, skull);
		
		world.addEntity(this);
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
	}
	
	void equipArmorPieces(Zombie z, ItemStack skull) {
		EntityEquipment equipment = z.getEquipment();

		// Helmet
		equipment.setHelmet(skull);

		// Chestplate
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta chestplate_meta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplate_meta.setUnbreakable(true);
		chestplate_meta.setColor(Color.fromRGB(30, 30, 30));
		chestplate.setItemMeta(chestplate_meta);
		equipment.setChestplate(chestplate);

		// Leggings
		ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta legs_meta = (LeatherArmorMeta) legs.getItemMeta();
		legs_meta.setUnbreakable(true);
		legs_meta.setColor(Color.fromRGB(10, 10, 10));
		legs.setItemMeta(legs_meta);
		equipment.setLeggings(legs);

		// Boots
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta boots_meta = (LeatherArmorMeta) boots.getItemMeta();
		boots_meta.setUnbreakable(true);
		boots_meta.setColor(Color.fromRGB(30, 30, 30));
		boots.setItemMeta(boots_meta);
		equipment.setBoots(boots);

		// Item in hand
		equipment.setItemInMainHand(new ItemStack(Material.IRON_SWORD));
	}
}
