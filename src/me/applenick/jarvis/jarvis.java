package me.applenick.jarvis;

import me.applenick.jarvis.events.Events;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class jarvis extends JavaPlugin {
	
	public static String user = "";
	public static String nick = "";
	public static String Pin = "" ; 
	public static String motd = "";
	public boolean Trusted = false;

	
	public void onEnable(){
		//import config
		getConfig().options().copyDefaults();
		saveConfig();
		user = MSG(getConfig().getString("userFull"));
		nick = MSG(getConfig().getString("userNick"));
		Pin = MSG(getConfig().getString("Pin"));
		motd = MSG(getConfig().getString("motd"));

		
		//events
		getServer().getPluginManager()
		.registerEvents(new Events(), this);
	}
	
	public void onDisable(){
		saveConfig();
		
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(cmd.getName().equalsIgnoreCase("jarvis")){
			//add later help stuff
		}
		
		else if(cmd.getName().equalsIgnoreCase("login")){
			if(args[1].equalsIgnoreCase(Pin)){
				sender.sendMessage(ChatColor.DARK_GRAY + "Authenticating...");
				sender.sendMessage(ChatColor.GREEN + "Suscessfully Logged in!");
				boolean Trusted = true;
				return true;
				
			}
		}
		return true;
	}
	
	
	
    public String MSG(String Message) {
        return Message.replaceAll("~([a-z0-9])", ChatColor.COLOR_CHAR + "$1");
    }
    
        
}
