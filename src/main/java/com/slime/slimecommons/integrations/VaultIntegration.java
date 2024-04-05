package com.slime.slimecommons.integrations;

import com.slime.slimecommons.SlimeCommons;
import org.bukkit.entity.Player;

public class VaultIntegration {
    public static void giveMoney(Player player, double amount) {
        SlimeCommons.getInstance().getEconomy().depositPlayer(player, amount);
    }

    public static void takeMoney(Player player, double amount) {
        SlimeCommons.getInstance().getEconomy().withdrawPlayer(player, amount);
    }

    public static void setMoney(Player player, double amount) {
        double balance = getBalance(player);

        if(balance > amount) {
            takeMoney(player, balance - amount);
        } else if (balance < amount) {
            giveMoney(player, balance - amount);
        }
    }

    public static boolean takeMoneyIfEnough(Player player, double amount) {
        if(hasEnough(player, amount)) {
            takeMoney(player, amount);
            return true;
        }

        return false;
    }

    public static boolean hasEnough(Player player, double amount) {
        return getBalance(player) >= amount;
    }

    public static double getBalance(Player player) {
        return SlimeCommons.getInstance().getEconomy().getBalance(player);
    }
}
