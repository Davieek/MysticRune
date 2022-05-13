package me.ninjak.mysticrune.Events;

import me.ninjak.mysticrune.Inventory.PedestalInventory;
import me.ninjak.mysticrune.Manager.FileManager.ConfigManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * @author David (_Ninjak)
 * @project MysticRune
 * @date 5/13/2022
 */
public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        var player = (Player) event.getWhoClicked();
        var inventory = event.getInventory();
        var inventoryName = PedestalInventory.inventoryName;

        var config = ConfigManager.getConfig();

        if (event.getView().getTitle().equalsIgnoreCase(inventoryName)) {
            for (int size = 0 ; size < inventory.getSize() ; size++) {
                if ((event.getRawSlot() == 19) ||
                        (event.getRawSlot() == 25)) {
                    event.setCancelled(false);
                    return;
                }
                if ((event.getRawSlot() == 31)) {
                    if (event.getCurrentItem().getType() == Material.BARRIER) {
                        event.setCancelled(true);
                        return;
                    }
                    event.setCancelled(false);
                    return;
                }
                if (event.getRawSlot() == size) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
