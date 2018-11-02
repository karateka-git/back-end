package com.sevenbits;

import com.sevenbits.containers.Inventory;
import com.sevenbits.stuff.armor.Armor;
import com.sevenbits.stuff.IStuff;
import com.sevenbits.stuff.armor.IArmor;
import com.sevenbits.stuff.coins.Coins;
import com.sevenbits.stuff.coins.ICoins;
import com.sevenbits.stuff.weapon.IWeapon;
import com.sevenbits.stuff.weapon.Weapon;

public class Main {
    public static void main(final String[] args) {
        IWeapon weapon = new Weapon();
        ICoins coins = new Coins();
        Inventory inventory = new Inventory();
        inventory.setItem(weapon);
        inventory.setItem(coins);
        inventory.getItem(0);
    }
}
