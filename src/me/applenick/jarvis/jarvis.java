package me.applenick.jarvis;

import me.applenick.jarvis.events.Events;
import me.applenick.utils.PacketUtils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
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
	
	/** Don't accept this fork. Just pointing out a few bugs. */
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(cmd.getName().equalsIgnoreCase("jarvis")){
			if(!(sender.equals(Trusted))){ // 'Trusted' is a boolean, therefore sender will never be equal to it. I suggest you to use an ArrayList<String> that stores the trusted player names.
				sender.sendMessage(ChatColor.DARK_RED + "You are not logged in.");
				sender.sendMessage(ChatColor.AQUA + "Use /login to verify your account.");
			}
		}
		
		else if(cmd.getName().equalsIgnoreCase("login")){
			Player p = (Player) sender;
			if(args[1].equalsIgnoreCase(Pin)){ // If args[1] is your pin, then confirm authentication
				PacketUtils.displayLoadingBar("Authenticating...", "Authenticated", p, 5, true);
				sender.sendMessage(ChatColor.DARK_GRAY + "Authenticating...");
				sender.sendMessage(ChatColor.GREEN + "Suscessfully Logged in!"); // Spelling mistake
				boolean Trusted = true;
				return true;
			}
			else if(args[1].equalsIgnoreCase(Pin)){ // If args[1] is your pin, then deconfirm (is that a word?) authentication. Remove everything but the 'else'. 
				PacketUtils.displayLoadingBar("Authenticating...", "Authentication Failed", p, 5, true);
				sender.sendMessage(ChatColor.DARK_RED + "Authentication Failed.");
				return true;
			}
		}
		return true; // You should return false if nothing else works.
	}
	
	
	
    public String MSG(String Message) {
        return Message.replaceAll("~([a-z0-9])", ChatColor.COLOR_CHAR + "$1");
    }

	/** Unused */
	public static Plugin getInstance() {
		// TODO Auto-generated method stub
		return null;
	}   
}
