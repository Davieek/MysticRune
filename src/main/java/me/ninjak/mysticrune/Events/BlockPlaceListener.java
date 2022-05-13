package me.ninjak.mysticrune.Events;

import me.ninjak.mysticrune.API.MysticRuneAPI;
import me.ninjak.mysticrune.Manager.FileManager.RunesFileManager;
import me.ninjak.mysticrune.MysticRune;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.HashMap;

/**
 * @author David (_Ninjak)
 * @project MysticRune
 * @date 5/12/2022
 */
public class BlockPlaceListener implements Listener {

    private static HashMap<String, Long> messageTime = new HashMap<>();

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        var player = event.getPlayer();

        if (player.getInventory().getItemInMainHand() == null) {
            return;
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getLore() == null) {
            return;
        }

        var runeName = player.getInventory().getItemInMainHand().getItemMeta().getLore().get(0);

        if (runeName.equalsIgnoreCase(MysticRuneAPI.fixColor("&8MysticRune"))) {
            event.setCancelled(true);
            if (messageTime.containsKey(player.getName())) {
                long oldTime = messageTime.get(player.getName());
                long newTime = System.currentTimeMillis();
                if ((newTime - oldTime) > (3 * 500)) {
                    messageTime.remove(player.getName());
                }
            } else {
                messageTime.put(player.getName(), System.currentTimeMillis());
                MysticRuneAPI.playerSendMessage(player, "&cNie możesz stawiać run na ziemi!");
            }

        }

    }
}
