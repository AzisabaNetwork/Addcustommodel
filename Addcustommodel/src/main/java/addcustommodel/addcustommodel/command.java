package addcustommodel.addcustommodel;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class command implements CommandExecutor {

    private final Addcustommodel plugin;

    public command(Addcustommodel custommodel){
        this.plugin = custommodel;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("addcustommodel") || cmd.getName().equalsIgnoreCase("acm")) {
            if (!sender.hasPermission("Addcustommodel.command.tex")) {
                sender.sendMessage("コマンドを実行出来る権限がありません。");
                return true;
            }
            if (args.length <= 0) {
                sender.sendMessage("コマンドを正しく入力してください");
                return false;
            }
            try {
                ItemStack item = p.getInventory().getItemInMainHand();
                ItemMeta meta = item.getItemMeta();
                String target = args[0];
                int id = Integer.parseInt(target);
                assert meta != null;
                meta.setCustomModelData(id);
                item.setItemMeta(meta);
                p.sendMessage("カスタムモデルデータ値を" + id + "に設定しました");
                return true;
            } catch (NullPointerException | NumberFormatException e) {
                return true;
            }
        }
        if (cmd.getName().equalsIgnoreCase("getcustommodel") || cmd.getName().equalsIgnoreCase("gcm")) {
            if (!sender.hasPermission("Addcustommodel.command.tex")) {
                sender.sendMessage("コマンドを実行出来る権限がありません。");
                return true;
            }
            ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.AIR) return false;
            ItemMeta meta = item.getItemMeta();
            if (!meta.hasCustomModelData()) {
                return false;
            }
            int id = meta.getCustomModelData();
            p.sendMessage("カスタムモデルデータ値は" + id + "です");
            return true;
        }
        return true;
    }
}
