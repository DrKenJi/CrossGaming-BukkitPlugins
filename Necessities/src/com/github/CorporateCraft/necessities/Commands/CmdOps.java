package com.github.CorporateCraft.necessities.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.github.CorporateCraft.necessities.*;

public class CmdOps
{
	public static boolean CommandUse(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (sender instanceof Player)
		{
           Player player = (Player) sender;
           String line = Formatter.readFileStr("ops.txt");
           if(line == null)
           {
        	   player.sendMessage(Necessities.messages + "There are no operators.");
        	   return true;
           }
           player.sendMessage(Necessities.messages + "The Operators are: " + line);
           return true;
        } 
		else
		{
			String line = Formatter.readFileStr("ops.txt");
			if(line == null)
			{
				sender.sendMessage(Necessities.messages + "There are no operators.");
				return true;
			}
			sender.sendMessage(Necessities.messages + "The Operators are: " + line);
			return true;
	    }
	}
}