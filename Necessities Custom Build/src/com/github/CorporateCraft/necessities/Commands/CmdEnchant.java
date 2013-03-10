package com.github.CorporateCraft.necessities.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import com.github.CorporateCraft.necessities.ArrayLists;

public class CmdEnchant extends Cmd
{
	ArrayLists arl = new ArrayLists();
	public CmdEnchant()
	{
		
	}
	public boolean commandUse(CommandSender sender, String[] args)
	{
		if (sender instanceof Player)
		{
			if (args.length > 2)
	        {
	      	   return false;
	        }
			Player player = (Player) sender;
			if (args.length == 0)
	        {
	      	   return false;
	        }
			if (args.length == 1)
	        {
				Enchantment ench = Enchantment.getByName(enchantFinder(args[0]));
				if(ench == null)
				{
					player.sendMessage(arl.getCol() + "Enchantment does not exist.");
					return true;
				}
				int level = ench.getMaxLevel();
				if(ench.canEnchantItem(player.getInventory().getItemInHand()))
				{
					player.getInventory().getItemInHand().addEnchantment(ench, level);
					player.sendMessage(arl.getCol() + "Added the enchantment " + ench.getName() + " at level " + Integer.toString(level) + ".");
					return true;
				}
				player.sendMessage(arl.getCol() + "This item can not support given enchantment.");
	        }
			if (args.length == 2)
	        {
				Enchantment ench = null;
				if(!args[0].equalsIgnoreCase("all"))
				{
					ench = Enchantment.getByName(enchantFinder(args[0]));
					if(ench == null)
					{
						player.sendMessage(arl.getCol() + "Enchantment does not exist.");
						return true;
					}
				}
				try
				{
					Integer.parseInt(args[1]);
				}
				catch(Exception e)
				{
					return false;
				}
				int level = Integer.parseInt(args[1]);
				//if(level > 10)
				//{
				//	level = 10;
				//}
				//if(ench.canEnchantItem(player.getInventory().getItemInHand()))
				//{
				if(!args[0].equalsIgnoreCase("all"))
				{
					player.getInventory().getItemInHand().addUnsafeEnchantment(ench, level);
					player.sendMessage(arl.getCol() + "Added the enchantment " + ench.getName() + " at level " + Integer.toString(level) + ".");
					return true;
				}
				else
				{
					enchantAllArmor(level, player);
					player.sendMessage(arl.getCol() + "Added the all armor enchantments at level " + Integer.toString(level) + ".");
					return true;
				}
				//}
				//player.sendMessage(arl.getCol() + "This item can not support given enchantment.");
	        }
			return true;
		}
		else
		{
			sender.sendMessage(arl.getCol() + "You are not a player  so you do not have an items.");
			return true;
		}
	}
	
	private void enchantAllArmor(int level, Player player)
	{
		player.getInventory().getItemInHand().addUnsafeEnchantment(Enchantment.getByName("OXYGEN"), level);
		player.getInventory().getItemInHand().addUnsafeEnchantment(Enchantment.getByName("PROTECTION_ENVIRONMENTAL"), level);
		player.getInventory().getItemInHand().addUnsafeEnchantment(Enchantment.getByName("PROTECTION_EXPLOSIONS"), level);
		player.getInventory().getItemInHand().addUnsafeEnchantment(Enchantment.getByName("PROTECTION_FALL"), level);
		player.getInventory().getItemInHand().addUnsafeEnchantment(Enchantment.getByName("PROTECTION_FIRE"), level);
		player.getInventory().getItemInHand().addUnsafeEnchantment(Enchantment.getByName("PROTECTION_PROJECTILE"), level);
		player.getInventory().getItemInHand().addUnsafeEnchantment(Enchantment.getByName("WATER_WORKER"), level);
		player.getInventory().getItemInHand().addUnsafeEnchantment(Enchantment.getByName("THORNS"), level);
		player.getInventory().getItemInHand().addUnsafeEnchantment(Enchantment.getByName("DURABILITY"), level);
	}
	
	private String enchantFinder(String enchant)
	{
		enchant = enchant.toUpperCase();
		if(enchant.equals("POWER"))
			enchant = "ARROW_DAMAGE";
		else if(enchant.equals("FLAME"))
			enchant = "ARROW_FIRE";
		else if(enchant.equals("INFINITY"))
			enchant = "ARROW_INFINITY";
		else if(enchant.equals("PUNCH"))
			enchant = "ARROW_KNOCKBACK";
		else if(enchant.equals("SHARPNESS"))
			enchant = "DAMAGE_ALL";
		else if(enchant.equals("BANEOFARTHROPODS"))
			enchant = "DAMAGE_ARTHROPODS";
		else if(enchant.equals("BANE"))
			enchant = "DAMAGE_ARTHROPODS";
		else if(enchant.equals("SMITE"))
			enchant = "DAMAGE_UNDEAD";
		else if(enchant.equals("EFFICENCY"))
			enchant = "DIG_SPEED";
		else if(enchant.equals("UNBREAKING"))
			enchant = "DURABILITY";
		else if(enchant.equals("FIREASPECT"))
			enchant = "FIRE_ASPECT";
		else if(enchant.equals("FORTUNE"))
			enchant = "LOOT_BONUS_BLOCKS";
		else if(enchant.equals("LOOTING"))
			enchant = "LOOT_BONUS_MOBS";
		else if(enchant.equals("RESPIRATION"))
			enchant = "OXYGEN";
		else if(enchant.equals("PROTECTION"))
			enchant = "PROTECTION_ENVIRONMENTAL";
		else if(enchant.equals("BLASTPROTECTION"))
			enchant = "PROTECTION_EXPLOSIONS";
		else if(enchant.equals("FEATHERFALLING"))
			enchant = "PROTECTION_FALL";
		else if(enchant.equals("FIREPROTECTION"))
			enchant = "PROTECTION_FIRE";
		else if(enchant.equals("PROJECTILEPROTECTION"))
			enchant = "PROTECTION_PROJECTILE";
		else if(enchant.equals("SILKTOUCH"))
			enchant = "SILK_TOUCH";
		else if(enchant.equals("AQUAINFINITY"))
			enchant = "WATER_WORKER";
		return enchant;
	}
}