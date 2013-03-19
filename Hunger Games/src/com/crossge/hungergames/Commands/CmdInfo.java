package com.crossge.hungergames.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.crossge.hungergames.*;

public class CmdInfo extends Cmd
{
	Variables var = new Variables();
	Players pl = new Players();
	public CmdInfo()
	{
		
	}
	
	public boolean commandUse(CommandSender sender, String[] args)
	{
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			if(p.hasPermission("HungerGames.info"))
			{
				p.sendMessage(var.defaultCol() + pl.amount());
				p.sendMessage(var.defaultCol() + "Alive: " + pl.breathing());
				p.sendMessage(var.defaultCol() + "Dead: " + pl.deceased());
			}
			else
			{
				p.sendMessage(var.errorCol() + "Error you may not view the info for the current round.");
			}
		}
		else
		{
			sender.sendMessage(var.defaultCol() + pl.amount());
			sender.sendMessage(var.defaultCol() + "Alive: " + pl.breathing());
			sender.sendMessage(var.defaultCol() + "Dead: " + pl.deceased());
		}
		return true;
	}
}