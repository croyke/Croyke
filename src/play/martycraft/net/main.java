         /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package play.martycraft.net;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Calvin
 */
public class main extends JavaPlugin {


    @Override
    public void onEnable() {
        this.getCommand("gm").setExecutor(new CommandListener());
        this.getServer().getPluginManager().registerEvents((Listener) new TestListener(), this);
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "=-=-=-=FastGamemodeChanger=-=-=-=");
        Bukkit.getConsoleSender().sendMessage(ChatColor.MAGIC + "Is now activated");
        Bukkit.getConsoleSender().sendMessage(ChatColor.MAGIC + "Created By: Croyke");
        Bukkit.getConsoleSender().sendMessage(ChatColor.MAGIC + "Powered by: MartyCraft (play.martycraft.net)");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "=-=-=-=MartysEssentials=-=-=-=");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "=-=-=-=MartysEssentials=-=-=-=");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "Is now deactivated");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "Created By: Croyke");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "Powered by: MartyCraft (play.martycraft.net)");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "=-=-=-=MartysEssentials=-=-=-=");
    }
}
