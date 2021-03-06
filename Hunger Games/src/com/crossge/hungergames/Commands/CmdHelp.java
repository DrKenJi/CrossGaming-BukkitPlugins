package com.crossge.hungergames.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdHelp extends Cmd
{
	public boolean commandUse(CommandSender sender, String[] args)
	{
		int maxPages = 5;
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			if(p.hasPermission("HungerGames.help"))
			{
				int page = 1;
				if(args.length > 0)
				{
					try
					{
						page = Integer.parseInt(args[0]);
					}
					catch(Exception e){}
				}
				if(page == 0)
					page = 1;
				if(page > maxPages)
				{
					p.sendMessage(var.errorCol() + "Error: Please enter a page inbetween 1 and " + Integer.toString(maxPages));
					return false;
				}
				p.sendMessage(var.defaultCol() + "Hunger Games Help Page " + Integer.toString(page) + " of " + Integer.toString(maxPages));
				if(page == 1)
					page1(sender);
				else if(page == 2)
					page2(sender);
				else if(page == 3)
					page3(sender);
				else if(page == 4)
					page4(sender);
				else if(page == 5)
					page5(sender);
			}
			else
				p.sendMessage(var.errorCol() + "Error: You may not view the help for Hunger Games.");
		}
		else
		{
			int page = 1;
			if(args.length > 0)
			{
				try
				{
					page = Integer.parseInt(args[0]);
				}
				catch(Exception e){}
			}
			if(page == 0)
				page = 1;
			if(page > maxPages)
			{
				sender.sendMessage(var.errorCol() + "Error: Please enter a page inbetween 1 and " + Integer.toString(maxPages));
				return false;
			}
			sender.sendMessage(var.defaultCol() + "Hunger Games Help Page " + Integer.toString(page) + " of " + Integer.toString(maxPages));
			if(page == 1)
				page1(sender);
			else if(page == 2)
				page2(sender);
			else if(page == 3)
				page3(sender);
			else if(page == 4)
				page4(sender);
			else if(page == 5)
				page5(sender);
		}
		return true;
	}
	private void page1(CommandSender sender)
	{
		sender.sendMessage(var.defaultCol() + "/hg credits ~ Shows the credits of the team who brought you this plugin.");
		sender.sendMessage(var.defaultCol() + "/hg help [page] ~ Shows the help page [page] for hunger games.");
		sender.sendMessage(var.defaultCol() + "/hg join ~ Gets in line for next game.");
		sender.sendMessage(var.defaultCol() + "/hg spectate [player] ~ Spectates the current game or [player].");
		sender.sendMessage(var.defaultCol() + "/hg leave ~ Leaves the current game or if in line, the line.");
	}
	private void page2(CommandSender sender)
	{
		sender.sendMessage(var.defaultCol() + "/hg setspawn [number] ~ Sets the [number] spawnpoint(max set in config.yml bye maxPlayers) 0 is the specator spawnpoint.");
		sender.sendMessage(var.defaultCol() + "/hg info ~ Views info about the current round.");
		sender.sendMessage(var.defaultCol() + "/hg vote [map number] ~ Votes for map [map number].");
		sender.sendMessage(var.defaultCol() + "/hg stats [player] ~ Shows the stats of [player].");
		sender.sendMessage(var.defaultCol() + "/hg forcestart ~ Forces the game to start.");
	}
	private void page3(CommandSender sender)
	{
		sender.sendMessage(var.defaultCol() + "/hg sponsor ~ Sponsors yourself.");
		sender.sendMessage(var.defaultCol() + "/hg kit [kitname] ~ Chooses a kit to use (disabled by default).");
		sender.sendMessage(var.defaultCol() + "/hg setkitprice [kitname] [price] ~ Sets the price for a kit.");
		sender.sendMessage(var.defaultCol() + "/hg buykit [kitname] ~ Will buy the kit if you have enough points.");
		sender.sendMessage(var.defaultCol() + "/hg kitprices ~ View the prices for the buyable kits.");
	}
	private void page4(CommandSender sender)
	{
		sender.sendMessage(var.defaultCol() + "/hg convert [mysql:yml] ~ Converts stats from one database to specified one.");
		sender.sendMessage(var.defaultCol() + "/hg setworldspawn ~ Sets the spawn players will go to when they die or game ends.");
		sender.sendMessage(var.defaultCol() + "/hg modify [player] [stats class] [amount] ~ Modifies [player]'s [stats class] by [amount].");
		sender.sendMessage(var.defaultCol() + "/hg leaderboard [stats class] [page] ~ Leaderboard of each stat class.");
		sender.sendMessage(var.defaultCol() + "Stat Classes: deaths, games, kills, points, wins.");
	}
	private void page5(CommandSender sender)
	{
		sender.sendMessage(var.defaultCol() + "/hg setcorner [number] ~ Sets the corners for the hunger games either 1 or 2.");
		sender.sendMessage(var.defaultCol() + "/hg forcestop ~ Forces the current game to stop.");
		sender.sendMessage(var.defaultCol() + "/hg setchests [world] ~ Locates the chest locations for given world.");
		sender.sendMessage(var.defaultCol() + "Coming soon.");
		sender.sendMessage(var.defaultCol() + "Coming soon.");
	}
}
