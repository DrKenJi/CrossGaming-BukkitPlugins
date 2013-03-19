package com.crossge.hungergames.Commands;

import org.bukkit.command.CommandSender;

public class CmdHungerGames extends Cmd
{
	public CmdHungerGames()
	{
		
	}
	
	public boolean commandUse(CommandSender sender, String[] args)
	{
		Cmd com = new Cmd();
		if(args.length == 0)
			com = new CmdHelp();
		String subCom = args[0];
		String[] argsNew = new String[args.length - 1];
		for(int i = 0 ; i < args.length; i++)
		{
			if(i + 1 == args.length)
				break;
			argsNew[i] = args[i + 1];
		}
		if(subCom.equalsIgnoreCase("help"))
			com = new CmdHelp();
		else if(subCom.equalsIgnoreCase("join"))
			com = new CmdJoin();
		else if(subCom.equalsIgnoreCase("leave"))
			com = new CmdLeave();
		else if(subCom.equalsIgnoreCase("spectate"))
			com = new CmdSpectate();
		else if(subCom.equalsIgnoreCase("setspawn"))
			com = new CmdSetSpawn();
		else if(subCom.equalsIgnoreCase("info"))
			com = new CmdInfo();
		else if(subCom.equalsIgnoreCase("stats"))
			com = new CmdStats();
		else if(subCom.equalsIgnoreCase("vote"))
			com = new CmdVote();
		else if(subCom.equalsIgnoreCase("credits"))
			com = new CmdCredits();
		else if(subCom.equalsIgnoreCase("forcestart"))
			com = new CmdForceStart();
		return com.commandUse(sender, argsNew);	
	}	
}