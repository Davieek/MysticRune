package me.ninjak.mysticrune.Manager;

import me.ninjak.mysticrune.API.MysticRuneAPI;
import me.ninjak.mysticrune.Manager.FileManager.ConfigManager;
import me.ninjak.mysticrune.Manager.FileManager.RunesFileManager;
import me.ninjak.mysticrune.MysticRune;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David (_Ninjak)
 * @project MysticRune
 * @date 5/12/2022
 */
public class RuneManager {
    private static MysticRune main = MysticRune.getPlugin(MysticRune.class);

    public static ItemStack getRune(String name) {
        var runesConfig = RunesFileManager.getRuneConfig();
        var runeName = runesConfig.getString("Runes." + name + ".name");
        var runeLore = runesConfig.getList("Runes." + name + ".name");
        var runeHeadValue = runesConfig.getString("Runes." + name + ".headValue");

        assert runeHeadValue != null;

        var item = MysticRuneAPI.createHead(runeHeadValue);
        var meta =  item.getItemMeta();
        meta.setDisplayName(MysticRuneAPI.fixColor(runeName));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(MysticRuneAPI.fixColor(""));
        return null;
    }

}
