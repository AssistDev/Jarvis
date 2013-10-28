package me.applenick.jarvis.events;

import me.applenick.jarvis.jarvis;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {
	
	private String user = jarvis.user;
	private String motd = jarvis.motd;
	private String pre = ChatColor.BLACK + "[" +ChatColor.BLUE+ "Jarvis"+ ChatColor.BLACK + "]";
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		if(!(event.getPlayer().getName().equalsIgnoreCase(user))){
			event.getPlayer().sendMessage(motd);
		}
		Player p = event.getPlayer();
		p.sendMessage(ChatColor.AQUA + "Welcome Back Sir,");
		p.sendMessage(ChatColor.DARK_AQUA + "I am going to need your Pin for you to access me.");
		p.sendMessage(ChatColor.GREEN + "Use /login (pin) to proceed.");
		return;
	}
	
	@EventHandler 
	public void onLeave(PlayerQuitEvent event){
		Player p = event.getPlayer();
		if(p.equals(user)){
		p.setOp(false);
		p.getServer().broadcastMessage(pre + ChatColor.GOLD + user + ChatColor.DARK_GRAY + " has left the server!");
		}
		
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event){
		Player p = event.getEntity();
		Location spawn = event.getEntity().getWorld().getSpawnLocation();
		p.setHealth(20);
		p.teleport(spawn);
		p.sendMessage(pre + ChatColor.DARK_AQUA + " you have respawned!");
		p.playSound(p.getLocation(), Sound.IRONGOLEM_DEATH, 1, 1);	
	}

}
