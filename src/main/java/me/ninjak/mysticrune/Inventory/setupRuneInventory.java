package me.ninjak.mysticrune.Inventory;

import me.ninjak.mysticrune.API.MysticRuneAPI;
import me.ninjak.mysticrune.Manager.FileManager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

/**
 * @author David (_Ninjak)
 * @project MysticRune
 * @date 5/13/2022
 */
public class setupRuneInventory {

    private static String nextName;



    private static String selectRuneInvName;



    private static ItemStack createItem(Material material, String name, ArrayList <String> lores) {
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
    private static ItemStack createNext() {
        var item = MysticRuneAPI.createHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmViNTg4YjIxYTZmOThhZDFmZjRlMDg1YzU1MmRjYjA1MGVmYzljYWI0MjdmNDYwNDhmMThmYzgwMzQ3NWY3In19fQ==");
        var meta = item.getItemMeta();
        meta.setDisplayName(MysticRuneAPI.fixColor(nextName));
        ArrayList<String> addlores = new ArrayList<>();
        addlores.add(MysticRuneAPI.fixColor(" "));
        meta.setLore(addlores);
        item.setItemMeta(meta);
        return item;
    }


    public static void selectRuneInventory(Player player) {
        var config = ConfigManager.getConfig();
        if (config.getString("language").equalsIgnoreCase("PL")) {
            selectRuneInvName = MysticRuneAPI.fixColor("&8Wybierz wygląd runy");
            nextName = MysticRuneAPI.fixColor("&a&lDALEJ!");
        }

        if (config.getString("language").equalsIgnoreCase("EN")) {
            selectRuneInvName = MysticRuneAPI.fixColor("&8Choose the appearance of the rune");
            nextName = MysticRuneAPI.fixColor("&a&lNEXT!");
        }

        var inventory = Bukkit.createInventory(player, 54, selectRuneInvName);

        for (int size = 0; size < inventory.getSize() ; size++) {
            ArrayList<String> lore = new ArrayList<>();
            lore.add(" ");
            inventory.setItem(size, createItem(Material.GRAY_STAINED_GLASS_PANE, " ", lore));
        }

        player.openInventory(inventory);

    }
}
