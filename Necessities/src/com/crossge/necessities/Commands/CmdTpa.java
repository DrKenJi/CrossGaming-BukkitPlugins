package com.crossge.necessities.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.crossge.necessities.*;

public class CmdTpa extends Cmd
{
	ArrayLists arl = new ArrayLists();
	Teleports telp = new Teleports();
	public CmdTpa()
	{

	}
	public boolean commandUse(CommandSender sender, String[] args)
	{
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (args.length != 1)
	        {
	      	   return false;
	        }
			String pname = player.getName();
			Player target = sender.getServer().getPlayer(args[0]);
			if(target == null)
			{
				return false;
			}
			String rname = target.getName();
			telp.createTp(rname + " " + pname, "tothem");
			player.sendMessage(arl.getCol() + "You sent a teleport request to " + rname);
			target.sendMessage(arl.getCol() + pname + " is requesting to teleport to you");
			target.sendMessage(arl.getCol() + "Type /tpaccept or /tpdeny to accept or deny their teleport request");
			return true;
		}
		else
		{
			sender.sendMessage(arl.getCol() + "You are not a player you can't teleport.");
			return true;
		}
	}
}