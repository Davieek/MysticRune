package me.ninjak.mysticrune.Commands;

import me.ninjak.mysticrune.API.MysticRuneAPI;
import me.ninjak.mysticrune.Inventory.PedestalInventory;
import me.ninjak.mysticrune.Inventory.setupRuneInventory;
import me.ninjak.mysticrune.Manager.FileManager.RunesFileManager;
import me.ninjak.mysticrune.Manager.RuneManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.module.Configuration;
import java.util.List;

/**
 * @author David (_Ninjak)
 * @project MysticRune
 * @date 5/12/2022
 */
public class GiveRuneCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            MysticRuneAPI.logInfo("&cConsole not execute this command!");
            return true;
        }

        if (command.getName().equalsIgnoreCase("test")) {
            var player = (Player) sender;
            var runesConfig = RunesFileManager.getRuneConfig();
            var runeList = RunesFileManager.getRuneConfig().getConfigurationSection("Runes").getKeys(false);

            assert runeList != null;
            if (!runeList.contains(args[0])) {
                player.sendMessage("nie ma takiej runy");
                return true;
                
            }

            //player.getInventory().addItem(RuneManager.getRune(args[0]));
            PedestalInventory.openPedestal(player);




        }


        return false;
    }
}
