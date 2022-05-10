package me.ninjak.mysticrune;

import me.ninjak.mysticrune.API.MysticRuneAPI;
import me.ninjak.mysticrune.Manager.FileManager.ConfigManager;
import me.ninjak.mysticrune.Manager.FileManager.RunesFileManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MysticRune extends JavaPlugin {

    @Override
    public void onEnable() {
        var config = ConfigManager.config;
        var disablePlugin = config.getBoolean("");

        if (!disablePlugin) {
            MysticRuneAPI.logInfo("&cPLUGIN DISABLE");
            MysticRuneAPI.logInfo("&if you want to enable the plugin, go to the config.yml file and change the value in disablePlugin");
            this.getPluginLoader().disablePlugin(this);
            return;
        }


        MysticRuneAPI.logInfo("&eStarting plugin loading...");
        MysticRuneAPI.logInfo(" ");
        var startingTime = System.currentTimeMillis();
        MysticRuneAPI.logInfo("&eLoading config file...");
        ConfigManager.configSetup();
        ConfigManager.saveConfig();
        MysticRuneAPI.logInfo("&eLoading runes file...");
        RunesFileManager.runeConfigSetup();
        RunesFileManager.saveConfig();
        MysticRuneAPI.logInfo(String.format("&aSuccess load plugin in &6%s&a seconds",
                (System.currentTimeMillis() - startingTime) / 1000d));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
