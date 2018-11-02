package com.sevenbits.containers;

import com.sevenbits.stuff.IStuff;

import java.util.ArrayList;

public class Chest implements IContainers{
    int MAX_LENGTH = 10;
    private ArrayList<IStuff> liststuff = new ArrayList();
    /**
     * @return IStuff
     */
    @Override
    public int getItem(final int i) {
        this.liststuff.remove(i);
        return 0;
    }

    /**
     * @param stuff stuff
     */
    @Override
    public void setItem(final IStuff stuff) {
        if (liststuff.size() >= MAX_LENGTH) return;
        this.liststuff.add(stuff);
    }
}
