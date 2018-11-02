package com.sevenbits.entities;

public class Enemy implements IEntity {
    private String name = "evil";

    @Override
    public String getName() {
        return this.name;
    }
}
