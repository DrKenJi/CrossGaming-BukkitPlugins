package com.github.CorporateCraft.cceconomy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.bukkit.Material;

public class ArrayLists
{
	public static ArrayList<String> Balances = new ArrayList<String>();
	public static ArrayList<String> SellPrices = new ArrayList<String>();
	public static ArrayList<String> BuyPrices = new ArrayList<String>();
	public static ArrayList<String> MaterialList = new ArrayList<String>();
	public static HashMap<String,String> Trades = new HashMap<String,String>();
	
	public static void StartLists()
	{
		UpdateBalances();
		UpdateSellPrices();
		UpdateBuyCosts();
		Prices.updateList();
	}
	
	private static void UpdateBalances()
	{
		Formatter.ReadFile(CCEconomy.balfile,Balances);
		Collections.sort(Balances);
	}
	
	private static void UpdateSellPrices()
	{
		Formatter.ReadFile(CCEconomy.sellfile, SellPrices);
	}
	
	private static void UpdateBuyCosts()
	{
		Formatter.ReadFile(CCEconomy.buyfile, BuyPrices);
	}
	
	public static void SetMaterials()
	{
		for(int i = 0; i < Materials.MaxItems; i++)
		{
			try
			{
				MaterialList.add(Materials.idToName(Material.getMaterial(i).getId()).replaceAll("_", "") + " null");
			}
			catch(Exception e){}
		}
	}
}