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

    public static boolean checkCrafting;

    public static String inventoryName;

    private static String exitName;

    private static String pedestalName;

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
    private static ItemStack createExit() {
        var item = MysticRuneAPI.createHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmViNTg4YjIxYTZmOThhZDFmZjRlMDg1YzU1MmRjYjA1MGVmYzljYWI0MjdmNDYwNDhmMThmYzgwMzQ3NWY3In19fQ==");
        var meta = item.getItemMeta();
        meta.setDisplayName(MysticRuneAPI.fixColor(exitName));
        ArrayList<String> addlores = new ArrayList<>();
        addlores.add(MysticRuneAPI.fixColor(" "));
        meta.setLore(addlores);
        item.setItemMeta(meta);
        return item;
    }

    public static void openPedestal(Player player) {
        var config = ConfigManager.getConfig();

        ArrayList<String> lores = new ArrayList<>();
        lores.add(" ");

        if (config.getString("language").equalsIgnoreCase("PL")) {
            inventoryName = MysticRuneAPI.fixColor("&8Mistyczny piedestał");
            exitName = MysticRuneAPI.fixColor("&c&lWYJŚCIE!");
            pedestalName = MysticRuneAPI.fixColor("&6&lMistyczny Piedestał");
        }

        if (config.getString("language").equalsIgnoreCase("EN")) {
            inventoryName = MysticRuneAPI.fixColor("&8Mystic pedestal");
            exitName = MysticRuneAPI.fixColor("&c&lEXIT!");
            pedestalName = MysticRuneAPI.fixColor("&6&lMystic pedestal");
        }

        var inventory = Bukkit.createInventory(player, 54, inventoryName);

        for (int i = 0 ; i < inventory.getSize() ; i++) {
            ArrayList<String> lore = new ArrayList<>();
            lore.add(" ");
            inventory.setItem(i, createItem(Material.GRAY_STAINED_GLASS_PANE, " ", lore));
        }
        inventory.setItem(10, createItem(Material.WHITE_STAINED_GLASS_PANE, " ", lores));
        inventory.setItem(11, createItem(Material.WHITE_STAINED_GLASS_PANE, " ", lores));
        inventory.setItem(12, createItem(Material.WHITE_STAINED_GLASS_PANE, " ", lores));

        inventory.setItem(13, createItem(Material.LODESTONE, pedestalName, lores));

        inventory.setItem(14, createItem(Material.WHITE_STAINED_GLASS_PANE, " ", lores));
        inventory.setItem(15, createItem(Material.WHITE_STAINED_GLASS_PANE, " ", lores));
        inventory.setItem(16, createItem(Material.WHITE_STAINED_GLASS_PANE, " ", lores));

        inventory.setItem(19, new ItemStack(Material.AIR));
        inventory.setItem(25, new ItemStack(Material.AIR));

        inventory.setItem(22, createItem(Material.GREEN_STAINED_GLASS_PANE, " ", lores));

        if (checkCrafting) {
            inventory.setItem(22, createItem(Material.GREEN_STAINED_GLASS_PANE, " ", lores));
        }

        if (!checkCrafting) {
            inventory.setItem(22, createItem(Material.RED_STAINED_GLASS_PANE, " ", lores));
        }

        inventory.setItem(31, createItem(Material.BARRIER, " ", lores));

        inventory.setItem(45, createItem(Material.WHITE_STAINED_GLASS_PANE, " ", lores));
        inventory.setItem(46, createItem(Material.WHITE_STAINED_GLASS_PANE, " ", lores));
        inventory.setItem(47, createItem(Material.WHITE_STAINED_GLASS_PANE, " ", lores));
        inventory.setItem(48, createItem(Material.WHITE_STAINED_GLASS_PANE, " ", lores));

        inventory.setItem(49, createExit());

        inventory.setItem(50, createItem(Material.WHITE_STAINED_GLASS_PANE, " ", lores));
        inventory.setItem(51, createItem(Material.WHITE_STAINED_GLASS_PANE, " ", lores));
        inventory.setItem(52, createItem(Material.WHITE_STAINED_GLASS_PANE, " ", lores));
        inventory.setItem(53, createItem(Material.WHITE_STAINED_GLASS_PANE, " ", lores));

        player.openInventory(inventory);
    }
}
