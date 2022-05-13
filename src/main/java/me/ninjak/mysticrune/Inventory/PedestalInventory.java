package me.ninjak.mysticrune.Inventory;

import me.ninjak.mysticrune.API.MysticRuneAPI;
import me.ninjak.mysticrune.Manager.FileManager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

/**
 * @author David (_Ninjak)
 * @project MysticRune
 * @date 5/13/2022
 */
public class PedestalInventory {

    private static String inventoryName;


    private static ItemStack createItem(Material material, String name, ArrayList<String> lores) {
        var item = new ItemStack(material);
        var meta = item.getItemMeta();
        meta.setDisplayName(MysticRuneAPI.fixColor(name));
        ArrayList<String> addlores = new ArrayList<>();
        for (String lore : lores) {
            addlores.add(MysticRuneAPI.fixColor(lore));
        }
        meta.setLore(addlores);
        item.setItemMeta(meta);
        return item;
    }

    public static void openPedestal(Player player) {
        var config = ConfigManager.getConfig();

        if (config.getString("language").equalsIgnoreCase("PL")) {
            inventoryName = MysticRuneAPI.fixColor("&dMistyczny piedestał");
        }

        if (config.getString("language").equalsIgnoreCase("EN")) {
            inventoryName = MysticRuneAPI.fixColor("&dMystic pedestal");
        }

        var inventory = Bukkit.createInventory(player, 54, inventoryName);

        for (int i = 0 ; i < inventory.getSize() ; i++) {
            ArrayList<String> lore = new ArrayList<>();
            lore.add(" ");
            inventory.setItem(i, createItem(Material.WHITE_STAINED_GLASS_PANE, " ", lore));
        }
    }
}
