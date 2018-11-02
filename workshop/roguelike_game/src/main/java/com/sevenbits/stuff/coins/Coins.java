package com.sevenbits.stuff.coins;

import com.sevenbits.stuff.IStuff;

public class Coins implements IStuff, ICoins {
    private int amount = 13;

    @Override
    public int getAmount() {
        return this.amount;
    }

    private void setAmount(final int amount) {
        this.amount = amount;
    }

    @Override
    public IStuff getInstance() {
        return null;
    }
}
