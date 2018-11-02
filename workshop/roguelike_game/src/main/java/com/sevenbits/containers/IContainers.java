package com.sevenbits.containers;

import com.sevenbits.stuff.IStuff;

public interface IContainers {
    /**
     *
     * @return IStuff
     */
    int getItem(int i);
    /**
     *
     * @param stuff stuff
     */
    void setItem(IStuff stuff);
}
