package me.applenick.jarvis.events;

import me.applenick.jarvis.jarvis;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {
	
	private String user = jarvis.user;
	private String nick = jarvis.nick;
	private String pin = jarvis.Pin;
	private String motd = jarvis.motd;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		if(!(event.getPlayer().getName().equalsIgnoreCase(user))){
			event.getPlayer().sendMessage(motd);
			return;
		}
		Player p = event.getPlayer();
		p.sendMessage(ChatColor.AQUA + "Welcome Back Sir,");
		p.sendMessage("I am going to need your Pin for you to access me.");
		p.sendMessage("Use /login (pin) to proceed.");
		return;
	}
	
	@EventHandler 
	public void onLeave(PlayerQuitEvent event){
		
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event){
		
	}

}
