package me.ninjak.mysticrune.Events;

import me.ninjak.mysticrune.API.MysticRuneAPI;
import me.ninjak.mysticrune.Inventory.PedestalInventory;
import me.ninjak.mysticrune.Manager.FileManager.RunesFileManager;
import me.ninjak.mysticrune.Manager.RuneManager;
import me.ninjak.mysticrune.MysticRune;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

/**
 * @author David (_Ninjak)
 * @project MysticRune
 * @date 5/13/2022
 */
public class InventoryCloseListener implements Listener {

    private static ItemStack newItemOne;
    private static ItemStack newItemTwo;

    private static FileConfiguration runeConfig = RunesFileManager.getRuneConfig();

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        var inventory = event.getInventory();
        var inventoryName = PedestalInventory.inventoryName;
        var player = event.getPlayer();

        if (event.getView().getTitle().equalsIgnoreCase(inventoryName)) {
            player.sendMessage("test");

            var itemOne = inventory.getItem(19);
            var itemTwo = inventory.getItem(25);



            if (itemOne == null && itemTwo == null) {
                return;
            }

            if (itemOne != null && itemTwo == null) {
                if (itemOne.getItemMeta().getLore() == null) {
                    if(player.getInventory().firstEmpty() == -1){
                        var world = player.getWorld();
                        world.dropItemNaturally(player.getLocation(), itemOne);
                        return;
                    }
                    player.getInventory().addItem(itemOne);
                    return;
                }

                if (itemOne.getType() == Material.PLAYER_HEAD) {
                    var ItemOneLore = itemOne.getItemMeta().getLore().get(2);
                    var runeName = ItemOneLore.replaceAll(MysticRuneAPI.fixColor("&8"), "");
                    if (runeConfig.get("Runes." + runeName) == null) {
                        return;
                    }
                    if(player.getInventory().firstEmpty() == -1){
                        var world = player.getWorld();
                        world.dropItemNaturally(player.getLocation(), RuneManager.getRune(runeName));
                        return;
                    }
                    player.getInventory().addItem(RuneManager.getRune(runeName));
                    return;
                } else {
                    newItemOne = new ItemStack(itemOne.getType(), itemOne.getAmount());
                }


                newItemOne.setDurability(itemOne.getDurability());
                var itemOneMeta = newItemOne.getItemMeta();
                itemOneMeta.setDisplayName(MysticRuneAPI.fixColor(itemOne.getItemMeta().getDisplayName()));
                ArrayList<String> addLore = new ArrayList<>();
                var lore = itemOne.getItemMeta().getLore();
                for (String lores : lore) {
                    addLore.add(MysticRuneAPI.fixColor(lores));
                }
                itemOneMeta.setLore(addLore);
                newItemOne.setItemMeta(itemOneMeta);
                player.getInventory().addItem(newItemOne);
                return;
            }

            if (itemOne == null && itemTwo != null) {
                if (itemTwo.getItemMeta().getLore() == null) {
                    if(player.getInventory().firstEmpty() == -1){
                        var world = player.getWorld();
                        world.dropItemNaturally(player.getLocation(), itemTwo);
                        return;
                    }
                    player.getInventory().addItem(itemTwo);
                    return;
                }
                if (itemTwo.getType() == Material.PLAYER_HEAD) {
                    var ItemTwoLore = itemTwo.getItemMeta().getLore().get(2);
                    var runeName = ItemTwoLore.replaceAll(MysticRuneAPI.fixColor("&8"), "");
                    if (runeConfig.get("Runes." + runeName) == null) {
                        return;
                    }
                    if(player.getInventory().firstEmpty() == -1){
                        var world = player.getWorld();
                        world.dropItemNaturally(player.getLocation(), RuneManager.getRune(runeName));
                        return;
                    }
                    player.getInventory().addItem(RuneManager.getRune(runeName));
                    return;
                } else {
                    newItemTwo = new ItemStack(itemTwo.getType(), itemTwo.getAmount());
                }
                newItemTwo.setDurability(itemTwo.getDurability());
                var itemTwoMeta = newItemTwo.getItemMeta();
                itemTwoMeta.setDisplayName(MysticRuneAPI.fixColor(itemTwo.getItemMeta().getDisplayName()));
                ArrayList<String> addLoreTwo = new ArrayList<>();
                var loretwo = itemTwo.getItemMeta().getLore();
                for (String lores : loretwo) {
                    addLoreTwo.add(MysticRuneAPI.fixColor(lores));
                }
                itemTwoMeta.setLore(addLoreTwo);
                newItemTwo.setItemMeta(itemTwoMeta);
                player.getInventory().addItem(newItemTwo);
                return;
            }

            if (itemOne != null && itemTwo != null) {
                if (itemOne.getItemMeta().getLore() == null) {

                    if (itemTwo.getItemMeta().getLore() == null) {
                        if(player.getInventory().firstEmpty() == -1){
                            var world = player.getWorld();
                            world.dropItemNaturally(player.getLocation(), itemOne);
                            world.dropItemNaturally(player.getLocation(), itemTwo);
                            return;
                        }
                        player.getInventory().addItem(itemOne);
                        player.getInventory().addItem(itemTwo);
                        return;
                    }
                    return;
                }
                if (itemOne.getType() == Material.PLAYER_HEAD) {

                    var ItemOneLore = itemOne.getItemMeta().getLore().get(2);
                    var runeName = ItemOneLore.replaceAll(MysticRuneAPI.fixColor("&8"), "");
                    if (runeConfig.get("Runes." + runeName) == null) {
                        return;
                    }

                    if (itemTwo.getType() == Material.PLAYER_HEAD) {
                        var ItemTwoLore = itemTwo.getItemMeta().getLore().get(2);
                        var runeNameTwo = ItemTwoLore.replaceAll(MysticRuneAPI.fixColor("&8"), "");
                        if (runeConfig.get("Runes." + runeNameTwo) == null) {
                            return;
                        }
                        if(player.getInventory().firstEmpty() == -1){
                            var world = player.getWorld();
                            world.dropItemNaturally(player.getLocation(), RuneManager.getRune(runeName));
                            world.dropItemNaturally(player.getLocation(), RuneManager.getRune(runeNameTwo));
                            return;
                        }

                        player.getInventory().addItem(RuneManager.getRune(runeNameTwo));


                        return;
                    } else {
                        newItemOne = new ItemStack(itemOne.getType(), itemOne.getAmount());
                    }
                    return;
                } else {
                    newItemOne = new ItemStack(itemOne.getType(), itemOne.getAmount());
                }


                newItemOne.setDurability(itemOne.getDurability());
                var itemOneMeta = newItemOne.getItemMeta();
                itemOneMeta.setDisplayName(MysticRuneAPI.fixColor(itemOne.getItemMeta().getDisplayName()));
                ArrayList<String> addLore = new ArrayList<>();
                var lore = itemOne.getItemMeta().getLore();
                for (String lores : lore) {
                    addLore.add(MysticRuneAPI.fixColor(lores));
                }
                itemOneMeta.setLore(addLore);
                newItemOne.setItemMeta(itemOneMeta);
                player.getInventory().addItem(newItemOne);


                newItemTwo.setDurability(itemTwo.getDurability());
                var itemTwoMeta = newItemTwo.getItemMeta();
                itemTwoMeta.setDisplayName(MysticRuneAPI.fixColor(itemTwo.getItemMeta().getDisplayName()));
                ArrayList<String> addLoreTwo = new ArrayList<>();
                var loretwo = itemTwo.getItemMeta().getLore();
                for (String lores : loretwo) {
                    addLoreTwo.add(MysticRuneAPI.fixColor(lores));
                }
                itemTwoMeta.setLore(addLoreTwo);
                newItemTwo.setItemMeta(itemTwoMeta);
                player.getInventory().addItem(newItemTwo);

                return;
            }

            player.closeInventory();


        }
    }
}
