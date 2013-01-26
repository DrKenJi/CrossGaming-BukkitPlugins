package com.github.CrossGaming.ccebridge.Commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import com.github.CrossGaming.ccebridge.RankPrices;
import com.github.CorporateCraft.cceconomy.*;

public class CmdBuyRank extends Cmd
{
	ArrayLists ccearl = new ArrayLists();
	BalChecks bal = new BalChecks();
	RankPrices rp = new RankPrices();
	Formatter form = new Formatter();
	private FileConfiguration customConfig = null;
   	private File customConfigFile = null;
	public CmdBuyRank()
	{
		
	}
	public boolean commandUse(CommandSender sender, String[] args)
	{
		if(args.length != 1)
		{
			return false;
		}
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			String rankName = form.capFirst(args[0]);
			double cost = rp.getCost(rankName);
			double balan = Double.parseDouble(bal.bal(player.getName()));
			if(balan < cost)
			{
				player.sendMessage(ccearl.getMessages() + "Not enough money.");
				return true;
			}
			if(!rp.rankBuyable(rankName))
			{
				player.sendMessage(ccearl.getMessages() + "Unknown or unbuyable rank.");
				return true;
			}
			String curRank = "";
			customConfigFile = new File("plugins/GroupManager/worlds/world", "users.yml");
    	   	customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
    	   	curRank = customConfig.getString("users." + player.getName() + ".group");
    	   	if(curRank == null)
    	   	{
    	   		curRank = "guest";
    	   	}
    	   	curRank = curRank.toUpperCase();
			if(!rp.nextRank(curRank, rankName))
			{
				player.sendMessage(ccearl.getMessages() + "You may not skip ranks or buy ranks you have already gotten.");
				return true;
			}
			bal.removeMoney(player.getName(), cost);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manpromote " + player.getName() + " " + rankName);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mansave");
			Bukkit.broadcastMessage(ccearl.getMessages() + player.getName() + " bought the rank " + rankName.toLowerCase());
			return true;
		}
		else
		{
			sender.sendMessage(ccearl.getMessages() + "You cannot buy a rank you are already the highest rank.");
			return true;
		}
	}
}