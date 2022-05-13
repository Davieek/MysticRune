package me.ninjak.mysticrune;

import me.ninjak.mysticrune.API.MysticRuneAPI;
import me.ninjak.mysticrune.Commands.GiveRuneCommand;
import me.ninjak.mysticrune.Events.BlockBreakListener;
import me.ninjak.mysticrune.Events.BlockPlaceListener;
import me.ninjak.mysticrune.Events.InventoryClickListener;
import me.ninjak.mysticrune.Events.InventoryCloseListener;
import me.ninjak.mysticrune.Manager.FileManager.ConfigManager;
import me.ninjak.mysticrune.Manager.FileManager.LanguageManager;
import me.ninjak.mysticrune.Manager.FileManager.RunesFileManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MysticRune extends JavaPlugin {

    @Override
    public void onEnable() {
        var disablePlugin = this.getConfig().getBoolean("disablePlugin");

        MysticRuneAPI.enableMessage();


        if (disablePlugin == true) {
            MysticRuneAPI.logInfo("warn:&cPLUGIN DISABLE");
            MysticRuneAPI.logInfo("warn:&cif you want to enable the plugin, go to the config.yml file and change the value in disablePlugin");
            this.getPluginLoader().disablePlugin(this);
            return;
        }

        MysticRuneAPI.logInfo("&eStarting plugin loading...");
        MysticRuneAPI.logInfo("none:");
        var startingTime = System.currentTimeMillis();
        MysticRuneAPI.logInfo("&eLoading config file...");
        ConfigManager.configSetup();
        ConfigManager.saveConfig();
        MysticRuneAPI.logInfo("&eLoading runes file...");
        RunesFileManager.runeConfigSetup();
        RunesFileManager.saveConfig();
        MysticRuneAPI.logInfo("&eLoading language file...");
        LanguageManager.setup();
        LanguageManager.saveConfig();

        getCommand("test").setExecutor(new GiveRuneCommand());
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryCloseListener(), this);




        MysticRuneAPI.logInfo(String.format("&aSuccess load plugin in &6%s&a seconds",
                (System.currentTimeMillis() - startingTime) / 1000d));


    }

    @Override
    public void onDisable() {

    }


}
