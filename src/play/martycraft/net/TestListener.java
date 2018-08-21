/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package play.martycraft.net;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Calvin
 */

public class TestListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked(); // The player that clicked the item
        ItemStack clicked = event.getCurrentItem(); // The item that was clicked
        Inventory inventory = event.getInventory(); // The inventory that was clicked in
        if (inventory.getName().equals("FastGamemodeChanger"))  // The inventory is our custom Inventory
        // The inventory is our custom Inventory    
            if (clicked.getType() == Material.BEDROCK) { // The item that the player clicked it dirt
                event.setCancelled(true); // Make it so the dirt is back in its original spot
                player.closeInventory(); // Closes there inventory
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatColor.DARK_GRAY + "Gamemode set to creative");
        } else if (clicked.getType() == Material.DIAMOND_SWORD) {
            event.setCancelled(true);
            player.closeInventory();
            player.sendMessage(ChatColor.DARK_GRAY + "Gamemode set to survival");
            player.setGameMode(GameMode.SURVIVAL);
        } else if (clicked.getType() == Material.EYE_OF_ENDER) {
            event.setCancelled(true);
            player.closeInventory();
            player.sendMessage(ChatColor.DARK_GRAY + "Gamemode set to spectator");
            player.setGameMode(GameMode.SPECTATOR);
        } else if (clicked.getType() == Material.LEATHER_CHESTPLATE) {
            event.setCancelled(true);
            player.closeInventory();
            player.setGameMode(GameMode.ADVENTURE);
            player.sendMessage(ChatColor.DARK_GRAY + "Gamemode set to adventure");
        } else if (clicked.getType() == Material.REDSTONE_BLOCK) {
            event.setCancelled(true);
            player.closeInventory();
            }
        }
      
    @EventHandler
    public void onSignChange(SignChangeEvent sign) {
        if (sign.getLine(0).equalsIgnoreCase("[gmc]")) {
            sign.setLine(0, ChatColor.BOLD + "=-=-=-=-=-=");
            sign.setLine(1, ChatColor.BOLD + "Setgamemode");
            sign.setLine(2, ChatColor.BOLD + "Creative");
            sign.setLine(3, ChatColor.BOLD + "=-=-=-=-=-=-=-=");
        } else if (sign.getLine(0).equalsIgnoreCase("[gma]")) {
            sign.setLine(0, ChatColor.BOLD + "=-=-=-=-=-=-=-=");
            sign.setLine(1, ChatColor.BOLD + "Setgamemode");
            sign.setLine(2, ChatColor.BOLD + "Adventure");
            sign.setLine(3, ChatColor.BOLD + "=-=-=-=-=-=-=-=");
        } else if (sign.getLine(0).equalsIgnoreCase("[gms]")) {
            sign.setLine(0, ChatColor.BOLD + "=-=-=-=-=-=-=-=");
            sign.setLine(1, ChatColor.BOLD + "Setgamemode");
            sign.setLine(2, ChatColor.BOLD + "Spectator");
            sign.setLine(3, ChatColor.BOLD + "=-=-=-=-=-=-=-=");
        } else if (sign.getLine(0).equalsIgnoreCase("[gmsp]")) {
            sign.setLine(0, ChatColor.BOLD + "=-=-=-=-=-=-=-=");
            sign.setLine(1, ChatColor.BOLD + "Setgamemode");
            sign.setLine(2, ChatColor.BOLD + "Spectator");
            sign.setLine(3, ChatColor.BOLD + "=-=-=-=-=-=-=-=");
            
        }
}
    
@EventHandler
public void gamemodeSign(PlayerInteractEvent PIE) {
    if ((PIE.getAction() == Action.RIGHT_CLICK_BLOCK)) {
        if (PIE.getClickedBlock().getState() instanceof Sign) {
            Player player = PIE.getPlayer();
            Sign sign = (Sign) PIE.getClickedBlock().getState();
            
            if (sign.getLine(0).equalsIgnoreCase("=-=-=-=-=-=")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage("Gamemode set to creative");
            }
        }
    } 
}}
                
    
