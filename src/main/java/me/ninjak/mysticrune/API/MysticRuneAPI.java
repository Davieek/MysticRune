package me.ninjak.mysticrune.API;

import me.ninjak.mysticrune.Manager.FileManager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author David (_Ninjak)
 * @project MysticRune
 * @date 5/10/2022
 */
public class MysticRuneAPI {
    public static String fixColor(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static ItemStack createHead(String value) {
        var skull = new ItemStack(Material.PLAYER_HEAD);
        UUID hashAsId = new UUID(value.hashCode(), value.hashCode());
        return Bukkit.getUnsafe().modifyItemStack(skull,
                "{SkullOwner:{Id:\"" + hashAsId + "\",Properties:{textures:[{Value:\"" + value + "\"}]}}}"
        );
    }

    public static void createRune(String name, ArrayList<String> loreList, String vaule ) {
        var rune = createHead(vaule);
        var runeMeta = rune.getItemMeta();
        runeMeta.setDisplayName(fixColor(name));
        ArrayList<String> lores = new ArrayList<>();
        for (String lore : loreList) {
            lores.add(fixColor(lore));
        }
        runeMeta.setLore(lores);
        rune.setItemMeta(runeMeta);
    }

    public static void logInfo(String message) {
        if (message.equalsIgnoreCase(" ")) {
            Bukkit.getConsoleSender().sendMessage(fixColor(message));
            return;
        }
        Bukkit.getConsoleSender().sendMessage(fixColor("&8[&6ϟ&8] "+message));
    }

    public static void playerSendMessage(Player player, String message) {
        var config = ConfigManager.config;
        var prefix = config.getString("prefix");

        player.sendMessage(fixColor(prefix + " " + message));

    }

}
