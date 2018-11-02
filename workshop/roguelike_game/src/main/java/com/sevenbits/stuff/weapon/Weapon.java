package com.sevenbits.stuff.weapon;

import com.sevenbits.stuff.IStuff;

public class Weapon implements IStuff, IWeapon {
    private int power = 10;

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public IStuff getInstance() {
        return null;
    }
}
