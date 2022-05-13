package me.ninjak.mysticrune.Manager;

import me.ninjak.mysticrune.API.MysticRuneAPI;
import me.ninjak.mysticrune.Manager.FileManager.ConfigManager;
import me.ninjak.mysticrune.Manager.FileManager.RunesFileManager;
import me.ninjak.mysticrune.MysticRune;
import org.bukkit.entity.Player;
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
        var config = ConfigManager.getConfig();

        var runesConfig = RunesFileManager.getRuneConfig();

        var runeName = runesConfig.getString("Runes." + name + ".name");
        var runeLore = (List<String>) runesConfig.getList("Runes." + name + ".lore");
        var runeHeadValue = runesConfig.getString("Runes." + name + ".headValue");
        var runeRarity = runesConfig.getString("Runes." + name + ".runeRarity");
        var runeItem = runesConfig.getString("Runes." + name + ".runeOnItem");

        assert runeHeadValue != null;

        var item = MysticRuneAPI.createHead(runeHeadValue);
        var meta =  item.getItemMeta();
        meta.setDisplayName(MysticRuneAPI.fixColor(runeName));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(MysticRuneAPI.fixColor("&8MysticRune"));
        lore.add(MysticRuneAPI.fixColor("&r&5&m  &r&d&m &r       &r&d&m &r&5&m  "));
        lore.add(MysticRuneAPI.fixColor("&8"+name));

        if (config.getString("language").equalsIgnoreCase("EN")) {
            lore.add(MysticRuneAPI.fixColor("&8Rune on: " + runeItem));

        }

        if (config.getString("language").equalsIgnoreCase("PL")) {
            if (runeItem.equalsIgnoreCase("pickaxe")) {
                lore.add(MysticRuneAPI.fixColor("&8Runa na: kilof"));
            }
            if (runeItem.equalsIgnoreCase("axe")) {
                lore.add(MysticRuneAPI.fixColor("&8Runa na: siekiera"));
            }
            if (runeItem.equalsIgnoreCase("sword")) {
                lore.add(MysticRuneAPI.fixColor("&8Runa na: miecz"));
            }
        }

        lore.add(MysticRuneAPI.fixColor(" "));

        for (String lores : runeLore) {
            lore.add(MysticRuneAPI.fixColor(lores));
        }

        lore.add(MysticRuneAPI.fixColor(""));

        if (runeRarity.equalsIgnoreCase("common")) {
            lore.add(MysticRuneAPI.fixColor("&f&l" + runeRarity));
        }
        if (runeRarity.equalsIgnoreCase("uncommon")) {
            lore.add(MysticRuneAPI.fixColor("&a&l" + runeRarity));
        }
        if (runeRarity.equalsIgnoreCase("rare")) {
            lore.add(MysticRuneAPI.fixColor("&9&l" + runeRarity));
        }
        if (runeRarity.equalsIgnoreCase("epic")) {
            lore.add(MysticRuneAPI.fixColor("&5&l" + runeRarity));
        }
        if (runeRarity.equalsIgnoreCase("legendary")) {
            lore.add(MysticRuneAPI.fixColor("&6&l" + runeRarity));
        }
        if (runeRarity.equalsIgnoreCase("mythic")) {
            lore.add(MysticRuneAPI.fixColor("&d&l" + runeRarity));
        }
        if (runeRarity.equalsIgnoreCase("special")) {
            lore.add(MysticRuneAPI.fixColor("&c&l" + runeRarity));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

}
