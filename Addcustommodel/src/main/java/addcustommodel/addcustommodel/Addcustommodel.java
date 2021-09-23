package addcustommodel.addcustommodel;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Addcustommodel extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getCommand("acm").setExecutor(new command(this));
        getCommand("gcm").setExecutor(new command(this));
        getCommand("macm").setExecutor(new command(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
