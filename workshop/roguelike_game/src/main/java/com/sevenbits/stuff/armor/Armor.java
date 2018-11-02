package com.sevenbits.stuff.armor;

import com.sevenbits.stuff.IStuff;

public class Armor implements IStuff, IArmor {
    private String name = "Revolver";
    private int defens = 12;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDefens() {
        return defens;
    }

    private void setName(final String name) {
        this.name = name;
    }

    @Override
    public IStuff getInstance() {
        return this;
    }
}
