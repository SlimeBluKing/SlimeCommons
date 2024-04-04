package com.slime.slimecommons.utils;

import com.slime.slimecommons.SlimeCommons;
import org.bukkit.entity.Player;

/***
 * @deprecated The class '{@link com.slime.slimecommons.utils.EconomyUtils}' is marked for removal. It didn't even work 😂
 */
@Deprecated (forRemoval = true)
public class EconomyUtils {
    public static void giveMoney(Player player, double amount){
        SlimeCommons.getInstance().getEconomy().depositPlayer(player, amount);
    }

    public static void takeMoney(Player player, double amount){
        SlimeCommons.getInstance().getEconomy().withdrawPlayer(player, amount);
    }

    public static void takeMoneyIfEnough(Player player, double amount){
        if(hasEnough(player, amount)){
            takeMoney(player, amount);
        }
    }

    public static boolean hasEnough(Player player, double amount){
        return SlimeCommons.getInstance().getEconomy().getBalance(player) >= amount;
    }

    public static double getBalance(Player player){
        return SlimeCommons.getInstance().getEconomy().getBalance(player);
    }
}
