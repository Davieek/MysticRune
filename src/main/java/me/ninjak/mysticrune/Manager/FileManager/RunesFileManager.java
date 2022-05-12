package me.ninjak.mysticrune.Manager.FileManager;

import me.ninjak.mysticrune.API.MysticRuneAPI;
import me.ninjak.mysticrune.MysticRune;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * @author David (_Ninjak)
 * @project MysticRune
 * @date 5/10/2022
 */
public class RunesFileManager {
    private static MysticRune main = MysticRune.getPlugin(MysticRune.class);

    private static FileConfiguration runeConfig;
    private static File runeFile;


    public static void runeConfigSetup() {
        if (!main.getDataFolder().exists()) {
            var startCreatingTime = System.currentTimeMillis();
            MysticRuneAPI.logInfo("&eStarting creating plugin folder...");
            main.getDataFolder().mkdir();
            MysticRuneAPI.logInfo(String.format("&aSuccess creating plugin folder in &6%s&a seconds",
                    (System.currentTimeMillis() - startCreatingTime) / 1000d));
        }

        runeFile = new File(main.getDataFolder() + "/runes.yml");

        if (runeFile.exists()) {
            MysticRuneAPI.logInfo("&aSuccess load runes file!");
        }

        if (!runeFile.exists()) {
            var startCreatingTime = System.currentTimeMillis();
            MysticRuneAPI.logInfo("&eStarting creating runes file...");
            main.saveResource("runes.yml", false);
            MysticRuneAPI.logInfo(String.format("&aSuccess creating runes file in &6%s&a seconds",
                    (System.currentTimeMillis() - startCreatingTime) / 1000d));
        }

        runeConfig = YamlConfiguration.loadConfiguration(runeFile);
        MysticRuneAPI.logInfo("none:");
    }

    public static void saveConfig() {
        try {
            runeConfig.save(runeFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getRuneFile() {
        return runeFile;
    }
    public static FileConfiguration getRuneConfig() {
        return runeConfig;
    }
}
