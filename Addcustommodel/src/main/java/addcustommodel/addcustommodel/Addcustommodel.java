package addcustommodel.addcustommodel;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class Addcustommodel extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getCommand("addcustommodel").setExecutor(new command(this));
        getCommand("acm").setExecutor(new command(this));
        getCommand("getcustommodel").setExecutor(new command(this));
        getCommand("gcm").setExecutor(new command(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onEntityInv(InventoryOpenEvent e){
        if (e.getInventory() instanceof MerchantInventory){
            e.setCancelled(true);
        }
    }
}
