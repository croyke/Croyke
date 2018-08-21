package play.martycraft.net;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


/**
 *
 * @author Calvin
 */
public class CommandListener implements CommandExecutor {

    public CommandListener() {

    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) { //Kijkt als de gene die het commando stuurt geen speler is(we willen dat hij een speler is)
            sender.sendMessage(ChatColor.RED + "You have to be a player to execute this command!");
            return false; //We gaan niet verder met het uitvoeren van het commando omdat de sender geen speler is.
        }
        if (args == null) {
            sender.sendMessage(ChatColor.RED + "You have to supply at least one argument");
            return false;
        }

        Player p = (Player) sender; // We maken een speler variabel waarbij wij de sender een speler dwingen te zijn wat kan aangezien we hebben gecheckt of de sender een speler is.
        if (!p.hasPermission("Fastgm.use")) {
            p.sendMessage(ChatColor.RED + "you don't have permission to use this command");
            return false;
        }
        
        if (args.length >= 1) {
            if (args[0].equals("1")) {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.DARK_GRAY + "Gamemode set to creative"); 
                return false; 
            } else if (args[0].equals("0")) { 
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(ChatColor.DARK_GRAY + "Gamemode set to survival");
                return false; 
            } else if (args[0].equals("3")) { 
                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage(ChatColor.DARK_GRAY + "Gamemode set to spectator");
                return false;
            } else if (args[0].equalsIgnoreCase("help")) { 
                p.sendMessage(ChatColor.RED + "=-=-=-=" + ChatColor.GOLD + "FastGamemodeChanger" + ChatColor.RED + "=-=-=-=" + ChatColor.GREEN +"\n1. /gm 0 to change your gamemode to survival\n2. /gm 1 to change your gamemode to create\n3. /gm 2 to change your gamemode to adventure\n4. /gm 3 to change your gamemode to spectator\n5. /gm gui to open the gamemode changer gui\n6. gm info for the plugin infomation");                
                return false;
            } else if (args[0].equals("2")) { 
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(ChatColor.DARK_GRAY + "Gamemode set to adventure");
                return false; 
            } else if (args[0].equalsIgnoreCase("Info")) { 
                p.sendMessage(ChatColor.BLUE + "=-=-=-=" + ChatColor.DARK_RED + "FastGamemodeChanger" + ChatColor.BLUE 
                        +"=-=-=-=" + ChatColor.BLUE + "\nCreator:" + ChatColor.GREEN + "Croyke" + ChatColor.BLUE + "\nPoweredBy:" + ChatColor.GREEN + "MartyCraft (play.martycraft.net)"); 
                return false;                
            } else if (args[0].equalsIgnoreCase("gui")) { 
                        Inventory inventory = Bukkit.createInventory(null, 9, "FastGamemodeChanger");
                        p.openInventory(inventory);
                            ItemStack gamemodeS = new ItemStack(Material.DIAMOND_SWORD);
                            ItemMeta gamemetaS = gamemodeS.getItemMeta();
                            gamemetaS.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lGamemode Survival"));
                            ArrayList<String> sLore = new ArrayList<>();
                            sLore.add(ChatColor.AQUA.toString());
                            sLore.add(ChatColor.AQUA.toString());
                            sLore.add(ChatColor.translateAlternateColorCodes('&', "&7set gamemode to: &eSurvival"));
                            sLore.add(ChatColor.AQUA.toString());
                            gamemetaS.setLore(sLore);
                            gamemodeS.setItemMeta(gamemetaS);
        
                            ItemStack gamemodeC = new ItemStack(Material.BEDROCK);
                            ItemMeta gamemetaC = gamemodeC.getItemMeta();
                            gamemetaC.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lGamemode Creative"));
                            ArrayList<String> cLore = new ArrayList<>();
                            cLore.add(ChatColor.AQUA.toString());
                            cLore.add(ChatColor.AQUA.toString());
                            cLore.add(ChatColor.translateAlternateColorCodes('&', "&7Set gamemode to: &eCreative"));
                            cLore.add(ChatColor.AQUA.toString());
                            gamemetaC.setLore(cLore);
                            gamemodeC.setItemMeta(gamemetaC);
                            
                            ItemStack gamemodeA = new ItemStack(Material.LEATHER_CHESTPLATE);
                            ItemMeta gamemetaA = gamemodeA.getItemMeta();
                            gamemetaC.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lGamemode Adventure"));
                            ArrayList<String> ALore = new ArrayList<>();
                            ALore.add(ChatColor.AQUA.toString());
                            ALore.add(ChatColor.AQUA.toString());
                            ALore.add(ChatColor.translateAlternateColorCodes('&', "&7Set gamemode to: &eAdventure"));
                            ALore.add(ChatColor.AQUA.toString());
                            gamemetaA.setLore(ALore);
                            gamemodeA.setItemMeta(gamemetaA);
                            
                            ItemStack gamemodeSP = new ItemStack(Material.EYE_OF_ENDER);
                            ItemMeta gamemetaSP = gamemodeSP.getItemMeta();
                            gamemetaSP.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lGamemode Spectator"));
                            ArrayList<String> SPLore = new ArrayList<>();
                            SPLore.add(ChatColor.AQUA.toString());
                            SPLore.add(ChatColor.AQUA.toString());
                            SPLore.add(ChatColor.translateAlternateColorCodes('&', "&7Set gamemode to: &eSpectator"));
                            SPLore.add(ChatColor.AQUA.toString());
                            gamemetaSP.setLore(SPLore);
                            gamemodeSP.setItemMeta(gamemetaSP);
                            
                            ItemStack gamemodeQ = new ItemStack(Material.REDSTONE_BLOCK);
                            ItemMeta gamemetaQ = gamemodeC.getItemMeta();
                            gamemetaQ.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lQuit GUI"));
                            ArrayList<String> QLore = new ArrayList<>();
                            QLore.add(ChatColor.AQUA.toString());
                            QLore.add(ChatColor.AQUA.toString());
                            QLore.add(ChatColor.translateAlternateColorCodes('&', "&7Quites the gui"));
                            QLore.add(ChatColor.AQUA.toString());
                            gamemetaQ.setLore(QLore);
                            gamemodeQ.setItemMeta(gamemetaQ);
                            
                            inventory.setItem(1, gamemodeS);
                            inventory.setItem(3, gamemodeC);
                            inventory.setItem(5, gamemodeA);
                            inventory.setItem(7, gamemodeSP);
                            inventory.setItem(8, gamemodeQ);
                           
    }
            return false;
            } else { //Als hij geen van de bovenstaande keuzes heeft gekozen
                sender.sendMessage(ChatColor.DARK_RED + "Command not found, use /gm help for the commands.");
                return false;
            }
        
        }

    }



    
