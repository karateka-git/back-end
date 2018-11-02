package com.sevenbits.containers;

import com.sevenbits.stuff.IStuff;

import java.util.ArrayList;

public class Inventory implements IContainers {
    int MAX_LENGTH = 10;
    private ArrayList<IStuff> liststuff = new ArrayList();

    @Override
    public int getItem(final int i) {
        this.liststuff.remove(i);
        return 0;
    }

    @Override
    public void setItem(final IStuff stuff) {
        if (liststuff.size() >= MAX_LENGTH) return;
        this.liststuff.add(stuff);
    }
}
