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
    private static ArrayList<String> crafting;
    private static int changeDrop;

    private static boolean zombie;
    private static boolean slime;
    private static boolean skeleton;
    private static boolean magmacream;
    private static boolean spider;
    private static boolean creeper;


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

    public static ArrayList <String> getCrafting() {
        return crafting;
    }

    public static int getChangeDrop() {
        return changeDrop;
    }

    public static boolean isZombie() {
        return zombie;
    }

    public static boolean isSlime() {
        return slime;
    }

    public static boolean isSkeleton() {
        return skeleton;
    }

    public static boolean isMagmacream() {
        return magmacream;
    }

    public static boolean isSpider() {
        return spider;
    }

    public static boolean isCreeper() {
        return creeper;
    }

    public static void setRuneName(String runeName) {
        RunesAPI.runeName = runeName;
    }

    public static void setRuneHeadValue(String runeHeadValue) {
        RunesAPI.runeHeadValue = runeHeadValue;
    }

    public static void setRuneEffect(String runeEffect) {
        RunesAPI.runeEffect = runeEffect;
    }

    public static void setRuneCustomEffect(String runeCustomEffect) {
        RunesAPI.runeCustomEffect = runeCustomEffect;
    }

    public static void setRuneItem(ItemStack runeItem) {
        RunesAPI.runeItem = runeItem;
    }

    public static void setBuyCost(int buyCost) {
        RunesAPI.buyCost = buyCost;
    }

    public static void setRuneRarity(String runeRarity) {
        RunesAPI.runeRarity = runeRarity;
    }

    public static void setLore(ArrayList <String> lore) {
        RunesAPI.lore = lore;
    }

    public static void setCrafting(ArrayList <String> crafting) {
        RunesAPI.crafting = crafting;
    }

    public static void setChangeDrop(int changeDrop) {
        RunesAPI.changeDrop = changeDrop;
    }

    public static void setZombie(boolean zombie) {
        RunesAPI.zombie = zombie;
    }

    public static void setSlime(boolean slime) {
        RunesAPI.slime = slime;
    }

    public static void setSkeleton(boolean skeleton) {
        RunesAPI.skeleton = skeleton;
    }

    public static void setMagmacream(boolean magmacream) {
        RunesAPI.magmacream = magmacream;
    }

    public static void setSpider(boolean spider) {
        RunesAPI.spider = spider;
    }

    public static void setCreeper(boolean creeper) {
        RunesAPI.creeper = creeper;
    }


}
