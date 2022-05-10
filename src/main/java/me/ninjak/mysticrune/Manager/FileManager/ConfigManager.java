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
public class ConfigManager {
    private static MysticRune main = MysticRune.getPlugin(MysticRune.class);

    private static FileConfiguration config;
    private static File configFile;


    public static void configSetup() {
        if (!main.getDataFolder().exists()) {
            var startCreatingTime = System.currentTimeMillis();
            MysticRuneAPI.logInfo("&eStarting creating plugin folder...");
            main.getDataFolder().mkdir();
            MysticRuneAPI.logInfo(String.format("&aSuccess creating plugin folder in &6%s&a seconds",
                    (System.currentTimeMillis() - startCreatingTime) / 1000d));
            MysticRuneAPI.logInfo(" ");
        }

        configFile = new File(main.getDataFolder() + "/config.yml");


        if (configFile.exists()) {
            MysticRuneAPI.logInfo("&aSuccess load config file!");
        }


        if (!configFile.exists()) {
            var startCreatingTime = System.currentTimeMillis();
            MysticRuneAPI.logInfo("&eStarting creating config file...");
            main.saveResource("config.yml", false);
            MysticRuneAPI.logInfo(String.format("&aSuccess creating config file in &6%s&a seconds",
                    (System.currentTimeMillis() - startCreatingTime) / 1000d));
        }


        config = YamlConfiguration.loadConfiguration(configFile);
        MysticRuneAPI.logInfo("none:");
    }

    public static void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static File getConfigFile() {
        return configFile;
    }
    public static FileConfiguration getConfig() {
        return config;
    }
}
