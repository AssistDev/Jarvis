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
			
		}
	}
	
	
	
    public String MSG(String Message) {
        return Message.replaceAll("~([a-z0-9])", ChatColor.COLOR_CHAR + "$1");
    }
    
        
}
