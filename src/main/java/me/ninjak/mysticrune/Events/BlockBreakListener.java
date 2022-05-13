package me.ninjak.mysticrune.Events;

import me.ninjak.mysticrune.Manager.FileManager.RunesFileManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * @author David (_Ninjak)
 * @project MysticRune
 * @date 5/12/2022
 */
public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        var player = event.getPlayer();
        var block = event.getBlock();

        var runeConfig = RunesFileManager.getRuneConfig();



    }
}
