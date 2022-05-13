package me.ninjak.mysticrune.API;

import org.bukkit.entity.Mob;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David (_Ninjak)
 * @project MysticRune
 * @date 5/12/2022
 */
public class RunesAPI {

    private static String runeName;
    private static String runeHeadValue;
    private static String runeEffect;
    private static String runeCustomEffect;
    private static ItemStack runeItem;
    private static int buyCost;
    private static String runeRarity;
    private static ArrayList<String> lore;


    public static void addRune(String runeName, String runeHeadValue, String runeEffect, String runeCustomEffect, ItemStack runeItem, int buyCost, String runeRarity, ArrayList<String> lore) {
        RunesAPI.runeName = runeName;
        RunesAPI.runeHeadValue = runeHeadValue;
        RunesAPI.runeEffect = runeEffect;
        RunesAPI.runeCustomEffect = runeCustomEffect;
        RunesAPI.runeItem = runeItem;
        RunesAPI.buyCost = buyCost;
        RunesAPI.runeRarity = runeRarity;
        RunesAPI.lore = lore;
    }


    public static String getRuneName() {
        return runeName;
    }

    public static String getRuneHeadValue() {
        return runeHeadValue;
    }

    public static String getRuneEffect() {
        return runeEffect;
    }

    public static String getRuneCustomEffect() {
        return runeCustomEffect;
    }

    public static ItemStack getRuneItem() {
        return runeItem;
    }

    public static int getBuyCost() {
        return buyCost;
    }

    public static String getRuneRarity() {
        return runeRarity;
    }

    public static ArrayList <String> getLore() {
        return lore;
    }
}
