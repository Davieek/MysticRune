package me.ninjak.mysticrune.Manager.FileManager;

import me.ninjak.mysticrune.API.MysticRuneAPI;
import me.ninjak.mysticrune.MysticRune;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * @author David (_Ninjak)
 * @project MysticRune
 * @date 5/12/2022
 */
public class LanguageManager {

    private static MysticRune main = MysticRune.getPlugin(MysticRune.class);

    public static FileConfiguration languagePL;
    public static FileConfiguration languageEN;
    public static File languageFilePL;
    public static File languageFileEN;

    private static Object language2 = ConfigManager.getConfig().get("language");


    public static File lanFile;
    public static FileConfiguration lan;


    public static void setup() {
        var console = Bukkit.getConsoleSender();

        languageFilePL = new File(main.getDataFolder() + "/Language/language_PL.yml");

        if (!languageFilePL.exists()) {
            var startCreatingTime = System.currentTimeMillis();
            MysticRuneAPI.logInfo("&eStarting creating (PL) language file...");
            main.saveResource("Language/language_PL.yml", false);
            MysticRuneAPI.logInfo(String.format("&aSuccess creating (PL) language file in &6%s&a seconds",
                    (System.currentTimeMillis() - startCreatingTime) / 1000d));
        }

        if (languageFilePL.exists()) {
            MysticRuneAPI.logInfo("&aSuccess load (PL) language file!");
        }

        languagePL = YamlConfiguration.loadConfiguration(languageFilePL);

        languageFileEN = new File(main.getDataFolder() + "/Language/language_EN.yml");

        if (!languageFileEN.exists()) {
            var startCreatingTime = System.currentTimeMillis();
            MysticRuneAPI.logInfo("&eStarting creating (EN) language file...");
            main.saveResource("Language/language_EN.yml", false);
            MysticRuneAPI.logInfo(String.format("&aSuccess creating (EN) language file in &6%s&a seconds",
                    (System.currentTimeMillis() - startCreatingTime) / 1000d));
        }

        if (languageFileEN.exists()) {
            MysticRuneAPI.logInfo("&aSuccess load (PL) language file!");
        }
        languageEN = YamlConfiguration.loadConfiguration(languageFileEN);

        lanFile = new File(main.getDataFolder() + "/language/language_"+language2+".yml");


        if (!lanFile.exists()) {
            var config = ConfigManager.getConfig();
            config.set("config.Language", "EN");
            ConfigManager.saveConfig();
            YamlConfiguration.loadConfiguration(lanFile);
            MysticRuneAPI.logInfo("error:&clanguage file " + lanFile.getName() + " do not exist");
        }
        lan = YamlConfiguration.loadConfiguration(lanFile);



        MysticRuneAPI.logInfo("none:");



    }

    public static void saveConfig() {
        try {
            languageEN.save(languageFileEN);
            languagePL.save(languageFilePL);
            lan.save(lanFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
