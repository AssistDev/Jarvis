package me.applenick.jarvis;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class jarvis extends JavaPlugin {
	
	public static String user = "";
	public static String nick = "";
	public static String Pin = "" ;  

	
	public void onEnable(){
		getConfig().options().copyDefaults();
		saveConfig();
		user = MSG(getConfig().getString("userFull"));
		nick = MSG(getConfig().getString("userNick"));
		Pin = MSG(getConfig().getString("Pin"));
	}
	
	public void onDisable(){
		saveConfig();
		
	}
	
	
    public String MSG(String Message) {
        return Message.replaceAll("~([a-z0-9])", ChatColor.COLOR_CHAR + "$1");
    }
    
    
}
