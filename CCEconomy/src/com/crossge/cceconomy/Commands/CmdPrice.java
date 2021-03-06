package com.crossge.cceconomy.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.crossge.cceconomy.*;

public class CmdPrice extends Cmd
{
	ArrayLists arl = new ArrayLists();
	Formatter form = new Formatter();
	Prices pr = new Prices();
	Materials mat = new Materials();
	public CmdPrice()
	{
		
	}
	public boolean commandUse(CommandSender sender, String[] args)
	{
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (args.length > 2)
				return false;
			String itemName = "";
			String oper = "";
			if (args.length == 1)
			{
				if(!args[0].equalsIgnoreCase("buy") && !args[0].equalsIgnoreCase("sell"))
				{
					player.sendMessage(arl.getMessages() + "Input either sell or buy");
					return false;
				}
				itemName = Integer.toString(player.getItemInHand().getTypeId());
				oper = args[0];
			}
			if (args.length == 2)
			{
				if(!args[1].equalsIgnoreCase("buy") && !args[1].equalsIgnoreCase("sell"))
				{
					player.sendMessage(arl.getMessages() + "Input either sell or buy");
					return false;
				}
				itemName = args[0];
				oper = args[1];
			}
			if(form.isLegal(itemName))
				itemName = mat.idToName(Integer.parseInt(itemName));
			itemName = mat.findItem(itemName);
			if(!mat.itemExists(itemName))
			{
				player.sendMessage(arl.getMessages() + "That item does not exist");
				return true;
			}
			String file = "";
			if(oper.equalsIgnoreCase("buy"))
				file = arl.getBuyFile();
			else if(oper.equalsIgnoreCase("sell"))
				file = arl.getSellFile();
			else
			{
				player.sendMessage(arl.getMessages() + "Input either sell or buy");
				return false;
			}
			String cost = pr.cost(file, itemName);
			if(!itemName.equalsIgnoreCase("NETHER_BRICK_ITEM"))
				itemName = itemName.replaceAll("_ITEM", "");
			itemName = form.capFirst(itemName);
			if(cost == null || cost.equalsIgnoreCase("null"))
			{
				if(oper.equalsIgnoreCase("buy"))
					player.sendMessage(arl.getMessages() + plural(itemName) + " cannot be bought from the server");
				else
					player.sendMessage(arl.getMessages() + plural(itemName) + " cannot be sold to the server");
				return true;
			}
			if(oper.equalsIgnoreCase("buy"))
				player.sendMessage(arl.getMessages() + plural(itemName) + " can be bought for " + arl.getMoney() + "$" + cost);
			else
				player.sendMessage(arl.getMessages() + plural(itemName) + " can be sold for " + arl.getMoney() + "$" + cost);
			return true;
		}
		else
		{
			if (args.length != 2)
				return false;
			String itemName = args[0];
			if(form.isLegal(itemName))
				itemName = mat.idToName(Integer.parseInt(itemName));
			itemName = mat.findItem(itemName);
			if(!mat.itemExists(itemName))
			{
				sender.sendMessage(arl.getMessages() + "That item does not exist");
				return true;
			}
			String file;
			String oper = args[1];
			if(oper.equalsIgnoreCase("buy"))
				file = arl.getBuyFile();
			else if(oper.equalsIgnoreCase("sell"))
				file = arl.getSellFile();
			else
			{
				sender.sendMessage(arl.getMessages() + "Input either sell or buy");
				return false;
			}
			String cost = pr.cost(file, itemName);
			itemName = itemName.replaceAll("_ITEM", "");
			itemName = form.capFirst(itemName);
			if(cost == null || cost.equalsIgnoreCase("null"))
			{
				if(oper.equalsIgnoreCase("buy"))
					sender.sendMessage(arl.getMessages() + plural(itemName) + " cannot be bought from the server");
				else
					sender.sendMessage(arl.getMessages() + plural(itemName) + " cannot be sold to the server");
				return true;
			}
			if(oper.equalsIgnoreCase("buy"))
				sender.sendMessage(arl.getMessages() + plural(itemName) + " can be bought for " + arl.getMoney() + "$" + cost);
			else
				sender.sendMessage(arl.getMessages() + plural(itemName) + " can be sold for " + arl.getMoney() + "$" + cost);
			return true;
		}
	}
	private String plural(String s)
	{
		if(s.endsWith("s") || s.endsWith("S"))
			return s;
		return s + "s";
	}
}