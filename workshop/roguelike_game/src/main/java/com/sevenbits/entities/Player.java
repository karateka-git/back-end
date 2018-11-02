package com.sevenbits.entities;

public class Player implements IEntity {
    private String name = "good";

    @Override
    public String getName() {
        return this.name;
    }
}
